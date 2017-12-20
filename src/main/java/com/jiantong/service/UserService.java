package com.jiantong.service;

import java.util.List;

import com.jiantong.bean.UserBean;
import com.jiantong.entity.User;

/**
 * 用户管理逻辑层接口
 * @author sunbing
 *
 */
public interface UserService {
	
	/**
	 * 获取用户列表
	 * @param userSearchVo
	 * @return
	 */
	public List<User> getUserList(UserBean userSearchVo);

	/**
	 * 通过用户名获取用户信息
	 * @param username
	 * @return
	 */
	public User getUserByName(String username);
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public Integer addUser(User user);
	
	/**
	 * 更新用户
	 * @param userSearchVo
	 * @return
	 */
	public Integer updateUser(User userSearchVo);
	
	/**
	 * 删除用户
	 * @param ids
	 * @return
	 */
	public Integer deleteUser(List<Integer> ids);
	
}
