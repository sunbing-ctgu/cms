package com.jiantong.dao;

import java.util.List;

import com.jiantong.entity.Article;
import com.jiantong.vo.ArticleVo;

/**
 * 文章信息Dao层接口
 * <p>Title:ArticleDao</p>
 * <p>Company: jiantong</p>
 * @author sunbing
 * @date 2018年1月4日 下午8:11:02
 */
public interface ArticleDao {
	
	/**
	 * 根据根栏目ID获取下属文章列表
	 * @param rootColumnId
	 * @return
	 */
	public List<Article> getArticleByRootColumnId(Integer rootColumnId);
	
	/**
	 * 根据栏目ID获取下属文章列表（概要）
	 * @param columnId
	 * @return
	 */
	public List<Article> getArticleByColumnId(Integer columnId);

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
	public Integer updateArticleViewCount(Integer id);
	
	/**
	 * 删除
	 * @return
	 */
	public Integer deleteArticle(Integer id);
}
