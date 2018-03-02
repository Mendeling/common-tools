package com.lang.ftd.common.tools.exception;


public class SystemException extends Exception{

	private String code;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public SystemException(SystemExceptionEnum exceptionEnum) {
		 super(exceptionEnum.getMessage());
		 this.code = exceptionEnum.getCode();
	}
}
