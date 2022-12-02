package com.springbasic.ch4.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbasic.ch4.board.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSession session;
	private static String namespace = "com.springbasic.ch4.board.dao.BoardMapper.";
	
	public BoardDto select(int bno) throws Exception {
		return session.selectOne(namespace+"select", bno);
	}
}
