package com.oracle.course.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.course.dao.UserDao;
import com.oracle.course.datawrapper.DataWrapper;
import com.oracle.course.enums.CodeEnum;
import com.oracle.course.models.User;
import com.oracle.course.service.UserService;
import com.oracle.course.utils.DateUtil;
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
			dataWrapper.setCode(CodeEnum.Fail.getCode());
		}
		return dataWrapper;
	}

	@Override
	public DataWrapper<String> login(String userName, String password) {
		// TODO Auto-generated method stub
		DataWrapper<String> dataWrapper = new DataWrapper<String>();
		String token = userDao.getUserToken(userName, password);
		
		if (token == null) {
			dataWrapper.setCode(CodeEnum.Fail.getCode());
		}
		
		dataWrapper.setData(token);
		return dataWrapper;
	}

	@Override
	public DataWrapper<User> getUserDetails(String token) {
		// TODO Auto-generated method stub
		DataWrapper<User> dataWrapper = new DataWrapper<User>();
		User user = userDao.getUserByToken(token);
		
		if (user == null) {
			dataWrapper.setCode(CodeEnum.Fail.getCode());
		}
		
		dataWrapper.setData(user);
		return dataWrapper;
	}

	@Override
	public DataWrapper<Void> updateUser(String birthday, String email, String token) {
		// TODO Auto-generated method stub
		DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
		Date newBirthday = DateUtil.StrToDate(birthday);
		if (newBirthday == null || email == null) {
			dataWrapper.setCode(CodeEnum.Fail.getCode());
		} else {
			Integer flag = userDao.updateUser(newBirthday, email, token);
			if (flag == 0) {
				dataWrapper.setCode(CodeEnum.Fail.getCode());
			}
		}
		return dataWrapper;
	}

}
