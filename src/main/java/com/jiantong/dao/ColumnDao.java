package com.jiantong.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiantong.bean.ColumnBean;
import com.jiantong.bean.ColumnTree;
import com.jiantong.entity.Column;
import com.jiantong.vo.ColumnVo;

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
	
	/**
	 * 根据所属频道查询跟栏目(Tree使用)
	 * @param channel
	 * @return
	 */
	public List<ColumnTree> getRootColumnForTree(Integer channel);
	
	/**
	 * 根据所属频道查询跟栏目(前端Tree使用)
	 * @param channel
	 * @return
	 */
	public List<ColumnTree> getShowRootColumnForTree(Integer channel);

	/**
	 * 查询父级栏目的直接子栏目(Tree使用)
	 * @param parentId
	 * @return
	 */
	public List<ColumnTree> getTopChildrenForTree(Integer parentId);
	
	/**
	 * 查询父级栏目的直接子栏目(Tree使用、前端)
	 * @param parentId
	 * @return
	 */
	public List<ColumnTree> getShowTopChildrenForTree(Integer parentId);
	
	public List<Column> getColumnList(ColumnBean data);
	
	public Integer addColumn(ColumnVo column);
	
	public Integer updateColumn(ColumnVo column);
	
	public Integer deleteColumnList(List<Integer> columnList);
	
	public Column getColumnByPath(@Param("path")String path, @Param("channel") Integer channel);
}
