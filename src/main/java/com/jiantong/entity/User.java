package com.jiantong.entity;

import java.util.Date;

public class User {
	
	private Integer id;
	
    /**账号 */
    private String username;

    /**密码 */
    private String password;

    /**账号是否锁定，1：锁定，0未锁定 */
    private Integer locked;
    
    private String salt;
    
    /**真实姓名 */
    private String realname;

    /**性别   0：男     1：女*/
    private Integer sex;
    
    /**手机号 */
    private String tel;
    
    /**创建时间 */
    private Date createtime;
    
    /**最后登录IP */
    private String lasthost;
    
    /**最后登录时间 */
    private Date lastlogintime;
    
    /**状态  0:已删除    1：正常*/
    private Integer status;
    
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
    
	public String getSalt() {
		return salt;
	}

	public Integer getLocked() {
		return locked;
	}

	public void setLocked(Integer locked) {
		this.locked = locked;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getCredentialsSalt() {
        return username + salt;
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

	public String getLasthost() {
		return lasthost;
	}

	public void setLasthost(String lasthost) {
		this.lasthost = lasthost;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getLastlogintime() {
		return lastlogintime;
	}

	public void setLastlogintime(Date lastlogintime) {
		this.lastlogintime = lastlogintime;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", locked=" + locked + ", salt="
				+ salt + ", realname=" + realname + ", sex=" + sex + ", tel=" + tel + ", createtime=" + createtime
				+ ", lasthost=" + lasthost + ", lastlogintime=" + lastlogintime + ", status=" + status + "]";
	}
}