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
	
	@Size(max=64, message="用户名过长！")
    private String username;

	@Size(max=32, message="密码过长！")
    private String password;
	
	private String salt;
	
	@Size(max=64, message="真实姓名过长！")
	private String realname;
	
	private Integer sex;
	
	private String tel;

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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getCredentialsSalt() {
        return username + salt;
    }
}
