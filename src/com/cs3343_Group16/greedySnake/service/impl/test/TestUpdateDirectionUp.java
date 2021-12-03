package com.cs3343_Group16.greedySnake.service.impl.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cs3343_Group16.greedySnake.model.Snake;
import com.cs3343_Group16.greedySnake.model.details.PlayerSnake;
import com.cs3343_Group16.greedySnake.service.UpdateDirection;
import com.cs3343_Group16.greedySnake.service.impl.UpdateDirectionUp;

class TestUpdateDirectionUp {
	//Unit test
	@Test
	void test_updateMoveUp_1() {
		Snake stubSnake = PlayerSnake.getInstance();
		int beforeMove = stubSnake.getMove();
		stubSnake.setDirection("Upward");
		stubSnake.updateMove();
		int result = stubSnake.getMove();
		assertEquals(beforeMove+1, result);
	}
	//Unit test
	@Test
	void test_setDirectionUp() {
		Snake stubSnake = PlayerSnake.getInstance();
		stubSnake.setDirection("Upward");
		String result = stubSnake.getDirection();
		assertEquals("Upward", result);
	}
	
	@Test
	void test_updateMoveUp_2() {
		Snake snake = PlayerSnake.getInstance();
		snake.setDirection("Upward");
		UpdateDirection updateDir = new UpdateDirectionUp();
		updateDir.update(snake);
		String result = snake.getDirection();
		assertEquals("Upward", result);
	}
	
	@Test
	void test_updateMoveUp_3() {
		Snake snake = null;
		UpdateDirection updateDir = new UpdateDirectionUp();
		updateDir.update(snake);
	}
	
	@Test
	void test_updateMoveUp_4() {
		Snake snake = PlayerSnake.getInstance();
		snake.setDirection("Downward");
		UpdateDirection updateDir = new UpdateDirectionUp();
		updateDir.update(snake);
		String result = snake.getDirection();
		assertEquals("Downward", result);
	}
}
