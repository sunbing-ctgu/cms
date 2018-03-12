package com.jiantong.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.jiantong.bean.CarouselFigureBean;
import com.jiantong.entity.CarouselFigure;
import com.jiantong.vo.CarouselFigureVo;

/**
 * 轮播图Service层
 * Title:CarouselFigureService
 * Company:jiantong
 * @author sunbing
 * @date 2018年1月25日 上午12:18:43
 */
public interface CarouselFigureService {
	
	/**
	 * 获取轮播图列表
	 * @param data
	 * @return
	 */
	public PageInfo<CarouselFigure> getCarouselFigureList(CarouselFigureBean data);
	
	/**
	 * 添加轮播图
	 * @return
	 */
	public Integer addCarouselFigure(CarouselFigureVo data);
	
	/**
	 * 更新轮播图
	 * @return
	 */
	public Integer updateCarouselFigure(CarouselFigureVo data);
	
	/**
	 * 删除轮播图
	 * @param ids
	 * @return
	 */
	public Integer deleteCarouselFigure(List<Integer> ids);

	/**
	 * 获取首页轮播图列表
	 * @return
	 */
	public List<CarouselFigure> getFrontCarouselFigureList();
}
