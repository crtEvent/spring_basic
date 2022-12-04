package com.springbasic.ch4.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbasic.ch4.board.dao.BoardDao;
import com.springbasic.ch4.board.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDao boardDao;
	
	@Override
    public BoardDto read(Integer bno) throws Exception {
        BoardDto boardDto = boardDao.select(bno);
        return boardDto;
    }

	@Override
    public List<BoardDto> getList() throws Exception {
        return boardDao.selectAll();
    }

	@Override
    public List<BoardDto> getPage(int offset, int pageSize) throws Exception {
        return boardDao.selectPage(offset, pageSize);
    }
	
	@Override
    public int getCount() throws Exception {
        return boardDao.count();
    }
	
}
