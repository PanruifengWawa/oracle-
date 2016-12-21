package com.oracle.course.dao.impl;

import org.springframework.stereotype.Repository;

import com.oracle.course.dao.BaseDao;
import com.oracle.course.dao.UserDao;
import com.oracle.course.models.User;


@Repository
public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return save(user);
	}

}
