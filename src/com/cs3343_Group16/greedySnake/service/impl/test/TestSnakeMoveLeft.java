package com.cs3343_Group16.greedySnake.service.impl.test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cs3343_Group16.greedySnake.model.Snake;
import com.cs3343_Group16.greedySnake.model.details.AISnake;
import com.cs3343_Group16.greedySnake.model.details.PlayerSnake;
import com.cs3343_Group16.greedySnake.service.SnakeMove;
import com.cs3343_Group16.greedySnake.service.impl.SnakeMoveLeft;
import com.cs3343_Group16.greedySnake.system.SConstant;

class TestSnakeMoveLeft {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	//Test case that snake head moves 1 unit (25 pixels) towards left.
	@Test
	public void test_moveLeft_1() {
		Snake snake = PlayerSnake.getInstance();
		SnakeMove move = new SnakeMoveLeft();
		move.move(snake);
		int result = snake.getHeadXPos();
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_XPOS-SConstant.SC_DEFAULT_NODE_SIZE, result);
	}
		
	@Test
	public void test_moveLeft_2() {
		Snake snake = PlayerSnake.getInstance();
		snake.setXCoordinate(0, SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS-SConstant.SC_DEFAULT_NODE_SIZE);
		SnakeMove move = new SnakeMoveLeft();
		move.move(snake);
		int result = snake.getHeadXPos();
		assertEquals(SConstant.SC_SNAKE_AVAIL_MAX_XPOS, result);
	}

	@Test
	public void test_moveLeft_3() {
		Snake snake = AISnake.getInstance();
		snake.setXCoordinate(0, 0);
		SnakeMove move = new SnakeMoveLeft();
		ArrayList<ArrayList<Integer>> dummySnake = snake.clone();
		int dummyLength = snake.getLength();
		ArrayList<ArrayList<Integer>> result = move.dummyMove(dummySnake, dummyLength);
		int result_XPos=result.get(0).get(0);
		assertEquals(SConstant.SC_SNAKE_AVAIL_MAX_XPOS, result_XPos);
	}
	
	@Test
	public void test_moveLeft_4() {
		Snake snake = AISnake.getInstance();
		snake.setXCoordinate(0, SConstant.SC_SNAKE_AVAIL_MAX_XPOS+SConstant.SC_DEFAULT_NODE_SIZE);
		SnakeMove move = new SnakeMoveLeft();
		ArrayList<ArrayList<Integer>> dummySnake = snake.clone();
		int dummyLength = snake.getLength();
		ArrayList<ArrayList<Integer>> result = move.dummyMove(dummySnake, dummyLength);
		int result_XPos=result.get(0).get(0);
		assertEquals(SConstant.SC_SNAKE_AVAIL_MAX_XPOS, result_XPos);
	}
}
