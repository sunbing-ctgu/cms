package com.jiantong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiantong.dao.CarouselFigureDao;
import com.jiantong.entity.CarouselFigure;
import com.jiantong.service.CarouselFigureService;
@Service("carouselFigureService")
public class CarouselFigureServiceImpl implements CarouselFigureService {

	@Autowired
	private CarouselFigureDao carouselFigureDao;
	
	@Override
	public List<CarouselFigure> getFrontCarouselFigureList() {
		// TODO Auto-generated method stub
		return carouselFigureDao.getFrontCarouselFigureList();
	}

}
