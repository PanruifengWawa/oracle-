package com.oracle.course.service;

import com.oracle.course.datawrapper.DataWrapper;
import com.oracle.course.models.User;

public interface UserService {
	DataWrapper<Void> register(String userName,String password,String email);
	DataWrapper<String> login(String userName,String password);
	
	DataWrapper<User> getUserDetails(String token);
	DataWrapper<Void> updateUser(String birthday,String email,String token);
	
	
	
}
