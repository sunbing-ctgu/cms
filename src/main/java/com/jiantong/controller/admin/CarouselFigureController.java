package com.jiantong.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jiantong.controller.admin.base.BaseController;

@Controller
@RequestMapping("/admin/carouselFigureManage")
public class CarouselFigureController extends BaseController {

	private final static Logger logger = LoggerFactory.getLogger(CarouselFigureController.class);
	
	@RequestMapping("")
	public String index(HttpServletRequest request) {
		HttpSession session = getSession(request);
		session.setAttribute(INDEX_SESSION, "contentManage/carouselFigureManage");
		return "/admin/contentManage/carouselFigureManage";
	}
}
