package com.cs3343_Group16.greedySnake.service.impl.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cs3343_Group16.greedySnake.model.Snake;
import com.cs3343_Group16.greedySnake.model.details.PlayerSnake;
import com.cs3343_Group16.greedySnake.service.UpdateDirection;
import com.cs3343_Group16.greedySnake.service.impl.UpdateDirectionLeft;

class TestUpdateDirectionLeft {
	//Unit test
	@Test
	void test_updateMoveLeft_1() {
		Snake stubSnake = PlayerSnake.getInstance();
		int beforeMove = stubSnake.getMove();
		stubSnake.setDirection("Leftward");
		stubSnake.updateMove();
		int afterMove = stubSnake.getMove();
		int result = stubSnake.getMove();
		assertEquals(beforeMove+1, result);
	}
	//Unit test
	@Test
	void test_setDirectionLeft() {
		Snake stubSnake = PlayerSnake.getInstance();
		stubSnake.setDirection("Leftward");
		String result = stubSnake.getDirection();
		assertEquals("Leftward", result);
	}
	
	@Test
	void test_updateMoveLeft() {
		Snake snake = PlayerSnake.getInstance();
		snake.setDirection("Leftward");
		UpdateDirection updateDir = new UpdateDirectionLeft();
		updateDir.update(snake);
		String result = snake.getDirection();
		assertEquals("Leftward", result);
	}
	
	@Test
	void test_updateMoveLeft_3() {
		Snake snake = null;
		UpdateDirection updateDir = new UpdateDirectionLeft();
		updateDir.update(snake);
	}
	
	@Test
	void test_updateMoveLeft_4() {
		Snake snake = PlayerSnake.getInstance();
		snake.setDirection("Rightward");
		UpdateDirection updateDir = new UpdateDirectionLeft();
		updateDir.update(snake);
		String result = snake.getDirection();
		assertEquals("Rightward", result);
	}
}
