package com.jiantong.entity;

import java.util.Date;

/**
 * 文章信息表
 * <p>Title:Article</p>
 * <p>Company: jiantong</p>
 * @author sunbing
 * @date 2018年1月3日 上午10:02:06
 */
public class Article {

	/**主键*/
	private Integer id;
	
	/**所属栏目ID*/
	private Integer columnId;
	
	/**所属根栏目ID*/
	private Integer rootColumnId;
	
	/**标题*/
	private String title;
	
	/**标题图片*/
	private String titleImg;
	
	/**内容*/
	private String content;
	
	/**摘要*/
	private String summary;
	
	/**关键词*/
	private String keyWord;
	
	/**发布者ID*/
	private Integer publisherId;
	
	/**发布时间*/
	private Date publishTime;
	
	/**置顶属性(0:默认1:置顶2:推荐)*/
	private Integer topType;
	
	/**排序*/
	private Integer sort;
	
	/**阅读数*/
	private Integer viewCount;
	
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

	public Integer getColumnId() {
		return columnId;
	}

	public void setColumnId(Integer columnId) {
		this.columnId = columnId;
	}

	public Integer getRootColumnId() {
		return rootColumnId;
	}

	public void setRootColumnId(Integer rootColumnId) {
		this.rootColumnId = rootColumnId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleImg() {
		return titleImg;
	}

	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public Integer getTopType() {
		return topType;
	}

	public void setTopType(Integer topType) {
		this.topType = topType;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
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
