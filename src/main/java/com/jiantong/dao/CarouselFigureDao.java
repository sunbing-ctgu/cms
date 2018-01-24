package com.jiantong.dao;

import java.util.List;

import com.jiantong.entity.CarouselFigure;

public interface CarouselFigureDao {

	/**
	 * 获取轮播图列表（前端）
	 * @return
	 */
	public List<CarouselFigure> getFrontCarouselFigureList();
}
