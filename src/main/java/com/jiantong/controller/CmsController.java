package com.jiantong.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "")
public class CmsController {

	@RequestMapping(value = "/{columnPath}", method = RequestMethod.GET)
	public String getArticleList(HttpServletRequest request, @PathVariable String columnPath) {
		System.out.println(columnPath);
		return "index";
	}
	@RequestMapping(value = "/{columnPath}/{articleId}", method = RequestMethod.GET)
	public String getArticleDetail(HttpServletRequest request, @PathVariable String columnPath, @PathVariable String articleId) {
		System.out.println(columnPath+"-"+articleId);
		return "index";
	}
}
