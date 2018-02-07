package com.jiantong.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.jiantong.bean.ColumnBean;
import com.jiantong.bean.ColumnTree;
import com.jiantong.entity.Column;
import com.jiantong.vo.ColumnVo;

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
	
	/**
	 * 根据所属频道获取所有栏目Tree(前端使用)
	 * @param channel
	 * @return
	 */
	public List<ColumnTree> getShowColumnTree(Integer channel);
	
	/**
	 * 获取栏目列表
	 * @param data
	 * @return
	 */
	public PageInfo<Column> getColumnList(ColumnBean data);
	
	/**
	 * 获取根栏目列表
	 * @return
	 */
	public List<Column> getRootColumnList();
	
	/**
	 * 添加栏目
	 * @param data
	 * @return
	 */
	public Integer addColumn(ColumnVo data);
	
	/**
	 * 更新栏目
	 * @param data
	 * @return
	 */
	public Integer updateColumn(ColumnVo data);
	
	/**
	 * 删除栏目
	 * @return
	 */
	public Integer deleteColumn(List<Integer> ids);
	
	/**
	 * 根据请求路径获取栏目信息
	 * @param path
	 * @return
	 */
	public Column getColumnByPath(String path, Integer channel);
}
