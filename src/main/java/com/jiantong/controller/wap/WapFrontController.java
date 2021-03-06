package com.jiantong.controller.wap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.jiantong.bean.base.PageBean;
import com.jiantong.common.ResponseJsonData;
import com.jiantong.controller.BaseHandler;
import com.jiantong.entity.Article;
import com.jiantong.entity.Column;
import com.jiantong.pojo.ArticleSummary;
import com.jiantong.pojo.LinksSummary;
import com.jiantong.service.ArticleService;
import com.jiantong.service.ColumnService;

@Controller
@RequestMapping(value = "/wap/front")
public class WapFrontController extends BaseHandler{
	
	private static final Logger logger = LoggerFactory.getLogger(WapFrontController.class);
	
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
	public String getRootColumnArticleList(HttpServletRequest request, @PathVariable String rootColumnPath) {
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
		PageInfo<ArticleSummary> articleList = null;
		List<ArticleSummary> articleListAll = null;
		PageInfo<ArticleSummary> noticeList = null;
		switch (type) {
		//简介类
		case 0:
			result = "wap/about";
			//获取展示内容
			article = articleService.getArticleByColumnId(column.getId());
			request.setAttribute("article", article);
			break;
		//新闻类
		case 1:
			result = "wap/news";
			articleList = articleService.getArticleListByColumnId(column.getId());
			request.setAttribute("pageInfo", articleList);
			break;
		//展示类
		case 2:
			result = "wap/imageTextDisplay";
			articleListAll = articleService.getArticleListAllByColumnId(column.getId());
			request.setAttribute("articleList", articleListAll);
			break;
		//图片一览类
		case 3:
			result = "wap/imageDisplay";
			articleListAll = articleService.getArticleListAllByColumnId(column.getId());
			request.setAttribute("articleList", articleListAll);
			break;
		//超链接类
		case 4:
			Map<String,List<LinksSummary>> linksMap = new LinkedHashMap<>();
			for(Column childColumn : rootColumn.getChildColumn()) {
				List<LinksSummary> linksSummaryList = new ArrayList<>();
				articleListAll = articleService.getArticleListAllByColumnId(childColumn.getId());
				for(ArticleSummary articleSummary : articleListAll) {
					LinksSummary linksSummary = new LinksSummary();
					linksSummary.setTitle(articleSummary.getTitle());
					linksSummary.setHref(articleSummary.getHref());
					linksSummaryList.add(linksSummary);
				}
				linksMap.put(childColumn.getName(), linksSummaryList);
			}
			request.setAttribute("linksSummary", linksMap);
			result = "wap/links";
			break;
		case 5:
			//公告类
			result = "wap/notice";
			noticeList = articleService.getArticleListByColumnId(column.getId());
			request.setAttribute("pageInfo", noticeList);
			break;
		default:
			result = "wap/" + result;
			break;
		}
		return result;
	}
	
	@RequestMapping(value = "/{rootColumnPath}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseJsonData getRootColumnArticleList(HttpServletRequest request, @PathVariable String rootColumnPath, @RequestBody PageBean data) {
		ResponseJsonData result = new ResponseJsonData();
		boolean flag = false;
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
		PageInfo<ArticleSummary> articleList = null;
		try {
			articleList = articleService.getArticleListByColumnId(column.getId(), data.getPageNum());
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("getArticleList Exception", e);
		}
		if (flag) {
			result.setRetcode(SUCCESS);
			result.setPageInfo(articleList);
		} else {
			result.setRetcode(FAIL);
			result.setMsg("获取文章列表失败");
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
	public String getColumnArticleList(HttpServletRequest request, @PathVariable String rootColumnPath, @PathVariable String columnPath) {
		HttpSession session = getSession(request);
		Integer channel = getChannel(request);
		String rootPath = BASEPATH + rootColumnPath;
		session.setAttribute(CURRENT_PATH_SESSION, rootPath);
		Column rootColumn = columnService.getColumnByPath(rootPath, channel);
		request.setAttribute("rootColumn", rootColumn);
		Integer type = rootColumn.getType();
		String result = rootColumnPath;
		if (type == 2) {
			result = "wap/imageTextDisplayDetail";
			Article article = articleService.getArticleByKey(Integer.valueOf(columnPath));
			request.setAttribute("article", article);
		}else {
			String path = BASEPATH + rootColumnPath + "/" + columnPath;
			Column column = columnService.getColumnByPath(path, channel);
			request.setAttribute("column", column);
			//理事会名录
			if(column.getType() == 6) {
				List<ArticleSummary> articleListAll = null;
				Map<String,List<ArticleSummary>> articleGroupMap = new LinkedHashMap<>();
				result = "wap/imageListGroupDisplay";
				List<Column> childColumn = column.getChildColumn();
				if(null != childColumn && childColumn.size() > 0) {
					for(Column child : childColumn) {
						articleListAll = articleService.getArticleListAllByColumnId(child.getId());
						articleGroupMap.put(child.getName(), articleListAll);
					}
				}
				request.setAttribute("articleGroup", articleGroupMap);
			}else {
				switch (type) {
					case 0:
						result = "wap/about";
						//获取展示内容
						Article article = articleService.getArticleByColumnId(column.getId());
						request.setAttribute("article", article);
						break;
					case 1:
						result = "wap/news";
						PageInfo<ArticleSummary> articleList = articleService.getArticleListByColumnId(column.getId());
						request.setAttribute("pageInfo", articleList);
						break;
					default:
						break;
				}
			}
		}
		return result;
	}
	
	@RequestMapping(value = "/{rootColumnPath}/{columnPath}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseJsonData getColumnArticleList(HttpServletRequest request, @PathVariable String rootColumnPath, @PathVariable String columnPath, @RequestBody PageBean data) {
		ResponseJsonData result = new ResponseJsonData();
		boolean flag = false;
		HttpSession session = getSession(request);
		Integer channel = getChannel(request);
		String rootPath = BASEPATH + rootColumnPath;
		String path = BASEPATH + rootColumnPath + "/" + columnPath;
		session.setAttribute(CURRENT_PATH_SESSION, rootPath);
		Column rootColumn = columnService.getColumnByPath(rootPath, channel);
		Column column = columnService.getColumnByPath(path, channel);
		request.setAttribute("rootColumn", rootColumn);
		request.setAttribute("column", column);
		PageInfo<ArticleSummary> articleList = null;
		try {
			articleList = articleService.getArticleListByColumnId(column.getId(), data.getPageNum());
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("getArticleList Exception", e);
		}
		if (flag) {
			result.setRetcode(SUCCESS);
			result.setPageInfo(articleList);
		} else {
			result.setRetcode(FAIL);
			result.setMsg("获取文章列表失败");
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
		return "wap/newsDetail";
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
		return "wap/noticeDetail";
	}
}
