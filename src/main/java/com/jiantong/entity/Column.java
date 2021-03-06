package com.jiantong.entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 栏目信息表
 * <p>Title:Column</p>
 * <p>Company: jiantong</p>
 * @author sunbing
 * @date 2018年1月3日 上午9:55:16
 */
public class Column {
	
	/**根节点*/
	public static final Integer ROOT_LEAVE = -1;
	
	/**非叶子级节点*/
	public static final Integer DEFAULT_LEAVE = 0;
	
	/**叶子级节点*/
	public static final Integer LEAF_LEAVE = 1;
	
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
	
	/**是否显示*/
	private Integer isShow;
	
	/**状态  0:已删除    1：正常*/
    private Integer status;
	
	/**创建时间*/
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;
	
	/**更新时间*/
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date updateTime;
	
	/**下属栏目*/
	private List<Column> childColumn;

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

	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public List<Column> getChildColumn() {
		return childColumn;
	}

	public void setChildColumn(List<Column> childColumn) {
		this.childColumn = childColumn;
	}
	
}
