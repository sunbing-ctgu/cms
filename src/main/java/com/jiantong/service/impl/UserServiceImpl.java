package com.jiantong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiantong.dao.UserDao;
import com.jiantong.entity.User;
import com.jiantong.service.UserService;
import com.jiantong.vo.UserManageVo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

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
	public List<User> findUserByParam(UserManageVo userSearchVo) {
		// TODO Auto-generated method stub
		List<User> userList = userDao.findUserByParam(userSearchVo);
		return userList;
	}

	@Override
	public Integer insertUser(User user) {
		// TODO Auto-generated method stub
		return userDao.insertUser(user);
	}

	@Override
	public Integer updateUser(UserManageVo userSearchVo) {
		// TODO Auto-generated method stub
		return userDao.updateUser(userSearchVo);
	}

	@Override
	public Integer deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(id);
	}

	@Override
	public Integer isHaveUser(String username) {
		// TODO Auto-generated method stub
		return userDao.isHaveUser(username);
	}

	@Override
	public Integer deleteUserList(List<Integer> userList) {
		// TODO Auto-generated method stub
		return userDao.deleteUserList(userList);
	}

}
