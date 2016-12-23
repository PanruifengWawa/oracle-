package com.oracle.course.datawrapper;

import com.oracle.course.enums.CodeEnum;

public class DataWrapper<T>  {

    private T data;
    private Integer code;

    public DataWrapper() {
        code = CodeEnum.Success.getCode();
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


	public Integer getCode() {
		return code;
	}


	public void setCode(Integer code) {
		this.code = code;
	}

    
}