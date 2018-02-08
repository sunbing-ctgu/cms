package com.jiantong.vo;

import java.util.Date;

public class ColumnVo {

	/** 主键 */
	private Integer id;
	
	/**栏目名*/
	private String name;
	
	/**栏目别名*/
	private String rename;
	
	/**访问路径*/
	private String path;
	
	/**栏目图片*/
	private String img;
	
	/**栏目类别*/
	private Integer type;
	
	/**所属层级(1：顶级0：叶子级)*/
	private Integer level;
	
	/**所属频道(0:中文版1：英文版)*/
	private Integer channel;
	
	/**父级栏目ID*/
	private Integer parentId;
	
	/**排序*/
	private Integer sort;
	
	/**创建时间*/
	private Date createTime;
	
	/**更新时间*/
	private Date updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRename() {
		return rename;
	}

	public void setRename(String rename) {
		this.rename = rename;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getChannel() {
		return channel;
	}

	public void setChannel(Integer channel) {
		this.channel = channel;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
