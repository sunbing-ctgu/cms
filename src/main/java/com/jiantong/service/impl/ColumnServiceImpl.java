package com.jiantong.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiantong.bean.ColumnTree;
import com.jiantong.dao.ColumnDao;
import com.jiantong.entity.Column;
import com.jiantong.service.ColumnService;

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
			column.setNodes(topChildren);
			for(ColumnTree child : topChildren) {
				buildTree(child);
			}
		}
		return column;
	}
	
}
