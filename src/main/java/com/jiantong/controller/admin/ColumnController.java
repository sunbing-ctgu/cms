package com.jiantong.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiantong.bean.ColumnTree;
import com.jiantong.controller.admin.base.BaseController;
import com.jiantong.service.ColumnService;

/**
 * 栏目管理Controller层
 * <p>Title:ColumnController</p>
 * <p>Company: jiantong</p>
 * @author sunbing
 * @date 2018年1月6日 下午1:47:09
 */
@Controller
@RequestMapping("/admin/columnManage")
public class ColumnController extends BaseController {
	
	private final static Logger logger = LoggerFactory.getLogger(ColumnController.class);
	
	@Autowired
	private ColumnService columnService;
	
	@RequestMapping("")
	public String index(HttpServletRequest request) {
		HttpSession session = getSession(request);
		session.setAttribute(INDEX_SESSION, "contentManage/columnManage");
		return "/admin/contentManage/columnManage";
	}
	
	@RequestMapping(value="/getColumnTree", method=RequestMethod.GET)
	@ResponseBody
	public List<ColumnTree> getColumnTree(HttpServletRequest request) {
		Integer channel = getChannel(request);
		List<ColumnTree> columnTreeList = columnService.getColumnTree(channel);
		return columnTreeList;
	}
	
	
}
