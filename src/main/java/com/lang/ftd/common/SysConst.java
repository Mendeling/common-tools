package com.lang.ftd.common;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;

/**
  **********************************
	* @Description: TODO
	* @author: langjun
	* @createdAt: 2017年10月12日下午5:56:29
	**********************************
 */
public class SysConst {
	
	/**
	 * 是否过期
	 */
	public enum Expired{
		OUT_DUE(0),IN_DUE(1);
		private Integer value;
		Expired(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	public enum Publish{
		IS_NOT_PUBLISH(0),IS_PUBLISH(1);
		private Integer value;
		Publish(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	public enum Gender{
		WEMAN(0),MAN(1);
		private Integer value;
		Gender(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	public enum Forbidden{
		IS_FORBIDDEN(0),IS_NOT_FORBIDDEN(1);
		private Integer value;
		Forbidden(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	public enum FirstLoginTip{
		HAS_NOT_LOGIN(0),HAS_LOGIN(1);
		private Integer value;
		FirstLoginTip(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	public enum RoleType{
		ADMIN(0),TEACHER(1),STUDENT(2);
		private Integer value;
		RoleType(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	public enum RegisterType{
		SELF(0),MANUAL(1);
		private Integer value;
		RegisterType(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	public enum TokenType{
		TIMEOUT(0),FOREVER(1);
		private Integer value;
		TokenType(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
		public static boolean contain(Integer code){
			if(Optional.ofNullable(code).isPresent()){
				return Arrays.asList(TokenType.values()).stream().map(TokenType::getCode).collect(Collectors.toList()).contains(code);
			}
			return false;
		}
		public static void main(String[] args) {
			System.out.println(TokenType.contain(1));
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 老师等级操作明细
	 * @author wxf
	 *
	 */
	public enum TeacLevelOperationType{
		结课(1,1),备考规划(2,5),退费(3,-5),缺课(4,-1),差评(5,-1),好评(6,1);
		private Integer code;//类型
		private Integer operationScore;//操作分数
		TeacLevelOperationType(Integer code,Integer operationScore){
			this.code = code;
			this.operationScore= operationScore;
		}
		public Integer getCode(){
			return this.code;
		}
		public Integer getOperationScore(){
			return this.operationScore;
		}
	}
	
	
	/**
	 * 用户类型
	 * *********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2015年6月19日下午5:56:29
	**********************************
	 */
	public enum UserType{
		正式(1),未注册(2);
		private Integer value;
		UserType(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	/**
	 * 排序方式
	 * @author Administrator
	 *
	 */
	public enum SortBy{
		正序("ASC"),倒序("DESC");
		private String value;
		SortBy(String value){
			this.value = value;
		}
		public String getCode(){
			return this.value;
		}
	}
	
	/**
	 * 学生选课 需求 状态
	 * *********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2015年5月22日上午10:44:25
	**********************************
	 */
	public enum ReqStatus{
		待支付(0),等待老师抢课(1),已有老师抢课(2),等待上课(3),选择老师超时(4),无空闲老师或教室(5),已完成(6),预约已过期(7);
		private Integer value;
		ReqStatus(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	
	/**
	 * 老师抢课 队列求 状态
	 * *********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2015年5月22日上午10:44:25
	**********************************
	 */
	public enum QueueStatus{
		等待学生选择(0),课表已确认(1),没有被选中(2),学生直接预约(3);
		private Integer value;
		QueueStatus(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	/**
	 * 接口日志 类型
	 **********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2015年5月28日上午10:57:06
	**********************************
	 */
	public enum LogType{
		发送(1),接收(2);
		private Integer value;
		LogType(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	/**
	 * 接口日志 状态
	 * *********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2015年5月28日上午10:57:33
	**********************************
	 */
	public enum LogStatus{
		成功(0),失败(1);
		private Integer value;
		LogStatus(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	/**
	 * 上课类型
	 * *********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2015年6月4日下午3:07:06
	**********************************
	 */
	public enum LessonType{
		在线(1),面授(2);
		private Integer value;
		LessonType(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	/**
	 * 老师端 课程 状态
	 * *********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2015年7月24日下午5:48:12
	**********************************
	 */
	public enum TeacherLessonStatus{
		正常(0),已取消(1),可以取消(2),已修改可以取消(3),已修改不可取消(4),等待确认申诉(5),已确认缺课(6),申诉已被驳回(7);
		private Integer value;
		TeacherLessonStatus(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	/**
	 * 学生端 课程 状态
	 * *********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2015年7月24日下午5:48:12
	**********************************
	 */
	public enum StudentLessonStatus{
		正常(0),已退款(1),可以取消修改(2),可以取消重选(3),已修改不可修改(4),可申诉(5),申诉中(6),不可取消可重选(7),申诉已被驳回(8);
		private Integer value;
		StudentLessonStatus(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	/**
	 * 课程 数据库 状态
	 * *********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2015年7月24日下午5:48:12
	**********************************
	 */
	public enum LessonStatus{
		正常(0),已退款(1),学生未改_老师已改_未重选(2),学生已改_老师未改(3),学生未改_老师已改_已重选(4),
		申诉中(5),老师已确认缺课(6),老师已缺课等待学生操作(7),学生已改_老师已改_未重选(8),学生已改_老师已改_已重选(9),
		申诉已驳回(10);
		private Integer value;
		LessonStatus(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
		
		/**
		 * 根据code找枚举
		* @param status
		* @return
		* @Author: wangxingfei
		* @Date: 2015年8月6日
		 */
		public static LessonStatus code2Eunm(Integer status) {
			for(LessonStatus ls :LessonStatus.values()){
				if(ls.getCode().equals(status)){
					return ls;
				}
			}
			return null;
		}
	}
	
	/**
	 * 课表操作类型
	 * *********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2015年7月25日下午3:22:45
	**********************************
	 */
	public enum LessonOperationType{
		老师取消,老师确认缺课,学生退款,学生调课,学生重选,学生申诉,老师驳回申诉;
	}
	
	
	/**
	 * 推送消息  情景id	(学生端)
	 * *********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2015年7月24日下午5:48:12
	**********************************
	 */
	public enum SenceTypeStud{
		有老师抢课(101),确认老师超时(102),需求预约已过期(103),无空闲老师或教师(104),上课前一小时(105),老师取消课程(106),老师确认缺课(107),钱包提现(301),直播课前一小时(108);
		private Integer value;
		SenceTypeStud(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	/**
	 * 推送消息  情景id	(老师端)
	 * *********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2015年7月24日下午5:48:12
	**********************************
	 */
	public enum SenceTypeTeac{
		学生提交课程(201),学生确认老师(202),学生修改课表(203),学生取消课表(204),学生提交申诉(205),学生重选课程(206)
		,提现申请(301),提现成功(302),提现失败(303);
		private Integer value;
		SenceTypeTeac(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	/**
	 * 推送消息  模块id
	 * *********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2015年7月24日下午5:48:12
	**********************************
	 */
	public enum MsgContentType{
		需求(101),课程(102),钱包提现(103);
		private Integer value;
		MsgContentType(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	/**
	 * 客户端	来源 类型
	 * *********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2015年8月19日下午4:07:44
	**********************************
	 */
	public enum FromType{
		web,ios,android,enterprise,yzAndroid,yzEnterprise;
		//判断类型是否正确
		public static boolean contains(String type){
			boolean b = false;
			if(StringUtils.isNotBlank(type)){
				for(FromType ft :FromType.values()){
					if(ft.toString().equalsIgnoreCase(type)){
						b = true;
						break;
					}
				}
			}
			return b;
		}
	}
	
	/**
	 * 保分计划操作类型
	 * *********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2015年8月19日下午9:35:06
	**********************************
	 */
	public enum PlanOperationType{
		开始挑战(1),重新开始(2),完成挑战(3),购买在线(4),购买面授(5),完成后重新开始挑战(6)
		,购买在线服务(7),购买面授服务(8),解锁计划(9);
		private Integer value;
		PlanOperationType(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	/**
	 * 计划进度状态
	 * *********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2015年8月22日上午10:56:23
	**********************************
	 */
	public enum PlanProgressStatus{
		未解锁(-1),进行中(1),已完成(3);
		private Integer value;
		PlanProgressStatus(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	/**
	 * 保分类型
	 * *********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2015年8月22日上午11:29:42
	**********************************
	 */
	public enum BfType{
		免费(0),在线(1),面授(2);
		private Integer value;
		BfType(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	/**
	 * 学生保分计划状态
	 * *********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2015年8月22日上午11:56:47
	**********************************
	 */
	public enum UserPlanStatus{
		进行中(1),夭折(2),完成(3);
		private Integer value;
		UserPlanStatus(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	/**
	 * 作业批改状态
	 * *********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2015年8月28日上午10:05:29
	**********************************
	 */
	public enum CorrectionStatus{
		待抢(0),已批(1),待选老师(3),已保存(4),待批改(6);
		private Integer value;
		CorrectionStatus(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	/**
	 * 批改提交时,对应的模块名称
	 * *********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2015年8月28日上午10:20:01
	**********************************
	 */
	public enum CorrectionModuleName{
		BF_ORAL_JJ(1),BF_WRITING_JJ(2),BF_TPOZHXZ(2),BF_TPOZHKY(1)
		,YZ_ORAL_JH(1),YZ_ORAL_JJ(1),YZ_WRITING_JJ(2),YZ_TPOZHKY(1),YZ_TPOZHXZ(2);
		private Integer value;
		CorrectionModuleName(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	/**
	 * 作业类别
	 * *********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2015年8月29日下午2:27:56
	**********************************
	 */
	public enum ExerciseType{
		口语(1),写作(2);
		private Integer value;
		ExerciseType(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	/**
	 * 保分计划解锁状态
	 * *********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2015年10月28日上午10:46:22
	**********************************
	 */
	public enum DeblockStatus{
		成功解锁(1),未解锁先做题(2),非法解锁(3);
		private Integer value;
		DeblockStatus(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	
	/**
	 * 排行榜类型
	 * *********************************
	* @Description: TODO
	* @author: zongyannan
	* @createdAt: 2015年11月23日上午11:03:59
	**********************************
	 */
	public enum OtherDayTopType{
		昨日排行榜(1),上周排行榜(2);
		private Integer value;
		private OtherDayTopType(Integer value) {
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	/**
	 * 测评状态
	 * *********************************
	* @Description: TODO
	* @author: zongyannan
	* @createdAt: 2015年11月23日上午11:04:15
	**********************************
	 */
	public enum CpUserProgressStatus{
		未进行(0),进行中(1),听写完成(2),听写下一模块进行中(3),放弃(4),失败(5),成功(6);
		private Integer value;
		CpUserProgressStatus(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	/**
	 * 
	 * *********************************
	* @Description: TODO
	* @author: zongyannan
	* @createdAt: 2015年11月23日上午11:08:20
	**********************************
	 */
	public enum ExerciseModuleType{
		听写(1),听力刷题(8),跟读(9),复述(10),背诵(26),阅读词汇(41)
		,语法(42),阅读刷题(45),记忆复写(61),综合填空(64);
		private Integer value;
		ExerciseModuleType(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	/**
	 * 测评练习状态
	 * *********************************
	* @Description: TODO
	* @author: zongyannan
	* @createdAt: 2015年11月30日下午2:20:55
	**********************************
	 */
	public enum CpExerciseResultStatus{
		未通过(-1),通过不是最后模块(1),通过是最后模块(2);
		private Integer value;
		CpExerciseResultStatus(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	/**
	 * 测评对应订单详情状态
	 * *********************************
	* @Description: TODO
	* @author: zongyannan
	* @createdAt: 2015年12月1日下午4:37:14
	**********************************
	 */
	public enum OrderDetailStatus{
		已申请(2),测评通过(5),继续测评(6),测评未通过(7);
		private Integer value;
		OrderDetailStatus(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	public enum OrderStatus{
		已支付(1),待付款(2),已取消(3),预定中(4),退款中(5),已退款(6);
		private Integer value;
		OrderStatus(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	public enum CoursesDayType{
		周一至周五(1),周六(2),周日(3),一三五(4),每天(5),周四(6);
		private Integer value;
		CoursesDayType(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	public enum VipProductId{
		基础会员(172),铁杆会员(173),VIP会员(174);
		private Integer value;
		VipProductId(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	public enum ProductTypeId{
		平日基础班(43),周末强化班(44),一元好课(45),大湿冲刺班(46),考前那一夜(47);
		private Integer value;
		ProductTypeId(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	

}
