package com.jiantong.bean;

import java.util.Date;

public class UserBean {

    /**账号 */
    private String username;
    
    /**真实姓名 */
    private String realname;
    
    /**性别   0：男     1：女*/
    private Integer sex;
    
    /**手机号 */
    private String tel;
    
    /**创建时间-开始 */
    private Date startTime;
    
    /**创建时间-结束 */
    private Date endTime;

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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
    
}
