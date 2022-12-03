package com.springbasic.ch4.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.springbasic.ch4.board.domain.PageHandler;

public class PageHandlerTest {
	
	@Test
	public void test() {
		PageHandler ph;
		
		ph = new PageHandler(258, 1);
		ph.print();
		assertTrue(ph.getBeginPage() == 1);
		assertTrue(ph.getEndPage() == 10);
		
		ph = new PageHandler(250, 11);
		ph.print();
		assertTrue(ph.getBeginPage() == 11);
		assertTrue(ph.getEndPage() == 20);
		
		ph = new PageHandler(255, 25);
		ph.print();
		assertTrue(ph.getBeginPage() == 21);
		assertTrue(ph.getEndPage() == 26);
	}

}
