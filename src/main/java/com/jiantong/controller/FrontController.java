package com.jiantong.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jiantong.entity.Article;
import com.jiantong.entity.Column;
import com.jiantong.pojo.ArticleSummary;
import com.jiantong.pojo.LinksSummary;
import com.jiantong.service.ArticleService;
import com.jiantong.service.ColumnService;

@Controller
@RequestMapping(value = "/front")
public class FrontController extends BaseHandler{
	private static final String BASEPATH = "front/";
	
	@Autowired
	private ColumnService columnService;
	
	@Autowired
	private ArticleService articleService;
	/**
	 * 根栏目访问URL
	 * @param request
	 * @param rootColumnPath
	 * @return
	 */
	@RequestMapping(value = "/{rootColumnPath}", method = RequestMethod.GET)
	public String getArticleList(HttpServletRequest request, @PathVariable String rootColumnPath) {
		String result = rootColumnPath;
		HttpSession session = getSession(request);
		Integer channel = getChannel(request);
		String path = BASEPATH + rootColumnPath;
		session.setAttribute(CURRENT_PATH_SESSION, path);
		Column rootColumn = columnService.getColumnByPath(path, channel);
		request.setAttribute("rootColumn", rootColumn);
		Column column = null;
		if(null != rootColumn.getChildColumn() && rootColumn.getChildColumn().size() > 0) {
			column = rootColumn.getChildColumn().get(0);
			request.setAttribute("column", column);
		}else {
			column = rootColumn;
		}
		Integer type = rootColumn.getType();
		Article article = null;
		List<ArticleSummary> articleList = null;
		switch (type) {
		//简介类
		case 0:
			result = "about";
			//获取展示内容
			article = articleService.getArticleByColumnId(column.getId());
			request.setAttribute("article", article);
			break;
		//新闻类
		case 1:
			result = "news";
			articleList = articleService.getArticleListByColumnId(column.getId());
			request.setAttribute("articleList", articleList);
			break;
		//展示类
		case 2:
			result = "imageTextDisplay";
			articleList = articleService.getArticleListByColumnId(column.getId());
			request.setAttribute("articleList", articleList);
			break;
		//图片一览类
		case 3:
			result = "imageDisplay";
			articleList = articleService.getArticleListByColumnId(column.getId());
			request.setAttribute("articleList", articleList);
			break;
		//超链接类
		case 4:
			Map<String,List<LinksSummary>> linksMap = new LinkedHashMap<>();
			for(Column childColumn : rootColumn.getChildColumn()) {
				List<LinksSummary> linksSummaryList = new ArrayList<>();
				articleList = articleService.getArticleListByColumnId(childColumn.getId());
				for(ArticleSummary articleSummary : articleList) {
					LinksSummary linksSummary = new LinksSummary();
					linksSummary.setTitle(articleSummary.getTitle());
					linksSummary.setHref(articleSummary.getHref());
					linksSummaryList.add(linksSummary);
				}
				linksMap.put(childColumn.getName(), linksSummaryList);
			}
			request.setAttribute("linksSummary", linksMap);
			result = "links";
			break;
		case 5:
			//公告类
			result = "notice";
			articleList = articleService.getArticleListByColumnId(column.getId());
			request.setAttribute("articleList", articleList);
			break;
		default:
			break;
		}
		return result;
	}
	
	/**
	 * 叶子节点栏目访问URL
	 * @param request
	 * @param rootColumnPath
	 * @param columnPath
	 * @return
	 */
	@RequestMapping(value = "/{rootColumnPath}/{columnPath}", method = RequestMethod.GET)
	public String getArticleDetail(HttpServletRequest request, @PathVariable String rootColumnPath, @PathVariable String columnPath) {
		HttpSession session = getSession(request);
		Integer channel = getChannel(request);
		String rootPath = BASEPATH + rootColumnPath;
		String path = BASEPATH + rootColumnPath + "/" + columnPath;
		session.setAttribute(CURRENT_PATH_SESSION, rootPath);
		Column rootColumn = columnService.getColumnByPath(rootPath, channel);
		Column column = columnService.getColumnByPath(path, channel);
		request.setAttribute("rootColumn", rootColumn);
		request.setAttribute("column", column);
		Integer type = rootColumn.getType();
		String result = rootColumnPath;
		switch (type) {
		case 0:
			result = "about";
			//获取展示内容
			Article article = articleService.getArticleByColumnId(column.getId());
			request.setAttribute("article", article);
			break;
		case 1:
			result = "news";
			List<ArticleSummary> articleList = articleService.getArticleListByColumnId(column.getId());
			request.setAttribute("articleList", articleList);
			break;
		case 2:
			break;

		default:
			break;
		}
		return result;
	}
	
	/**
	 * 文章详细信息访问URL
	 * @param request
	 * @param rootColumnPath
	 * @param columnPath
	 * @param articleId
	 * @return
	 */
	@RequestMapping(value = "/{rootColumnPath}/{columnPath}/{articleId}", method = RequestMethod.GET)
	public String getArticleDetail(HttpServletRequest request,@PathVariable String rootColumnPath, @PathVariable String columnPath, @PathVariable Integer articleId) {
		HttpSession session = getSession(request);
		Integer channel = getChannel(request);
		String rootPath = BASEPATH + rootColumnPath;
		String path = BASEPATH + rootColumnPath + "/" + columnPath;
		session.setAttribute(CURRENT_PATH_SESSION, rootPath);
		Column rootColumn = columnService.getColumnByPath(rootPath, channel);
		Column column = columnService.getColumnByPath(path, channel);
		request.setAttribute("rootColumn", rootColumn);
		request.setAttribute("column", column);
		Article article = articleService.getArticleByKey(articleId);
		request.setAttribute("article", article);
		return "newsDetail";
	}
	
	@RequestMapping(value = "/notice/{articleId}", method = RequestMethod.GET)
	public String getNoticeDetail(HttpServletRequest request, @PathVariable Integer articleId) {
		HttpSession session = getSession(request);
		Integer channel = getChannel(request);
		String path = BASEPATH + "notice";
		session.setAttribute(CURRENT_PATH_SESSION, path);
		Column column = columnService.getColumnByPath(path, channel);
		request.setAttribute("column", column);
		Article article = articleService.getArticleByKey(articleId);
		request.setAttribute("article", article);
		return "noticeDetail";
	}
}
