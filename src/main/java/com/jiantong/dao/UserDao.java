package com.jiantong.dao;

import java.util.List;

import com.jiantong.entity.User;
import com.jiantong.vo.UserManageVo;
import com.jiantong.vo.UserVo;

public interface UserDao {

	//扩展的mapper接口方法
	public List<User> find(UserVo record);
	
	public List<User> getUserByUsername(String username);
	
	public List<User> findUserByParam(UserManageVo userSearchVo);
	
	public Integer insertUser(User user);
	
	public Integer updateUser(UserManageVo userSearchVo);
	
	public Integer deleteUser(Integer id);
	
	public Integer isHaveUser(String username);
	
	public Integer deleteUserList(List<Integer> userList);
}
