package com.jiantong.vo;

import java.util.Date;

import javax.validation.constraints.Size;

/**
 * 用户登录请求
 * <p>Title:UserVo</p>
 * <p>Company: jiantong</p>
 * @author sunbing
 * @date 2017年11月2日 上午11:36:53
 */
public class UserVo {
	
	private Integer id;
	
	@Size(max=64, message="用户名过长！")
    private String username;
	
	@Size(max=64, message="真实姓名过长！")
	private String realname;

	@Size(max=32, message="密码过长！")
    private String password;
	
	private String salt;
	
	private Integer sex;
	
	private String tel;
	
	/**账号是否锁定，1：锁定，0未锁定 */
    private Integer locked;
	
	/**状态  0:已删除    1：正常*/
    private Integer status;
    
    /**创建时间 */
    private Date createTime;

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getRealname() {
		return realname;
	}


	public void setRealname(String realname) {
		this.realname = realname;
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


	public Integer getLocked() {
		return locked;
	}


	public void setLocked(Integer locked) {
		this.locked = locked;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public String getCredentialsSalt() {
        return username + salt;
    }
}
