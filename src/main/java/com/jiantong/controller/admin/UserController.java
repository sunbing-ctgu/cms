package com.jiantong.controller.admin;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.jiantong.bean.UserBean;
import com.jiantong.common.PasswordHelper;
import com.jiantong.common.ResponseJsonData;
import com.jiantong.controller.admin.base.BaseController;
import com.jiantong.entity.User;
import com.jiantong.service.UserService;
import com.jiantong.vo.UserVo;

/**
 * 用户管理控制层
 * @author sunbing
 *
 */
@Controller
@RequestMapping("/admin/userManage")
public class UserController extends BaseController {
	
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordHelper passwordHelper;

	@RequestMapping("")
	public String userManage(HttpServletRequest request, Model model) {
		HttpSession session = getSession(request);
		session.setAttribute(INDEX_SESSION, "systemManage/userManage");
		return "admin/systemManage/userManage";
	}
	
	@RequestMapping(value="/getUserList", method=RequestMethod.POST)
	@ResponseBody
	public ResponseJsonData getUserList(HttpServletRequest request, @RequestBody UserBean data) {
		ResponseJsonData result = new ResponseJsonData();
		boolean flag = false;
		PageInfo<User> userList = null;
		try {
			userList = userService.getUserList(data);
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("getUserList Exception", e);
		}
		if (flag) {
			result.setRetcode(SUCCESS);
			result.setPageInfo(userList);
		} else {
			result.setRetcode(FAIL);
			result.setMsg("获取用户列表失败");
		}
		return result;
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	@ResponseBody
	public ResponseJsonData addUser(HttpServletRequest request, @RequestBody UserVo data) {
		ResponseJsonData result = new ResponseJsonData();
		boolean flag = false;
		passwordHelper.encryptPassword(data);
		User hasUser = userService.getUserByName(data.getUsername());
		if(null != hasUser) {
			result.setRetcode(FAIL);
			result.setMsg("用户名已经存在！");
			return result;
		}
		try {
			data.setLocked(0);
			data.setStatus(1);
			data.setCreateTime(new Date());
			userService.addUser(data);
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("addUser Exception", e);
		}
		if(flag) {
			result.setRetcode(SUCCESS);
			result.setMsg("添加用户成功！");
		}else {
			result.setRetcode(FAIL);
			result.setMsg("添加用户失败！");
		}
		return result;
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	@ResponseBody
	public ResponseJsonData updateUser(HttpServletRequest request, @RequestBody UserVo data) {
		ResponseJsonData result = new ResponseJsonData();
		boolean flag = false;
		try {
			userService.updateUser(data);
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("updateUser Exception", e);
		}
		if(flag) {
			result.setRetcode(SUCCESS);
			result.setMsg("更新用户成功！");
		}else {
			result.setRetcode(FAIL);
			result.setMsg("更新用户失败！");
		}
		return result;
	}
	
	@RequestMapping(value="/deleteUser", method=RequestMethod.POST)
	@ResponseBody
	public ResponseJsonData deleteUser(HttpServletRequest request, @RequestBody  Map<String, Integer[]> data) {
		ResponseJsonData result = new ResponseJsonData();
		boolean flag = false;
		List<Integer> ids = Arrays.asList(data.get("ids"));
		User user = getUser(request);
		if(ids.contains(user.getId())) {
			result.setRetcode(FAIL);
			result.setMsg("删除失败，用户不能删除自身！");
			return result;
		}
		try {
			userService.deleteUser(ids);
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("deleteUser Exception", e);
		}
		if(flag) {
			result.setRetcode(SUCCESS);
			result.setMsg("删除用户成功！");
		}else {
			result.setRetcode(FAIL);
			result.setMsg("删除用户失败！");
		}
		return result;
	}
}
