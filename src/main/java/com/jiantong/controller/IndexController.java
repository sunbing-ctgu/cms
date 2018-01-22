package com.jiantong.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jiantong.bean.ColumnTree;
import com.jiantong.service.ColumnService;

/**
 * 网站欢迎首页
 * @author sunbing
 *
 */
@Controller
public class IndexController extends BaseHandler{

	@Autowired
	private ColumnService columnService;
	
	@RequestMapping("/")
	public String index(HttpServletRequest request, Model model){
		HttpSession session = getSession(request);
		session.setAttribute(CURRENT_PATH_SESSION, "");
		List<ColumnTree> dataList = (List<ColumnTree>)session.getAttribute(MENU_SESSION);
		if(null == dataList) {
			Integer channel = getChannel(request);
			List<ColumnTree> columnTreeList = columnService.getColumnTree(channel);
			session.setAttribute(MENU_SESSION, columnTreeList);
		}
		//获取导航列表
		return "index";
	}
	
}
