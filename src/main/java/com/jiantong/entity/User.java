package com.jiantong.entity;

import java.util.Date;

public class User {
	
	private Integer id;
	
    /**账号 */
    private String username;
    
    /**真实姓名 */
    private String realname;

    /**密码 */
    private String password;
    
    private String salt;

    /**性别   0：男     1：女*/
    private Integer sex;
    
    /**手机号 */
    private String tel;
    
    /**最后登录IP */
    private String lastLoginIp;
    
    /**最后登录时间 */
    private Date lastLoginTime;
    
    /**账号是否锁定，1：锁定，0未锁定 */
    private Integer locked;
    
    /**状态  0:已删除    1：正常*/
    private Integer status;
    
    /**是否为管理员用户*/
    private Integer isAdmin;
    
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
		this.username = username == null ? null : username.trim();
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

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
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

	public Integer getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", realname=" + realname + ", password=" + password
				+ ", salt=" + salt + ", sex=" + sex + ", tel=" + tel + ", lastLoginIp=" + lastLoginIp
				+ ", lastLoginTime=" + lastLoginTime + ", locked=" + locked + ", status=" + status + ", isAdmin="
				+ isAdmin + ", createTime=" + createTime + "]";
	}
    
}