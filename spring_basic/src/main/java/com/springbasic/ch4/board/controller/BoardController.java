package com.springbasic.ch4.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbasic.ch4.board.domain.PageHandler;
import com.springbasic.ch4.board.dto.BoardDto;
import com.springbasic.ch4.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@GetMapping("/list")
	public String list(Model model, Integer page, Integer pageSize) {
		
		if(page == null) page = 1;
		if(pageSize == null) pageSize = 10;
		
		try {
			List<BoardDto> list = 
			boardService.getPage((page-1)*pageSize, pageSize);
			
			model.addAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "boardList";
	}
}
