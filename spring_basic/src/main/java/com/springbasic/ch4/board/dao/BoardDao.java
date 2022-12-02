package com.springbasic.ch4.board.dao;

import com.springbasic.ch4.board.dto.BoardDto;

public interface BoardDao {
	public BoardDto select(int bno) throws Exception;
	
}
