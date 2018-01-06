package com.jiantong.service;

import java.util.List;

import com.jiantong.bean.ColumnTree;
import com.jiantong.entity.Column;

/**
 * 栏目信息Service层
 * <p>Title:ColumnService</p>
 * <p>Company: jiantong</p>
 * @author sunbing
 * @date 2018年1月3日 上午11:12:46
 */
public interface ColumnService {
	
	/**
	 * 根据所属频道获取所有栏目
	 * @param channel
	 * @return
	 */
	public List<Column> getAllColumn(Integer channel);
	
	/**
	 * 根据所属频道获取所有栏目Tree
	 * @param channel
	 * @return
	 */
	public List<ColumnTree> getColumnTree(Integer channel);
}
