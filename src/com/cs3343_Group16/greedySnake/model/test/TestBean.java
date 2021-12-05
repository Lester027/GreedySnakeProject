package com.cs3343_Group16.greedySnake.model.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


import static org.junit.Assert.*;

import com.cs3343_Group16.greedySnake.model.details.*;
import com.cs3343_Group16.greedySnake.system.MapStatement;
import com.cs3343_Group16.greedySnake.system.SConstant;

public class TestBean {
	
	@BeforeEach
	void setUp() throws Exception {
		MapStatement.getInstance().initRecord();
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		MapStatement.getInstance().initRecord();
	}
	
	@Test
	public void testUpdateMapStatus() {
		NormalBean nbean = NormalBean.getInstance();
		nbean.updateMapStatus();
		
		int xpos=nbean.getBeanXPos();
		int ypos=nbean.getBeanYPos();
		
		String[][] records = MapStatement.getInstance().getRecords();
		
		assertEquals(SConstant.SC_MAP_RECORD_BEAN,records[(xpos - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE][(ypos - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE]);
		
	}
	
	@Test
	public void testRefreshPos_1() {
		NormalBean nbean = NormalBean.getInstance();
		
		boolean isContained=false;
		if(nbean.getBeanXPos()>=SConstant.SC_GAMEBODY_BORDER_BEGIN_XPOS && nbean.getBeanXPos()<=SConstant.SC_SNAKE_AVAIL_MAX_XPOS && nbean.getBeanYPos()>=SConstant.SC_GAMEBODY_BORDER_BEGIN_YPOS && nbean.getBeanYPos()<=SConstant.SC_SNAKE_AVAIL_MAX_YPOS) {
			isContained=true;
		}
		
		assertTrue(isContained);
	}
	
}
