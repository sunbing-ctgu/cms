package com.jiantong.bean;

import java.util.List;

import com.jiantong.bean.base.PageBean;

public class ArticleBean extends PageBean {

	private List<Integer> columnIds;
	
	private String title;

	public List<Integer> getColumnIds() {
		return columnIds;
	}

	public void setColumnIds(List<Integer> columnIds) {
		this.columnIds = columnIds;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
