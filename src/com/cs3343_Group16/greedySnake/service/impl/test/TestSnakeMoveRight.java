package com.cs3343_Group16.greedySnake.service.impl.test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cs3343_Group16.greedySnake.action.UIPainting;
import com.cs3343_Group16.greedySnake.model.Snake;
import com.cs3343_Group16.greedySnake.model.details.AISnake;
import com.cs3343_Group16.greedySnake.model.details.PlayerSnake;
import com.cs3343_Group16.greedySnake.service.SnakeMove;
import com.cs3343_Group16.greedySnake.service.impl.SnakeMoveRight;
import com.cs3343_Group16.greedySnake.system.SConstant;

class TestSnakeMoveRight {

	@BeforeEach
	void setUp() throws Exception {
		AISnake.getInstance().initial();
		AISnake.getInstance().setDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
		PlayerSnake.getInstance().initial();
		PlayerSnake.getInstance().setDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		AISnake.getInstance().initial();
		AISnake.getInstance().setDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
		PlayerSnake.getInstance().initial();
		PlayerSnake.getInstance().setDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
	}
	
	//Test case that snake head moves 1 unit (25 pixels) towards right.
	@Test
	public void test_moveRight_1() {
		Snake snake = PlayerSnake.getInstance();
		SnakeMove move = new SnakeMoveRight();
		move.move(snake);
		int result = snake.getHeadXPos();
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_XPOS+20, result);
	}
	
	@Test
	public void test_moveRight_integr_1() {
		UIPainting uiPaint = new UIPainting();
		
		Snake snake = PlayerSnake.getInstance();
		SnakeMove move = new SnakeMoveRight();
		move.move(snake);
		int result = snake.getHeadXPos();
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_YPOS, result);
	}
		
	@Test
	public void test_moveRight_2() {
		Snake snake = PlayerSnake.getInstance();
		snake.setXCoordinate(0, SConstant.SC_SNAKE_AVAIL_MAX_XPOS+SConstant.SC_DEFAULT_NODE_SIZE);
		SnakeMove move = new SnakeMoveRight();
		move.move(snake);
		int result = snake.getHeadXPos();
		assertEquals(SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS, result);
	}

	@Test
	public void test_moveRight_3() {
		Snake snake = AISnake.getInstance();
		SnakeMove move = new SnakeMoveRight();
		ArrayList<ArrayList<Integer>> dummySnake = snake.clone();
		int dummyLength = snake.getLength();
		ArrayList<ArrayList<Integer>> result = move.dummyMove(dummySnake, dummyLength);
		int result_XPos=result.get(0).get(0);
		assertEquals(SConstant.SC_DEFAULT_NODE_SIZE, 20);
	}
	
	@Test
	public void test_moveRight_4() {
		Snake snake = AISnake.getInstance();
		snake.setXCoordinate(0, SConstant.SC_SNAKE_AVAIL_MAX_XPOS+SConstant.SC_DEFAULT_NODE_SIZE);
		SnakeMove move = new SnakeMoveRight();
		ArrayList<ArrayList<Integer>> dummySnake = snake.clone();
		int dummyLength = snake.getLength();
		ArrayList<ArrayList<Integer>> result = move.dummyMove(dummySnake, dummyLength);
		int result_XPos=result.get(0).get(0);
		assertEquals(SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS, result_XPos);
	}
}
