package com.jiantong.service;

import java.util.List;

import com.jiantong.entity.User;
import com.jiantong.vo.UserManageVo;

public interface UserService {

	public User getUserByName(String username);
	
	public List<User> findUserByParam(UserManageVo userSearchVo);
	
	public Integer insertUser(User user);
	
	public Integer updateUser(UserManageVo userSearchVo);
	
	public Integer deleteUser(Integer id);
	
	public Integer isHaveUser(String username);
	
	public Integer deleteUserList(List<Integer> userList);
}
