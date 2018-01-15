package com.jiantong.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.jiantong.bean.ArticleBean;
import com.jiantong.entity.Article;
import com.jiantong.vo.ArticleVo;

/**
 * 文章管理逻辑层接口
 * <p>Title:ArticleService</p>
 * <p>Company: jiantong</p>
 * @author sunbing
 * @date 2018年1月15日 下午3:34:23
 */
public interface ArticleService {

	/**
	 * 获取文章列表
	 * @param data
	 * @return
	 */
	public PageInfo<Article> getArticleList(ArticleBean data);
	
	/**
	 * 根据主键获取文章详细信息
	 * @param id
	 * @return
	 */
	public Article getArticleByKey(Integer id);
	
	/**
	 * 新增
	 * @param article
	 * @return
	 */
	public Integer addArticle(ArticleVo article);
	
	/**
	 * 更新
	 * @param article
	 * @return
	 */
	public Integer updateArticle(ArticleVo article);
	
	/**
	 * 更新阅读次数
	 * @param id
	 * @return
	 */
	public Integer updateArticelViewCount(Integer id);
	
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	public Integer deleteArticle(List<Integer> ids);
	
}
