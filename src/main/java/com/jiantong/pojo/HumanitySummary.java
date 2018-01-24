package com.jiantong.pojo;

import java.util.List;

/**
 * 首页人文风光
 * Title:HumanitySummary
 * Company:jiantong
 * @author sunbing
 * @date 2018年1月25日 上午1:47:22
 */
public class HumanitySummary {

	/**栏目名集合*/
	private List<String> columnNameList;
	
	/**下属栏目文章集合*/
	private List<ArticleSummary> articleList;

	public List<String> getColumnNameList() {
		return columnNameList;
	}

	public void setColumnNameList(List<String> columnNameList) {
		this.columnNameList = columnNameList;
	}

	public List<ArticleSummary> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<ArticleSummary> articleList) {
		this.articleList = articleList;
	}
	
}
