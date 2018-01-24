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
import com.jiantong.pojo.HumanitySummary;
import com.jiantong.pojo.NewsSummary;
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
		//公告
		List<ArticleSummary> noticeList = articleService.getArticleListByColumnId(26);
		request.setAttribute("noticeList", noticeList);
		//新闻动态
		Column newsColumn = columnService.getColumnByPath("front/news", channel);
		List<NewsSummary> newsSummaryList = new ArrayList<>();
		for(Column column : newsColumn.getChildColumn()) {
			NewsSummary newsSummary = new NewsSummary();
			List<ArticleSummary> articleList = articleService.getArticleListByColumnId(column.getId());
			newsSummary.setColumnName(column.getName());
			newsSummary.setColumnPath(column.getPath());
			newsSummary.setArticleList(articleList);
			newsSummaryList.add(newsSummary);
		}
		request.setAttribute("newsSummaryList", newsSummaryList);
		//人文风光
		Column humanityColumn = columnService.getColumnByPath("front/humanity", channel);
		HumanitySummary humanitySummary = new HumanitySummary();
		List<String> columnNameList = new ArrayList<>();
		List<ArticleSummary> humanityArticleList  = new ArrayList<>();
		for(Column column : humanityColumn.getChildColumn()) {
			columnNameList.add(column.getName());
			List<ArticleSummary> articleList = articleService.getArticleListByColumnId(column.getId());
			humanityArticleList.add(articleList.get(0));
		}
		humanitySummary.setColumnNameList(columnNameList);
		humanitySummary.setArticleList(humanityArticleList);
		request.setAttribute("humanitySummary", humanitySummary);
		//加拿大潮人
		List<ArticleSummary> chaorenList = articleService.getArticleListByColumnId(4);
		request.setAttribute("chaorenList", chaorenList);
		return "index";
	}
	
}
