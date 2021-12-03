package com.cs3343_Group16.greedySnake.model.details.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import com.cs3343_Group16.greedySnake.model.details.ScoreBean;
import com.cs3343_Group16.greedySnake.system.SConstant;

import static org.junit.Assert.*;

public class TestScoreBean{

	@BeforeEach
	void setUp() throws Exception {
	}
	
	
	@Test
	public void testInitialization() {
		ScoreBean sBean= ScoreBean.getInstance();
		int beanScore= sBean.getBeanScore();
		
		assertEquals(SConstant.SC_SCORE_BEAN_SCORE,beanScore);
	}
	
	@Test
	public void testGetInstance() {
		ScoreBean sBean= ScoreBean.getInstance();
		int beanScore= sBean.getBeanScore();
		
		assertEquals(SConstant.SC_SCORE_BEAN_SCORE,beanScore);
	}
	

}



