package com.jiantong.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jiantong.bean.ColumnTree;
import com.jiantong.entity.CarouselFigure;
import com.jiantong.entity.Column;
import com.jiantong.pojo.ArticleSummary;
import com.jiantong.pojo.ColumnSummary;
import com.jiantong.service.ArticleService;
import com.jiantong.service.CarouselFigureService;
import com.jiantong.service.ColumnService;

/**
 * 网站欢迎首页
 * @author sunbing
 *
 */
@Controller
public class IndexController extends BaseHandler{

	@Autowired
	private ColumnService columnService;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private CarouselFigureService carouselFigureService;
	
	@RequestMapping("/")
	public String index(HttpServletRequest request, Model model){
		HttpSession session = getSession(request);
		Integer channel = getChannel(request);
		session.setAttribute(CURRENT_PATH_SESSION, "");
		//获取导航列表
		List<ColumnTree> dataList = (List<ColumnTree>)session.getAttribute(MENU_SESSION);
		if(null == dataList) {
			List<ColumnTree> columnTreeList = columnService.getShowColumnTree(channel);
			session.setAttribute(MENU_SESSION, columnTreeList);
		}
		//轮播图
		List<CarouselFigure> frontCarouselFigureList = carouselFigureService.getFrontCarouselFigureList();
		request.setAttribute("frontCarouselFigureList", frontCarouselFigureList);
		Column chamberColumn = columnService.getColumnByPath("front/news/chamber", channel);
		List<ArticleSummary> topArticleList = articleService.getArticleListAllByColumnId(chamberColumn.getId());
		request.setAttribute("topArticleList", topArticleList);
		//公告
		Column noticeColumn = columnService.getColumnByPath("front/notice", channel);
		List<ArticleSummary> noticeList = articleService.getArticleListAllByColumnId(noticeColumn.getId());
		request.setAttribute("noticeList", noticeList);
		//新闻动态
		Column newsColumn = columnService.getColumnByPath("front/news", channel);
		List<ColumnSummary> newsSummaryList = new ArrayList<>();
		for(Column column : newsColumn.getChildColumn()) {
			ColumnSummary newsSummary = new ColumnSummary();
			List<ArticleSummary> articleList = articleService.getArticleListTopByColumnId(column.getId(), 10);
			newsSummary.setColumnName(column.getName());
			newsSummary.setColumnPath(column.getPath());
			newsSummary.setArticleList(articleList);
			newsSummaryList.add(newsSummary);
		}
		request.setAttribute("newsSummaryList", newsSummaryList);
		//人文风光
		Column humanityColumn = columnService.getColumnByPath("front/humanity", channel);
		List<ColumnSummary> humanitySummaryList = new ArrayList<>();
		for(Column column : humanityColumn.getChildColumn()) {
			ColumnSummary humanitySummary = new ColumnSummary();
			List<ArticleSummary> articleList = articleService.getArticleListTopByColumnId(column.getId(), 10);
			humanitySummary.setColumnName(column.getName());
			humanitySummary.setColumnPath(column.getPath());
			humanitySummary.setArticleList(articleList);
			humanitySummaryList.add(humanitySummary);
		}
		request.setAttribute("humanitySummaryList", humanitySummaryList);
		//加拿大潮人
		Column chaorenColumn = columnService.getColumnByPath("front/chaosan", channel);
		List<ArticleSummary> chaorenList = articleService.getArticleListTopByColumnId(chaorenColumn.getId(), 4);
		request.setAttribute("chaorenList", chaorenList);
		return "index";
	}
	
}
