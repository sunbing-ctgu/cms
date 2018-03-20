package com.jiantong.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiantong.bean.ArticleBean;
import com.jiantong.entity.Article;
import com.jiantong.pojo.ArticleSummary;
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
	 * 获取文章列表
	 * @param data
	 * @return
	 */
	public List<Article> getArticleList(ArticleBean data);
	
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
	public Integer deleteArticle(List<Integer> ids);
	
	public Article getArticleByColumnId(Integer columnId);
	
	public List<ArticleSummary> getArticleListByColumnId(Integer columnId);
	
	public List<ArticleSummary> getArticleListTopByColumnId(@Param("columnId")Integer columnId, @Param("top")Integer top);
}
