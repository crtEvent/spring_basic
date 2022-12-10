package com.springbasic.ch4.user.dao;

import com.springbasic.ch4.user.domain.User;

public interface UserDao {
	User selectUser(String id) throws Exception;
	int insertUser(User user) throws Exception;
	
}
