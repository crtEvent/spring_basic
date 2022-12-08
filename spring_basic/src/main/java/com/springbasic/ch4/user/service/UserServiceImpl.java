package com.springbasic.ch4.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbasic.ch4.user.dao.UserDao;
import com.springbasic.ch4.user.domain.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
	
	public User getUser(String id) throws Exception {
		return userDao.selectUser(id);
	}
}
