package com.oracle.course.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.course.dao.UserDao;
import com.oracle.course.datawrapper.DataWrapper;
import com.oracle.course.enums.CodeEnum;
import com.oracle.course.models.User;
import com.oracle.course.service.UserService;
import com.oracle.course.utils.UUIDGenerator;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public DataWrapper<Void> register(String userName, String password,String email) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setToken(UUIDGenerator.getCode(userName));
		user.setIlevel(0);
		user.setConsumedMoney(new Double(0));
		user.setEmail(email);
		DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
		if (!userDao.addUser(user)) {
			dataWrapper.setCode(CodeEnum.Fail);
		}
		return dataWrapper;
	}

}
