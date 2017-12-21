package com.jiantong.bean.base;

public class PageBean {

	/** 每页的数量 */
	private Integer pageSize;
	
	/** 当前页 */
	private Integer pageNum;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	
}
