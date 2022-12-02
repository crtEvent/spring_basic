package com.springbasic.ch4.board.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springbasic.ch4.board.dto.BoardDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardDaoImplTest {
	
	@Autowired
	BoardDao boardDao;
	
	@Test
	public void select() throws Exception {
		// boardDao가 주입됐는지 test
		System.out.println("boardDao = "+boardDao);
		assertTrue(boardDao != null);
		
		// select()에서 테이블 정보를 잘 불러오는지 test
		int bno = 167;
		BoardDto dto = boardDao.select(bno);
		System.out.println("dto.getBno() = " + dto.getBno());
		assertTrue(dto.getBno() == bno);
	}

}
