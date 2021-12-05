package com.cs3343_Group16.greedySnake.action.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cs3343_Group16.greedySnake.action.SnakeSelfAutoMove;
import com.cs3343_Group16.greedySnake.model.Bean;
import com.cs3343_Group16.greedySnake.model.details.AISnake;
import com.cs3343_Group16.greedySnake.model.details.DeathBean;
import com.cs3343_Group16.greedySnake.model.details.NormalBean;
import com.cs3343_Group16.greedySnake.model.details.ScoreBean;
import com.cs3343_Group16.greedySnake.system.MapStatement;
import com.cs3343_Group16.greedySnake.system.SConstant;

class TestFindMapNode {
	@BeforeEach
	void setUp() throws Exception{
		AISnake.getInstance().initial();
		AISnake.getInstance().setDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		AISnake.getInstance().initial();
		AISnake.getInstance().setDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
	}
	
	@Test
	void test_1() {
		AISnake aiSnake = AISnake.getInstance();
		aiSnake.setDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG);
		Bean bean = NormalBean.getInstance();
		SnakeSelfAutoMove.thinkAndMove(aiSnake, bean, SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
	}

	@Test
	void test_2() {
		AISnake aiSnake = AISnake.getInstance();
		aiSnake.setDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG);
		Bean bean = DeathBean.getInstance();
		SnakeSelfAutoMove.thinkAndMove(aiSnake, bean, SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
	}
	
	@Test
	void test_3() {
		AISnake aiSnake = AISnake.getInstance();
		aiSnake.setDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG);
		Bean bean = ScoreBean.getInstance();
		SnakeSelfAutoMove.thinkAndMove(aiSnake, bean, SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
	}
}
