package com.cs3343_Group16.greedySnake.model.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.cs3343_Group16.greedySnake.model.Game;
import com.cs3343_Group16.greedySnake.model.Snake;
import com.cs3343_Group16.greedySnake.model.details.*;
import com.cs3343_Group16.greedySnake.system.SConstant;

import static org.junit.Assert.*;

public class TestGame {
	
	@BeforeEach
	void setUp() throws Exception {
		AISnake.getInstance().initial();
		PlayerSnake.getInstance().initial();
	}
	
	@AfterEach
	public void tearDown() throws Exception {
	    AISnake.getInstance().initial();
	    PlayerSnake.getInstance().initial();
	}
	
	@Test
	public void testSetMode() {
		Game g =new Game();
		g.setMode(SConstant.SC_GAME_MODE_PlAYER);
		assertEquals(SConstant.SC_GAME_MODE_PlAYER,g.getMode());
	}
	
	@Test
	public void testGetSnake_1() {
		Game g =new Game();
		Snake s =g.getSnake();
		assertNull(s);
	}

	@Test
	public void testSetSnake_1() {
		Game g =new Game();
		g.setMode(SConstant.SC_GAME_MODE_PlAYER);
		g.setSnake();
		Snake s =g.getSnake();
		assertEquals(PlayerSnake.getInstance(),s);
	}

	@Test
	public void testSetSnake_2() {
		Game g =new Game();
		g.setMode(SConstant.SC_GAME_MODE_AI);
		g.setSnake();
		Snake s =g.getSnake();
		assertEquals(AISnake.getInstance(),s);
	}
	
	@Test
	public void testGetBean_1() {
		Game g =new Game();
		assertEquals(NormalBean.getInstance(),g.getBean());
	}
	
	@Test
	public void testGenerateBean_1() {
		Game g =new Game();
		g.setMode(SConstant.SC_GAME_MODE_PlAYER);
		g.setSnake();
		g.setCountTime(SConstant.SC_SCORE_BEAN_DEFAULT_DISAPPEAR_TIME);
		g.generateBean();
		assertEquals(ScoreBean.getInstance(),g.getBean());
	}
	
	@Test
	public void testGenerateBean_2() {
		Game g =new Game();
		g.setMode(SConstant.SC_GAME_MODE_PlAYER);
		g.setSnake();
		g.generateBean();
		assertEquals(NormalBean.getInstance(),g.getBean());
	}
	
	@Test
	public void testGenerateBean_3() {
		Game g =new Game();
		g.setMode(SConstant.SC_GAME_MODE_PlAYER);
		g.setSnake();
		g.getSnake().updateScore(1);
		g.setCountTime(SConstant.SC_SCORE_BEAN_DEFAULT_DISAPPEAR_TIME);
		g.generateBean();
		assertEquals(NormalBean.getInstance(),g.getBean());
	}
	
	@Test
	public void testGenerateBean_4() {
		Game g =new Game();
		g.setMode(SConstant.SC_GAME_MODE_PlAYER);
		g.setSnake();
		for(int i=0;i<=SConstant.SC_SCORE_BEAN_DEFAULT_APPEAR_TIME;i++) {
			g.increaseTime();
		}
		g.generateBean();
		assertEquals(NormalBean.getInstance(),g.getBean());
	}
	
	@Test
	public void testGenerateBean_5() {
		Game g =new Game();
		g.setMode(SConstant.SC_GAME_MODE_PlAYER);
		g.setSnake();
		for(int i=0;i<=SConstant.SC_SCORE_BEAN_DEFAULT_APPEAR_TIME;i++) {
			g.increaseTime();
		}
		g.getSnake().updateScore(1);
		g.generateBean();
		assertEquals(ScoreBean.getInstance(),g.getBean());
	}
	
	@Test
	public void testGenerateBean_6() {
		Game g =new Game();
		g.setMode(SConstant.SC_GAME_MODE_PlAYER);
		g.setSnake();
		g.setCountTime(1);
		g.generateBean();
		assertEquals(ScoreBean.getInstance(),g.getBean());
	}
	
	@Test 
	public void testReinit() {
		Game g =new Game();
		g.setMode(SConstant.SC_GAME_MODE_AI);
		g.reinit();
		
		assertEquals( SConstant.SC_GAME_MODE_DEFAULT,g.getMode());
	}
	
	@Test
	public void testIsBeanSnakeOverlap_1() {
		Game g = new Game();
		boolean result=g.isBeanSnakeOverlap(SConstant.SC_INIT_AI_SNAKE_HEAD_XPOS, SConstant.SC_INIT_AI_SNAKE_HEAD_YPOS);
		
		assertTrue(result);
	}
	
	@Test
	public void testIsBeanSnakeOverlap_2() {
		Game g = new Game();
		boolean result=g.isBeanSnakeOverlap(SConstant.SC_INIT_SNAKE_HEAD_XPOS, SConstant.SC_INIT_SNAKE_HEAD_YPOS);
		
		assertTrue(result);
	}
	
	@Test
	public void testIsBeanSnakeOverlap_3() {
		Game g = new Game();
		boolean result=g.isBeanSnakeOverlap(SConstant.SC_MAP_X_AXIS_CAPACITY,SConstant.SC_MAP_Y_AXIS_CAPACITY);
		
		assertFalse(result);
	}

}
