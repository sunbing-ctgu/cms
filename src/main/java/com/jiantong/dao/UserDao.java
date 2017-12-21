package com.jiantong.dao;

import java.util.List;

import com.jiantong.bean.UserBean;
import com.jiantong.entity.User;
import com.jiantong.vo.UserVo;

public interface UserDao {

	public List<User> getUserList(UserBean userSearchVo);
	
	public List<User> getUserByUsername(String username);
	
	public Integer addUser(UserVo user);
	
	public Integer updateUser(UserVo user);
	
	public Integer deleteUserList(List<Integer> userList);
}
