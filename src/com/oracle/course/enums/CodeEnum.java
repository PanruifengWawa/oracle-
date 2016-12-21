package com.oracle.course.enums;

public enum CodeEnum {
	Success(0),
	Fail(1);
	
	private Integer code;
	
	private CodeEnum(Integer code) {
		// TODO Auto-generated constructor stub
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	

}
