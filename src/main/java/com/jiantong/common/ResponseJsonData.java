package com.jiantong.common;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

public class ResponseJsonData {

	/**
	 * 状态
	 */
	private int retcode;
	
	/**Map结果集*/
	private Map<String, Object> dataMap;
	
	/**
	 * 普通数据结果集
	 */
	private List<?> dataList;
	
	/**
	 * 带分页信息结果集
	 */
	private PageInfo<?> pageInfo;
	
	/**
	 * 消息
	 */
	private String msg;

	public int getRetcode() {
		return retcode;
	}

	public void setRetcode(int retcode) {
		this.retcode = retcode;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public List<?> getDataList() {
		return dataList;
	}

	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}

	public PageInfo<?> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<?> pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
