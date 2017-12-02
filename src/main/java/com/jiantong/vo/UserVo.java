package com.jiantong.vo;

import javax.validation.constraints.Size;

/**
 * 用户登录请求
 * <p>Title:UserVo</p>
 * <p>Company: jiantong</p>
 * @author sunbing
 * @date 2017年11月2日 上午11:36:53
 */
public class UserVo {
	
	@Size(max=36, message="用户编号过长！")
	private String id;

	@Size(max=64, message="用户名过长！")
    private String username;

	@Size(max=32, message="密码过长！")
    private String password;
	
	private String locked;
	
	private String salt;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocked() {
		return locked;
	}

	public void setLocked(String locked) {
		this.locked = locked;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	public String getCredentialsSalt() {
        return username + salt;
    }
    
}
