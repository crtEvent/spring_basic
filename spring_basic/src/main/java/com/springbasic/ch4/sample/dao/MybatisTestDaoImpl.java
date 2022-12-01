package com.springbasic.ch4.sample.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisTestDaoImpl implements MybatisTestDao {
	@Autowired
    private SqlSession session;
    private static String namespace = "com.springbasic.ch4.sample.dao.MybatisTestMapper.";
    
    public String selectServerTime() {
		return session.selectOne(namespace+"selectServerTime");
    }
	
}
