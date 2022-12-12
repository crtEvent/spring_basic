package com.springbasic.ch4.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
			int totalCnt = boardService.getCount();
			PageHandler pageHandler = new PageHandler(totalCnt, page, pageSize);
			
			List<BoardDto> list = 
			boardService.getPage((page-1)*pageSize, pageSize);
			
			model.addAttribute("list", list);
			model.addAttribute("pageHandler", pageHandler);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "boardList";
	}
	
	@GetMapping("/read")
    public String read(Integer bno, Integer page, Integer pageSize, RedirectAttributes rattr, Model m) {
        try {
            BoardDto boardDto = boardService.read(bno);
            m.addAttribute(boardDto);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addAttribute("page", page);
            rattr.addAttribute("pageSize", pageSize);
            return "redirect:/board/list";
        }

        return "board";
    }
	
	@GetMapping("/write")
    public String write(Model m) {
        m.addAttribute("mode", "new");

        return "board";
    }
	
	@PostMapping("/write")
    public String write(BoardDto boardDto, RedirectAttributes rattr, Model m, HttpSession session) {
        String writer = (String)session.getAttribute("id");
        boardDto.setWriter(writer);

        try {
            if (boardService.write(boardDto) != 1)
                throw new Exception("Write failed.");

            rattr.addFlashAttribute("msg", "WRT_OK");
            return "redirect:/board/list";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute(boardDto);
            m.addAttribute("mode", "new");
            m.addAttribute("msg", "WRT_ERR");
            return "board";
        }
    }
	
	@PostMapping("/modify")
    public String modify(BoardDto boardDto, RedirectAttributes rattr, Model m, HttpSession session) {
        String writer = (String)session.getAttribute("id");
        boardDto.setWriter(writer);

        try {
            if (boardService.modify(boardDto)!= 1)
                throw new Exception("Modify failed.");

            rattr.addFlashAttribute("msg", "MOD_OK");
            return "redirect:/board/list";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute(boardDto);
            m.addAttribute("msg", "MOD_ERR");
            return "board";
        }
    }
}
