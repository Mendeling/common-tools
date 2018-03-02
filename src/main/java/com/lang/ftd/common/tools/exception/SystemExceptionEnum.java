package com.lang.ftd.common.tools.exception;

public enum SystemExceptionEnum {
	SystemError("SYS10001","系统错误，请稍后重试"),
	
	CANT_FIND_BY_ID("SQL20001","查无此id的系统"),
	INSERT_PARAMS_WRONG("SQL20002","插入操作，参数错误"),
	INSERT_PROCESS_ERROR("SQL20003","插入操作，系统错误"),
	FIND_TIMEOUT_BY_ID("SQL20004","检索信息已过期"),
	UPDATE_PARAMS_WRONG("SQL20005","插入操作，参数错误"),
	UPDATE_PROCESS_ERROR("SQL20006","插入操作，系统错误");
	
	private String message;
	private String code;
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	private SystemExceptionEnum(String code,String message){
		this.message = message;
		this.code = code;
	}
}
