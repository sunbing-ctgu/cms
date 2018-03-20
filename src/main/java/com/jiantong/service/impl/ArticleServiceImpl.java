package com.jiantong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiantong.bean.ArticleBean;
import com.jiantong.dao.ArticleDao;
import com.jiantong.entity.Article;
import com.jiantong.entity.Column;
import com.jiantong.pojo.ArticleSummary;
import com.jiantong.service.ArticleService;
import com.jiantong.vo.ArticleVo;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public PageInfo<Article> getArticleList(ArticleBean data) {
		// TODO Auto-generated method stub
		PageHelper.startPage(data.getPageNum(), data.getPageSize());
		List<Article> articleList = articleDao.getArticleList(data);
		PageInfo<Article> result = null;
		if (null != articleList) {
			result = new PageInfo<Article>(articleList);
		}
		return result;
	}

	@Override
	public Article getArticleByKey(Integer id) {
		// TODO Auto-generated method stub
		return articleDao.getArticleByKey(id);
	}

	@Override
	public Integer addArticle(ArticleVo article) {
		// TODO Auto-generated method stub
		return articleDao.addArticle(article);
	}

	@Override
	public Integer updateArticle(ArticleVo article) {
		// TODO Auto-generated method stub
		return articleDao.updateArticle(article);
	}

	@Override
	public Integer updateArticelViewCount(Integer id) {
		// TODO Auto-generated method stub
		return articleDao.updateArticleViewCount(id);
	}

	@Override
	public Integer deleteArticle(List<Integer> ids) {
		// TODO Auto-generated method stub
		return articleDao.deleteArticle(ids);
	}

	@Override
	public Article getArticleByColumnId(Integer columnId) {
		// TODO Auto-generated method stub
		return articleDao.getArticleByColumnId(columnId);
	}

	@Override
	public List<ArticleSummary> getArticleListTopByColumnId(Integer columnId, Integer top) {
		// TODO Auto-generated method stub
		return articleDao.getArticleListTopByColumnId(columnId, top);
	}

	@Override
	public PageInfo<ArticleSummary> getArticleListByColumnId(Integer columnId) {
		// TODO Auto-generated method stub
		PageHelper.startPage(1, 10);
		List<ArticleSummary> articleList = articleDao.getArticleListByColumnId(columnId);
		PageInfo<ArticleSummary> result = null;
		if (null != articleList) {
			result = new PageInfo<ArticleSummary>(articleList);
		}
		return result;
	}

	@Override
	public PageInfo<ArticleSummary> getArticleListByColumnId(Integer columnId, Integer pageNum) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, 10);
		List<ArticleSummary> articleList = articleDao.getArticleListByColumnId(columnId);
		PageInfo<ArticleSummary> result = null;
		if (null != articleList) {
			result = new PageInfo<ArticleSummary>(articleList);
		}
		return result;
	}

	@Override
	public List<ArticleSummary> getArticleListAllByColumnId(Integer columnId) {
		// TODO Auto-generated method stub
		return articleDao.getArticleListByColumnId(columnId);
	}

}
