package com.jiantong.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContext;

import com.jiantong.bean.UserBean;
import com.jiantong.controller.admin.base.BaseController;
import com.jiantong.entity.User;
import com.jiantong.service.UserService;

/**
 * 用户管理控制层
 * @author sunbing
 *
 */
@Controller
@RequestMapping("/admin/userManage")
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("")
	public String userManage(HttpServletRequest request, Model model) {
		return "admin/userManage";
	}
	
	@RequestMapping(value="/getUserList", method=RequestMethod.POST)
	@ResponseBody
	public List<User> getUserList(HttpServletRequest request, @RequestBody UserBean data) {
		List<User> userList = userService.getUserList(data);
		return userList;
	}
	
	
	
}
