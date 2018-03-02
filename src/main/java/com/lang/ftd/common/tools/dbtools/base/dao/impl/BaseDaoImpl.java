package com.lang.ftd.common.tools.dbtools.base.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.lang.ftd.common.SysConst.SortBy;
import com.lang.ftd.common.tools.dbtools.base.dao.BaseDao;
import com.lang.ftd.common.tools.dbtools.base.utils.GenericsUtils;
import com.lang.ftd.common.tools.dbtools.base.utils.PageBean;

//@Repository("baseDaoImpl")
public class BaseDaoImpl<T> implements BaseDao<T> {

	// 从spring注入原有的sqlSessionTemplate
	@Autowired
	private SqlSession sqlSession;

	protected Class<T> entityClass;
	protected String sqlMapNamespace;

	public static final String POSTFIX_SELECT = ".select";
	public static final String POSTFIX_INSERT = ".insert";
	public static final String POSTFIX_UPDATE = ".update";
	public static final String POSTFIX_UPDATE_SELECTIVE = ".update4Selective";
	public static final String POSTFIX_DELETE_PK = ".deleteByPrimaryKey";
	public static final String POSTFIX_DELETE = ".delete";
	public static final String POSTFIX_SELECT_MAP = ".selectByMap";
	public static final String POSTFIX_SELECT_COUNT = ".selectCount";
	public static final String POSTFIX_SELECT_PAGE = ".selectPage";
	public static final String POSTFIX_INSERT_BATCH = ".insertBatch";
	public static final String POSTFIX_SELECT_IDS = ".selectByIds";

	public String getSqlMapNamespace() {
		return sqlMapNamespace;
	}

	protected SqlSession getSqlSession() {
		return sqlSession;
	}

	/**
	 * 在构造函数中将泛型T.class赋给entityClass. sqlNamespace 带包名
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		entityClass = GenericsUtils.getSuperClassGenricType(getClass());
		sqlMapNamespace = entityClass.getName();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(String id) {
		if (id == null)
			return null;// 如果id为空,不再查询
		return (T) sqlSession.selectOne(sqlMapNamespace + POSTFIX_SELECT, id);
	}

	@Override
	public int insert(T o) {
		return sqlSession.insert(sqlMapNamespace + POSTFIX_INSERT, o);
	}

	@Override
	public int update(T o) {
		return sqlSession.update(sqlMapNamespace + POSTFIX_UPDATE, o);
	}

	@Override
	public int update4Selective(T o) {
		return sqlSession.update(sqlMapNamespace + POSTFIX_UPDATE_SELECTIVE, o);
	}

	@Override
	public int delete(String id) {
		return sqlSession.delete(sqlMapNamespace + POSTFIX_DELETE_PK, id);
	}

	@Override
	public int delete(T o) {
		return sqlSession.delete(sqlMapNamespace + POSTFIX_DELETE, o);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return sqlSession.selectList(sqlMapNamespace + POSTFIX_SELECT);
	}

	@Override
	public List<T> findBy(String name, Object value) {
		Assert.hasText(name,"'name' must not be empty");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(name, value);
		return findByMap(map);
	}

	@Override
	public List<T> findBy(String name, Object value, boolean isLike, String sortName, SortBy sortBy) {
		Assert.hasText(name,"'name' must not be empty");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(name, value);
		return findByMap(map, isLike, sortName, sortBy);
	}

	@Override
	public List<T> findBy(String name, Object value, boolean isLike) {
		Assert.hasText(name,"'name' must not be empty");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(name, value);
		return findByMap(map, isLike, null, null);
	}

	@Override
	public List<T> findBy(String name, Object value, String sortName, SortBy sortBy) {
		Assert.hasText(name,"'name' must not be empty");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(name, value);
		return findByMap(map, false, sortName, sortBy);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findUniqueBy(String name, Object value) {
		Assert.hasText(name,"'name' must not be empty");
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map.put(name, value);
			map.put("findBy", "True");
			return (T) sqlSession.selectOne(sqlMapNamespace + POSTFIX_SELECT_MAP, map);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<T> findByMap(Map<String, Object> map) {
		if (map == null)
			return findAll();
		return findByMap(map, false, null, null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findUniqueByMap(Map<String, Object> map) {
		try {
			map.put("findBy", "true");
			return (T) sqlSession.selectOne(sqlMapNamespace + POSTFIX_SELECT_MAP, map);
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByMap(Map<String, Object> map, boolean isLike, String sortName, SortBy sortBy) {
		if (map == null)
			return findAll();
		if (isLike) {
			map.put("findByLike", "true");
		} else {
			map.put("findBy", "true");
		}
		if (StringUtils.isNotEmpty(sortName)) {
			// 需要对sortName做过滤,防止sql注入
			if (sortName.indexOf("'") != -1)
				sortName.replace("'", "");
			map.put("sortName", sortName);
			map.put("sortBy", sortBy.getCode());
		}
		return sqlSession.selectList(sqlMapNamespace + POSTFIX_SELECT_MAP, map);
	}

	@Override
	public List<T> findByMap(Map<String, Object> map, boolean isLike) {
		return findByMap(map, isLike, null, null);
	}

	@Override
	public List<T> findByMap(Map<String, Object> map, String sortName, SortBy sortBy) {
		return findByMap(map, false, sortName, sortBy);
	}

	@Override
	public void find4Page(PageBean<T> pageBean, Map<String, Object> map) {
		find4Page(pageBean, map, false, null, null);
	}

	@Override
	public void find4Page(PageBean<T> pageBean, Map<String, Object> map, boolean isLike) {
		find4Page(pageBean, map, isLike, null, null);
	}

	@Override
	public void find4Page(PageBean<T> pageBean, Map<String, Object> map, String sortName, SortBy sortBy) {
		find4Page(pageBean, map, false, sortName, sortBy);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void find4Page(PageBean<T> pageBean, Map<String, Object> map, boolean isLike, String sortName,
			SortBy sortBy) {
		if (map == null)
			map = new HashMap<String, Object>();
		if (isLike) {
			map.put("findByLike", "true");
		} else {
			map.put("findBy", "true");
		}
		Integer totalRows = (Integer) sqlSession.selectOne(sqlMapNamespace + POSTFIX_SELECT_COUNT, map);
		pageBean.setTotalRows(totalRows);
		if (totalRows != null && totalRows > 0) {
			map.put("startRow", pageBean.getSimpleStartRow());
			map.put("pageSize", pageBean.getPageRecorders());
			if (StringUtils.isNotEmpty(sortName)) {
				if (sortName.indexOf("'") != -1)
					sortName.replace("'", "");
				map.put("sortName", sortName);
				map.put("sortBy", sortBy.getCode());
			}
			List<T> list = sqlSession.selectList(sqlMapNamespace + POSTFIX_SELECT_PAGE, map);
			pageBean.setObjList(list);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByIds(String ids) {
		ids = checkSqlParam(ids);
		return sqlSession.selectList(sqlMapNamespace + POSTFIX_SELECT_IDS, ids);
	}

	/**
	 * 参数校验, 防止sql注入
	 * 
	 * @param param
	 * @return
	 * @Author: wangxingfei
	 * @Date: 2015年7月23日
	 */
	protected String checkSqlParam(String param) {
		if (StringUtils.isEmpty(param))
			return "";
		if (param.indexOf("'") != -1) {
			param = param.replace("'", "");
		}
		return param;
	}

}
