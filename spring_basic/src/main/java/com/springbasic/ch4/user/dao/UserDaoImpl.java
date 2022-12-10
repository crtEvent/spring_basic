package com.springbasic.ch4.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbasic.ch4.user.domain.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SqlSession session;
	private static String namespace = "com.springbasic.ch4.user.dao.UserMapper.";
	
	@Override
    public User selectUser(String id) throws Exception {
		return session.selectOne(namespace + "select", id);
	}

	@Override
    public int insertUser(User user) throws Exception {
		return session.insert(namespace + "insert", user);
	}
	
}
