package com.oracle.course.dao;

import java.util.Date;

import com.oracle.course.models.User;

public interface UserDao {
	boolean addUser(User user);
	String getUserToken(String userName,String password);
	User getUserByToken(String token);
	Integer updateUser(Date birthday, String email, String token);
}
