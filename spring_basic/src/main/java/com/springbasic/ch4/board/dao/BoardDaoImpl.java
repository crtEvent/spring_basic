package com.springbasic.ch4.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbasic.ch4.board.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSession session;
	private static String namespace = "com.springbasic.ch4.board.dao.BoardMapper.";
	
	@Override
	public BoardDto select(int bno) throws Exception {
		return session.selectOne(namespace + "select", bno);
	}

	@Override
	public List<BoardDto> selectAll() throws Exception {
		return session.selectList(namespace + "selectAll");
	}
	
	@Override
    public List<BoardDto> selectPage(int offset, int pageSize) throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("offset", offset);
		map.put("pageSize", pageSize);
        return session.selectList(namespace+"selectPage", map);
    }
	
	@Override
	public int count() throws Exception {
        return session.selectOne(namespace+"count");
    }
	
	@Override
	public int insert(BoardDto dto) throws Exception {
        return session.insert(namespace+"insert", dto);
    }
	
	@Override
    public int update(BoardDto dto) throws Exception {
        return session.update(namespace+"update", dto);
    }
	
	@Override
    public int delete(Integer bno, String writer) throws Exception {
        Map map = new HashMap();
        map.put("bno", bno);
        map.put("writer", writer);
        return session.delete(namespace+"delete", map);
    }
}
