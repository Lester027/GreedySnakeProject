package com.cs3343_Group16.greedySnake.model.details.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import com.cs3343_Group16.greedySnake.model.details.*;
import com.cs3343_Group16.greedySnake.system.SConstant;

import static org.junit.Assert.*;

public class TestNormalBean {
	
	@BeforeEach
	void setUp() throws Exception {
	}
	
	
	@Test
	public void testInitialization() {
		NormalBean nBean= NormalBean.getInstance();
		int beanScore= nBean.getBeanScore();
		
		assertEquals(SConstant.SC_DEFAULT_BEAN_SCORE,beanScore);
	}
	
	@Test
	public void testGetInstance() {
		NormalBean nBean= NormalBean.getInstance();
		int beanScore= nBean.getBeanScore();
		
		assertEquals(SConstant.SC_DEFAULT_BEAN_SCORE,beanScore);
	}

}
