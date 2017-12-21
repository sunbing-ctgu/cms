package com.jiantong.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.jiantong.bean.UserBean;
import com.jiantong.entity.User;
import com.jiantong.vo.UserVo;

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
	public PageInfo<User> getUserList(UserBean data);

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
	public Integer addUser(UserVo user);
	
	/**
	 * 更新用户
	 * @param userSearchVo
	 * @return
	 */
	public Integer updateUser(UserVo user);
	
	/**
	 * 删除用户
	 * @param ids
	 * @return
	 */
	public Integer deleteUser(List<Integer> ids);
	
}
