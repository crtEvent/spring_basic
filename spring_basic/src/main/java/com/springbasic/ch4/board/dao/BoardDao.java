package com.springbasic.ch4.board.dao;

import java.util.List;
import java.util.Map;

import com.springbasic.ch4.board.dto.BoardDto;

public interface BoardDao {
	public BoardDto select(int bno) throws Exception;
	public List<BoardDto> selectAll() throws Exception;
	public List<BoardDto> selectPage(int offset, int pageSize) throws Exception;
	public int count() throws Exception;
	public int insert(BoardDto dto) throws Exception;
	public int update(BoardDto dto) throws Exception;
	
}
