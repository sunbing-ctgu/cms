package com.jiantong.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("test")
public class TestController {
	
	@RequestMapping("/home")
	public String home(HttpServletRequest request, Model model) {
		return "test";
	}
	
}
