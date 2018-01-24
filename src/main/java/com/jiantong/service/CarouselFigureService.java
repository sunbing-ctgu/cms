package com.jiantong.service;

import java.util.List;

import com.jiantong.entity.CarouselFigure;

/**
 * 轮播图Service层
 * Title:CarouselFigureService
 * Company:jiantong
 * @author sunbing
 * @date 2018年1月25日 上午12:18:43
 */
public interface CarouselFigureService {

	/**
	 * 获取首页轮播图列表
	 * @return
	 */
	public List<CarouselFigure> getFrontCarouselFigureList();
}
