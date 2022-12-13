package com.springbasic.ch4.board.service;

import java.util.List;
import java.util.Map;

import com.springbasic.ch4.board.domain.SearchCondition;
import com.springbasic.ch4.board.dto.BoardDto;

public interface BoardService {
	public BoardDto read(Integer bno) throws Exception;
	public List<BoardDto> getList() throws Exception;
	public List<BoardDto> getPage(int offset, int pageSize) throws Exception;
	public int getCount() throws Exception;
	public int write(BoardDto boardDto) throws Exception;
	public int modify(BoardDto boardDto) throws Exception;
	public int remove(Integer bno, String writer) throws Exception;
	public int getSearchResultCnt(SearchCondition sc) throws Exception;
	public List<BoardDto> getSearchResultPage(SearchCondition sc) throws Exception;
	
}
