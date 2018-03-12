package com.jiantong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiantong.bean.CarouselFigureBean;
import com.jiantong.dao.CarouselFigureDao;
import com.jiantong.entity.CarouselFigure;
import com.jiantong.entity.User;
import com.jiantong.service.CarouselFigureService;
import com.jiantong.vo.CarouselFigureVo;
@Service("carouselFigureService")
public class CarouselFigureServiceImpl implements CarouselFigureService {

	@Autowired
	private CarouselFigureDao carouselFigureDao;
	
	@Override
	public List<CarouselFigure> getFrontCarouselFigureList() {
		// TODO Auto-generated method stub
		return carouselFigureDao.getFrontCarouselFigureList();
	}

	@Override
	public PageInfo<CarouselFigure> getCarouselFigureList(CarouselFigureBean data) {
		// TODO Auto-generated method stub
		PageHelper.startPage(data.getPageNum(), data.getPageSize());
		List<CarouselFigure> carouselFigureList = carouselFigureDao.getCarouselFigureList(data);
		PageInfo<CarouselFigure> result = null;
		if (null != carouselFigureList) {
			result = new PageInfo<CarouselFigure>(carouselFigureList);
		}
		return result;
	}

	@Override
	public Integer addCarouselFigure(CarouselFigureVo data) {
		// TODO Auto-generated method stub
		return carouselFigureDao.addCarouselFigure(data);
	}

	@Override
	public Integer updateCarouselFigure(CarouselFigureVo data) {
		// TODO Auto-generated method stub
		return carouselFigureDao.updateCarouselFigure(data);
	}

	@Override
	public Integer deleteCarouselFigure(List<Integer> ids) {
		// TODO Auto-generated method stub
		return carouselFigureDao.deleteCarouselFigureList(ids);
	}

}
