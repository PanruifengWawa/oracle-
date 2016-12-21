package com.oracle.course.datawrapper;

import com.oracle.course.enums.CodeEnum;

public class DataWrapper<T>  {

    private T data;
    private CodeEnum code;

    public DataWrapper() {
        code = CodeEnum.Success;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


	public CodeEnum getCode() {
		return code;
	}


	public void setCode(CodeEnum code) {
		this.code = code;
	}

    
}