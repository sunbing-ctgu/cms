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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.jiantong.bean.ColumnBean;
import com.jiantong.bean.ColumnTree;
import com.jiantong.common.ResponseJsonData;
import com.jiantong.controller.admin.base.BaseController;
import com.jiantong.entity.Column;
import com.jiantong.entity.User;
import com.jiantong.service.ColumnService;
import com.jiantong.vo.ColumnVo;

/**
 * 栏目管理Controller层
 * <p>Title:ColumnController</p>
 * <p>Company: jiantong</p>
 * @author sunbing
 * @date 2018年1月6日 下午1:47:09
 */
@Controller
@RequestMapping("/admin/columnManage")
public class ColumnController extends BaseController {
	
	private final static Logger logger = LoggerFactory.getLogger(ColumnController.class);
	
	@Autowired
	private ColumnService columnService;
	
	@RequestMapping("")
	public String index(HttpServletRequest request) {
		HttpSession session = getSession(request);
		session.setAttribute(INDEX_SESSION, "contentManage/columnManage");
		return "/admin/contentManage/columnManage";
	}
	
	@RequestMapping(value="/getColumnTree", method=RequestMethod.GET)
	@ResponseBody
	public List<ColumnTree> getColumnTree(HttpServletRequest request) {
		Integer channel = getChannel(request);
		List<ColumnTree> columnTreeList = columnService.getColumnTree(channel);
		return columnTreeList;
	}
	
	@RequestMapping(value="/getColumnList", method=RequestMethod.POST)
	@ResponseBody
	public ResponseJsonData getColumnList(HttpServletRequest request, @RequestBody ColumnBean data) {
		ResponseJsonData result = new ResponseJsonData();
		boolean flag = false;
		PageInfo<Column> columnList = null;
		try {
			columnList = columnService.getColumnList(data);
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("getColumnList Exception", e);
		}
		if (flag) {
			result.setRetcode(SUCCESS);
			result.setPageInfo(columnList);
		} else {
			result.setRetcode(FAIL);
			result.setMsg("获取栏目列表失败");
		}
		return result;
	}
	
	@RequestMapping(value = "/addColumn", method = RequestMethod.POST)
	@ResponseBody
	public ResponseJsonData addColumn(HttpServletRequest request, @RequestBody ColumnVo data) {
		ResponseJsonData result = new ResponseJsonData();
		boolean flag = false;
		try {
			Date date = new Date();
			data.setCreateTime(date);
			data.setUpdateTime(date);
			columnService.addColumn(data);
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("addColumn Exception", e);
		}
		if(flag) {
			result.setRetcode(SUCCESS);
			result.setMsg("添加栏目成功！");
		}else {
			result.setRetcode(FAIL);
			result.setMsg("添加栏目失败！");
		}
		return result;
	}
	
	@RequestMapping(value = "/updateColumn", method = RequestMethod.POST)
	@ResponseBody
	public ResponseJsonData updateColumn(HttpServletRequest request, @RequestBody ColumnVo data) {
		ResponseJsonData result = new ResponseJsonData();
		boolean flag = false;
		try {
			data.setUpdateTime(new Date());
			columnService.updateColumn(data);
			flag = true; 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("updateColumn Exception", e);
		}
		if(flag) {
			result.setRetcode(SUCCESS);
			result.setMsg("更新栏目成功！");
		}else {
			result.setRetcode(FAIL);
			result.setMsg("更新栏目失败！");
		}
		return result;
	}
	
	@RequestMapping(value="/deleteColumn", method=RequestMethod.POST)
	@ResponseBody
	public ResponseJsonData deleteColumn(HttpServletRequest request, @RequestBody  Map<String, Integer[]> data) {
		ResponseJsonData result = new ResponseJsonData();
		boolean flag = false;
		List<Integer> ids = Arrays.asList(data.get("ids"));
		try {
			columnService.deleteColumn(ids);
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("deleteColumn Exception", e);
		}
		if(flag) {
			result.setRetcode(SUCCESS);
			result.setMsg("删除栏目成功！");
		}else {
			result.setRetcode(FAIL);
			result.setMsg("删除栏目失败！");
		}
		return result;
	}
}
