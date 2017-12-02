package com.jiantong.vo;

import java.util.Date;

/**
 * 用户管理搜索请求
 * <p>Title:UserManageVo</p>
 * <p>Company: jiantong</p>
 * @author sunbing
 * @date 2017年11月2日 上午11:36:30
 */
public class UserManageVo {
	
	private Integer id;

    /**账号 */
    private String username;
    
    /**密码 */
    private String password;
    
    /**重复密码 */
    private String repassword;
    
    /**工号 */
    private String userid;
    
    /**账号是否锁定，1：锁定，0未锁定 */
    private Integer locked;
    
    /**真实姓名 */
    private String realname;
    
    /**性别   0：男     1：女*/
    private Integer sex;
    
    /**手机号 */
    private String tel;
    
    /**创建时间-开始 */
    private Date createtimeStart;
    
    /**创建时间-结束 */
    private Date createtimeEnd;
    
    /**最后登录时间-开始 */
    private Date lastlogintimeStart;
    
    /**最后登录时间 -结束*/
    private Date lastlogintimeEnd;
    
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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Integer getLocked() {
		return locked;
	}

	public void setLocked(Integer locked) {
		this.locked = locked;
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

	public Date getCreatetimeStart() {
		return createtimeStart;
	}

	public void setCreatetimeStart(Date createtimeStart) {
		this.createtimeStart = createtimeStart;
	}

	public Date getCreatetimeEnd() {
		return createtimeEnd;
	}

	public void setCreatetimeEnd(Date createtimeEnd) {
		this.createtimeEnd = createtimeEnd;
	}

	public Date getLastlogintimeStart() {
		return lastlogintimeStart;
	}

	public void setLastlogintimeStart(Date lastlogintimeStart) {
		this.lastlogintimeStart = lastlogintimeStart;
	}

	public Date getLastlogintimeEnd() {
		return lastlogintimeEnd;
	}

	public void setLastlogintimeEnd(Date lastlogintimeEnd) {
		this.lastlogintimeEnd = lastlogintimeEnd;
	}

	
}
