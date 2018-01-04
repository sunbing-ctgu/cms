package com.jiantong.dao;

import java.util.List;

import com.jiantong.entity.Column;

/**
 * 栏目信息Dao层接口
 * <p>Title:ColumnDao</p>
 * <p>Company: jiantong</p>
 * @author sunbing
 * @date 2018年1月3日 上午10:56:04
 */
public interface ColumnDao {
	
	/**
	 * 根据所属频道查询跟栏目
	 * @param channel
	 * @return
	 */
	public List<Column> getRootColumn(Integer channel);

	/**
	 * 查询父级栏目的直接子栏目
	 * @param parentId
	 * @return
	 */
	public List<Column> getTopChildren(Integer parentId);
	
}