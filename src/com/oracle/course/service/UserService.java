package com.oracle.course.service;

import com.oracle.course.datawrapper.DataWrapper;

public interface UserService {
	DataWrapper<Void> register(String userName,String password,String email);
}
