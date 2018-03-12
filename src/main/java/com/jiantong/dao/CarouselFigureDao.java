package com.jiantong.dao;

import java.util.List;

import com.jiantong.bean.CarouselFigureBean;
import com.jiantong.entity.CarouselFigure;
import com.jiantong.vo.CarouselFigureVo;

public interface CarouselFigureDao {

	/**
	 * 获取轮播图列表（前端）
	 * @return
	 */
	public List<CarouselFigure> getFrontCarouselFigureList();
	
	public List<CarouselFigure> getCarouselFigureList(CarouselFigureBean data);
	
	public Integer addCarouselFigure(CarouselFigureVo data);
	
	public Integer updateCarouselFigure(CarouselFigureVo data);
	
	public Integer deleteCarouselFigureList(List<Integer> ids);
}
