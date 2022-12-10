package com.springbasic.ch4.user.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbasic.ch4.user.domain.User;
import com.springbasic.ch4.user.domain.UserValidator;
import com.springbasic.ch4.user.service.UserService;


@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	UserService userService;
	
	final int FAIL = 0;
	
	@InitBinder
	public void toDate(WebDataBinder binder) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		binder.setValidator(new UserValidator());
	}
	
	@GetMapping("/add")
	public String registerForm() {
		return "registerForm";
	}
	
	
	@PostMapping("/add")
	public String regist(@Valid User user, BindingResult result, Model m) throws Exception {
		// User객체를 검증한 결과 에러가 있으면, registerForm을 이용해서 에러를 보여줘야 함.
		if(!result.hasErrors()) {
			// 1. error가 없으면 DB에 신규회원 정보를 저장 
			int rowCnt = userService.registUser(user);
			
			if(rowCnt != FAIL) {
				return "loginForm";
			}
		}
		
		// 2. error가 있으면 다시 회원가입 페이지로 이동
		return "registerForm"; 
	}
}
