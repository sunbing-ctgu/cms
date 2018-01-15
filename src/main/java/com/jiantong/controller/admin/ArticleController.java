package com.jiantong.controller.admin;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.jiantong.bean.ArticleBean;
import com.jiantong.common.ResponseJsonData;
import com.jiantong.controller.admin.base.BaseController;
import com.jiantong.entity.Article;
import com.jiantong.service.ArticleService;
import com.jiantong.vo.ArticleVo;

/**
 * 文章管理Controller层
 * Title:ArticleController
 * Company:jiantong
 * @author sunbing
 * @date 2018年1月15日 下午11:37:42
 */
@Controller
@RequestMapping("/admin/articleManage")
public class ArticleController extends BaseController {

	private final static Logger logger = LoggerFactory.getLogger(ArticleController.class);

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("")
	public String index(HttpServletRequest request) {
		HttpSession session = getSession(request);
		session.setAttribute(INDEX_SESSION, "contentManage/articleManage");
		return "/admin/contentManage/articleManage";
	}
	
	@RequestMapping(value="getArticleList", method=RequestMethod.POST)
	@ResponseBody
	public ResponseJsonData getArticleList(HttpServletRequest request, @RequestBody ArticleBean data) {
		ResponseJsonData result = new ResponseJsonData();
		boolean flag = false;
		PageInfo<Article> articleList = null;
		try {
			articleList = articleService.getArticleList(data);
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
	
	@RequestMapping(value = "/addArticle", method = RequestMethod.POST)
	@ResponseBody
	public ResponseJsonData addArticle(HttpServletRequest request, @RequestBody ArticleVo data) {
		ResponseJsonData result = new ResponseJsonData();
		boolean flag = false;
		try {
			Date date = new Date();
			data.setCreateTime(date);
			data.setUpdateTime(date);
			articleService.addArticle(data);
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("addArticle Exception", e);
		}
		if(flag) {
			result.setRetcode(SUCCESS);
			result.setMsg("添加文章成功！");
		}else {
			result.setRetcode(FAIL);
			result.setMsg("添加文章失败！");
		}
		return result;
	}
	
	@RequestMapping(value = "/updateArticle", method = RequestMethod.POST)
	@ResponseBody
	public ResponseJsonData updateArticle(HttpServletRequest request, @RequestBody ArticleVo data) {
		ResponseJsonData result = new ResponseJsonData();
		boolean flag = false;
		try {
			data.setUpdateTime(new Date());
			articleService.updateArticle(data);
			flag = true; 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("updateArticle Exception", e);
		}
		if(flag) {
			result.setRetcode(SUCCESS);
			result.setMsg("更新文章成功！");
		}else {
			result.setRetcode(FAIL);
			result.setMsg("更新文章失败！");
		}
		return result;
	}
	
	@RequestMapping(value="/deleteArticle", method=RequestMethod.POST)
	@ResponseBody
	public ResponseJsonData deleteArticle(HttpServletRequest request, @RequestBody Map<String, Integer[]> data) {
		ResponseJsonData result = new ResponseJsonData();
		boolean flag = false;
		List<Integer> ids = Arrays.asList(data.get("ids"));
		try {
			articleService.deleteArticle(ids);
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("deleteArticle Exception", e);
		}
		if(flag) {
			result.setRetcode(SUCCESS);
			result.setMsg("删除文章成功！");
		}else {
			result.setRetcode(FAIL);
			result.setMsg("删除文章失败！");
		}
		return result;
	}
}
