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
import com.jiantong.bean.CarouselFigureBean;
import com.jiantong.common.ResponseJsonData;
import com.jiantong.controller.admin.base.BaseController;
import com.jiantong.entity.CarouselFigure;
import com.jiantong.entity.User;
import com.jiantong.service.CarouselFigureService;
import com.jiantong.vo.CarouselFigureVo;
import com.jiantong.vo.UserVo;

/**
 * 轮播图管理控制层
 * Title:CarouselFigureController
 * Company:jiantong
 * @author sunbing
 * @date 2018年3月13日 上午1:37:22
 */
@Controller
@RequestMapping("/admin/carouselFigureManage")
public class CarouselFigureController extends BaseController {

	private final static Logger logger = LoggerFactory.getLogger(CarouselFigureController.class);
	
	@Autowired
	private CarouselFigureService carouselFigureService;
	
	@RequestMapping("")
	public String index(HttpServletRequest request) {
		HttpSession session = getSession(request);
		session.setAttribute(INDEX_SESSION, "contentManage/carouselFigureManage");
		return "/admin/contentManage/carouselFigureManage";
	}
	
	@RequestMapping(value="/getCarouselFigureList", method=RequestMethod.POST)
	@ResponseBody
	public ResponseJsonData getCarouselFigureList(HttpServletRequest request, @RequestBody CarouselFigureBean data) {
		ResponseJsonData result = new ResponseJsonData();
		boolean flag = false;
		PageInfo<CarouselFigure> carouselFigureList = null;
		try {
			carouselFigureList = carouselFigureService.getCarouselFigureList(data);
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("getCarouselFigureList Exception", e);
		}
		if (flag) {
			result.setRetcode(SUCCESS);
			result.setPageInfo(carouselFigureList);
		} else {
			result.setRetcode(FAIL);
			result.setMsg("获取轮播图表失败");
		}
		return result;
	}
	
	@RequestMapping(value = "/addCarouselFigure", method = RequestMethod.POST)
	@ResponseBody
	public ResponseJsonData addCarouselFigure(HttpServletRequest request, @RequestBody CarouselFigureVo data) {
		ResponseJsonData result = new ResponseJsonData();
		boolean flag = false;
		try {
			Date date = new Date();
			data.setStatus(1);
			data.setCreateTime(date);
			data.setUpdateTime(date);
			carouselFigureService.addCarouselFigure(data);
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("addCarouselFigure Exception", e);
		}
		if(flag) {
			result.setRetcode(SUCCESS);
			result.setMsg("添加轮播图成功！");
		}else {
			result.setRetcode(FAIL);
			result.setMsg("添加轮播图失败！");
		}
		return result;
	}
	
	@RequestMapping(value = "/updateCarouselFigure", method = RequestMethod.POST)
	@ResponseBody
	public ResponseJsonData updateCarouselFigure(HttpServletRequest request, @RequestBody CarouselFigureVo data) {
		ResponseJsonData result = new ResponseJsonData();
		boolean flag = false;
		try {
			carouselFigureService.updateCarouselFigure(data);
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("updateCarouselFigure Exception", e);
		}
		if(flag) {
			result.setRetcode(SUCCESS);
			result.setMsg("更新轮播图成功！");
		}else {
			result.setRetcode(FAIL);
			result.setMsg("更新轮播图失败！");
		}
		return result;
	}
	
	@RequestMapping(value="/deleteCarouselFigure", method=RequestMethod.POST)
	@ResponseBody
	public ResponseJsonData deleteCarouselFigure(HttpServletRequest request, @RequestBody  Map<String, Integer[]> data) {
		ResponseJsonData result = new ResponseJsonData();
		boolean flag = false;
		List<Integer> ids = Arrays.asList(data.get("ids"));
		User user = getUser(request);
		try {
			carouselFigureService.deleteCarouselFigure(ids);
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("deleteCarouselFigure Exception", e);
		}
		if(flag) {
			result.setRetcode(SUCCESS);
			result.setMsg("删除轮播图成功！");
		}else {
			result.setRetcode(FAIL);
			result.setMsg("删除轮播图失败！");
		}
		return result;
	}
}
