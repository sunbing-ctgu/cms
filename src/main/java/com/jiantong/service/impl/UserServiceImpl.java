package com.jiantong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiantong.bean.UserBean;
import com.jiantong.dao.UserDao;
import com.jiantong.entity.User;
import com.jiantong.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getUserList(UserBean userSearchVo) {
		// TODO Auto-generated method stub
		List<User> userList = userDao.getUserList(userSearchVo);
		return userList;
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
