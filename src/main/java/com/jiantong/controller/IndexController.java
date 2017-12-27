package com.jiantong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 网站欢迎首页
 * @author sunbing
 *
 */
@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
}
