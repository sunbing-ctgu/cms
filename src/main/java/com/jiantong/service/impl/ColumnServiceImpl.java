package com.jiantong.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiantong.bean.ColumnBean;
import com.jiantong.bean.ColumnTree;
import com.jiantong.dao.ColumnDao;
import com.jiantong.entity.Column;
import com.jiantong.service.ColumnService;
import com.jiantong.vo.ColumnVo;

@Service("columnService")
public class ColumnServiceImpl implements ColumnService {

	@Autowired
	private ColumnDao columnDao;
	
	@Override
	public List<Column> getAllColumn(Integer channel) {
		// TODO Auto-generated method stub
		List<Column> result = new ArrayList<>();
		//获取跟栏目
		List<Column> rootColumns = columnDao.getRootColumn(channel);
		for(Column column : rootColumns) {
			result.add(build(column));
		}
		return result;
	}
	
	@Override
	public List<ColumnTree> getColumnTree(Integer channel) {
		// TODO Auto-generated method stub
		List<ColumnTree> result = new ArrayList<>();
		//获取跟栏目
		List<ColumnTree> rootColumns = columnDao.getRootColumnForTree(channel);
		for(ColumnTree column : rootColumns) {
			result.add(buildTree(column));
		}
		return result;
	}
	
	public List<ColumnTree> getShowColumnTree(Integer channel) {
		List<ColumnTree> result = new ArrayList<>();
		//获取跟栏目
		List<ColumnTree> rootColumns = columnDao.getShowRootColumnForTree(channel);
		for(ColumnTree column : rootColumns) {
			result.add(buildShowTree(column));
		}
		return result;
	}
	
	/**
	 * 获取当前栏目的所有子栏目（递归）
	 * @param column
	 * @return
	 */
	private Column build(Column column) {
		if(column.getLevel() != 1) {
			List<Column> topChildren = columnDao.getTopChildren(column.getId());
			column.setChildColumn(topChildren);
			for(Column child : topChildren) {
				build(child);
			}
		}
		return column;
	}
	
	/**
	 * 获取当前栏目的所有子栏目（递归）
	 * @param column
	 * @return
	 */
	private ColumnTree buildTree(ColumnTree column) {
		if(column.getLevel() != 1) {
			List<ColumnTree> topChildren = columnDao.getTopChildrenForTree(column.getId());
			if(null != topChildren && topChildren.size() > 0) {
				column.setNodes(topChildren);
				for(ColumnTree child : topChildren) {
					buildTree(child);
				}
			}
		}
		return column;
	}
	
	/**
	 * 获取当前栏目的所有子栏目（递归/前端使用）
	 * @param column
	 * @return
	 */
	private ColumnTree buildShowTree(ColumnTree column) {
		if(column.getLevel() != 1) {
			List<ColumnTree> topChildren = columnDao.getShowTopChildrenForTree(column.getId());
			column.setNodes(topChildren);
			for(ColumnTree child : topChildren) {
				buildShowTree(child);
			}
		}
		return column;
	}

	@Override
	public PageInfo<Column> getColumnList(ColumnBean data) {
		// TODO Auto-generated method stub
		PageHelper.startPage(data.getPageNum(), data.getPageSize());
		List<Column> columnList = columnDao.getColumnList(data);
		PageInfo<Column> result = null;
		if (null != columnList) {
			result = new PageInfo<Column>(columnList);
		}
		return result;
	}

	@Override
	public Integer addColumn(ColumnVo data) {
		// TODO Auto-generated method stub
		return columnDao.addColumn(data);
	}

	@Override
	public Integer updateColumn(ColumnVo data) {
		// TODO Auto-generated method stub
		return columnDao.updateColumn(data);
	}

	@Override
	public Integer deleteColumn(List<Integer> ids) {
		// TODO Auto-generated method stub
		return columnDao.deleteColumnList(ids);
	}

	@Override
	public Column getColumnByPath(String path, Integer channel) {
		// TODO Auto-generated method stub
		Column column = columnDao.getColumnByPath(path, channel);
		List<Column> topChildren = columnDao.getTopChildren(column.getId());
		column.setChildColumn(topChildren);
		return column;
	}
	
}
