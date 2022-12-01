package com.springbasic.ch4.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbasic.ch4.sample.dao.MybatisTestDao;

@Service
public class MybatisTestServiceImpl implements MybatisTestService {
	@Autowired
	MybatisTestDao dao;
	
	public String getServerTime() {
		return dao.selectServerTime();
	}
}
