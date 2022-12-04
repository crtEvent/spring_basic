package com.springbasic.ch4.board.service;

import java.util.List;
import java.util.Map;

import com.springbasic.ch4.board.dto.BoardDto;

public interface BoardService {
	public BoardDto read(Integer bno) throws Exception;
	public List<BoardDto> getList() throws Exception;
	public List<BoardDto> getPage(int offset, int pageSize) throws Exception;
	
}
