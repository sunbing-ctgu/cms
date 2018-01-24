package com.jiantong.pojo;

import java.util.List;

/**
 * 首页新闻栏使用
 * Title:NewsSummary
 * Company:jiantong
 * @author sunbing
 * @date 2018年1月25日 上午12:53:48
 */
public class NewsSummary {

	/**栏目名*/
	private String columnName;
	
	/**栏目路径*/
	private String columnPath;
	
	/**文章概要列表*/
	private List<ArticleSummary> articleList;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnPath() {
		return columnPath;
	}

	public void setColumnPath(String columnPath) {
		this.columnPath = columnPath;
	}

	public List<ArticleSummary> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<ArticleSummary> articleList) {
		this.articleList = articleList;
	}
	
}
