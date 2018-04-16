package com.jiantong.bean;

import com.jiantong.bean.base.PageBean;

public class ArticleBean extends PageBean {

	private Integer columnId;
	
	private String title;

	public Integer getColumnId() {
		return columnId;
	}

	public void setColumnId(Integer columnId) {
		this.columnId = columnId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
