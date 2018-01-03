package com.jiantong.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiantong.entity.Column;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring/applicationContext.xml","classpath*:spring/spring-mvc-config.xml"})
public class ColumnServiceImplTest {
	
	@Autowired
	private ColumnService columnService;

	@Test
	public void testGetAllColumn() {
		List<Column> allColumn = columnService.getAllColumn(0);
		System.out.println(allColumn.size());
	}

}
