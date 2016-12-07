package com.oracle.course.datawrapper;


public class DataWrapper<T>  {

    private T data;
    private Long code;

    public DataWrapper() {
        code = new Long(0);
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


	public Long getCode() {
		return code;
	}


	public void setCode(Long code) {
		this.code = code;
	}

    
}