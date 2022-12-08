package com.springbasic.ch4.user.service;

import com.springbasic.ch4.user.domain.User;

public interface UserService {
	public User getUser(String id) throws Exception;

}
