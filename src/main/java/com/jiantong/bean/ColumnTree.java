package com.jiantong.bean;

import java.util.List;

/**
 * 栏目树Bean
 * <p>Title:ColumnTree</p>
 * <p>Company: jiantong</p>
 * @author sunbing
 * @date 2018年1月6日 下午2:45:54
 */
public class ColumnTree {
	/**ID*/
	private Integer id;
	
	/**名称*/
	private String text;
	
	private Integer level;
	
	private String path;
	
	private List<ColumnTree> nodes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<ColumnTree> getNodes() {
		return nodes;
	}

	public void setNodes(List<ColumnTree> nodes) {
		this.nodes = nodes;
	}
	
}
