package com.cs3343_Group16.greedySnake.service.impl.test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.KeyEvent;

import org.junit.jupiter.api.Test;

import com.cs3343_Group16.greedySnake.action.UIPainting;
import com.cs3343_Group16.greedySnake.model.Snake;
import com.cs3343_Group16.greedySnake.model.details.PlayerSnake;
import com.cs3343_Group16.greedySnake.service.UpdateDirection;
import com.cs3343_Group16.greedySnake.service.impl.UpdateDirectionRight;

class TestUpdateDirectionRight {
	//Unit test
	@Test
	void test_updateMoveRight_1() {
		Snake stubSnake = PlayerSnake.getInstance();
		int beforeMove = stubSnake.getMove();
		stubSnake.updateMove();
		int afterMove = stubSnake.getMove();
		int result = stubSnake.getMove();
		assertEquals(beforeMove+1, result);
	}
	//integration
	@Test
	void test_updateMoveRight_integrt_1() {
		Snake stubSnake = PlayerSnake.getInstance();
		UIPainting uiPaint = new UIPainting();
		KeyEvent input = new KeyEvent(uiPaint, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT,'A');
		uiPaint.keyPressed(input);
		int beforeMove = stubSnake.getMove();
		stubSnake.updateMove();
		int afterMove = stubSnake.getMove();
		String result = stubSnake.getDirection();
		assertEquals("Rightward", result);
	}
	
	//Unit test
	@Test
	void test_setDirectionRight() {
		Snake stubSnake = PlayerSnake.getInstance();
		stubSnake.setDirection("Rightward");
		String result = stubSnake.getDirection();
		assertEquals("Rightward", result);
	}
	
	@Test
	void test_updateMoveRight_2() {
		Snake snake = PlayerSnake.getInstance();
		snake.setDirection("Rightward");
		UpdateDirection updateDir = new UpdateDirectionRight();
		updateDir.update(snake);
		String result = snake.getDirection();
		assertEquals("Rightward", result);
	}
	
	@Test
	void test_updateMoveRight_3() {
		Snake snake = null;
		UpdateDirection updateDir = new UpdateDirectionRight();
		updateDir.update(snake);
	}
	
	@Test
	void test_updateMoveRight_4() {
		Snake snake = PlayerSnake.getInstance();
		snake.setDirection("Leftward");
		UpdateDirection updateDir = new UpdateDirectionRight();
		updateDir.update(snake);
		String result = snake.getDirection();
		assertEquals("Leftward", result);
	}
}
