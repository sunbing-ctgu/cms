package com.jiantong.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "")
public class CmsController extends BaseHandler{

	@RequestMapping(value = "/{columnPath}", method = RequestMethod.GET)
	public String getArticleList(HttpServletRequest request, @PathVariable String columnPath) {
		HttpSession session = getSession(request);
		session.setAttribute(CURRENT_PATH_SESSION, columnPath);
		
		System.out.println(columnPath);
		
		return columnPath;
	}
	@RequestMapping(value = "/{columnPath}/{articleId}", method = RequestMethod.GET)
	public String getArticleDetail(HttpServletRequest request, @PathVariable String columnPath, @PathVariable String articleId) {
		System.out.println(columnPath+"-"+articleId);
		HttpSession session = getSession(request);
		session.setAttribute(CURRENT_PATH_SESSION, columnPath);
		return "index";
	}
	
	/*@RequestMapping(value = "/{rootColumnPath}/{columnPath}/{articleId}", method = RequestMethod.GET)
	public String getArticleDetail(HttpServletRequest request,@PathVariable String rootColumnPath, @PathVariable String columnPath, @PathVariable String articleId) {
		System.out.println(columnPath+"-"+articleId);
		HttpSession session = getSession(request);
		session.setAttribute(CURRENT_PATH_SESSION, rootColumnPath);
		return "index";
	}*/
}
