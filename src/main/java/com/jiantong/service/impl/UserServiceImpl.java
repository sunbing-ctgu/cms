package com.jiantong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiantong.bean.UserBean;
import com.jiantong.dao.UserDao;
import com.jiantong.entity.User;
import com.jiantong.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public PageInfo<User> getUserList(UserBean data) {
		// TODO Auto-generated method stub
		PageHelper.startPage(data.getPageNum(), data.getPageSize());
		List<User> userList = userDao.getUserList(data);
		PageInfo<User> result = null;
		if (null != userList) {
			result = new PageInfo<User>(userList);
		}
		return result;
	}
	
	@Override
	public User getUserByName(String username) {
		// TODO Auto-generated method stub
		List<User> userList= userDao.getUserByUsername(username);
		if(null != userList && userList.size() == 1) {
			return userList.get(0);
		}
		return null;
	}

	@Override
	public Integer addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}
	
	@Override
	public Integer updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	@Override
	public Integer deleteUser(List<Integer> ids) {
		// TODO Auto-generated method stub
		return userDao.deleteUserList(ids);
	}

}
