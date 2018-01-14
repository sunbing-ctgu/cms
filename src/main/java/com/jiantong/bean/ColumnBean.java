package com.jiantong.bean;

import com.jiantong.bean.base.PageBean;

public class ColumnBean extends PageBean {
	
	/**父级栏目ID*/
	private Integer parentId;
	
	/**栏目名*/
	private String name;

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
