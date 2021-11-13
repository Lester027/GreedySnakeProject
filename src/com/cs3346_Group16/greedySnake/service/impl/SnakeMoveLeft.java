package com.cs3346_Group16.greedySnake.service.impl;

import com.cs3343_Group16.greedySnake.model.Snake;
import com.cs3343_Group16.greedySnake.service.SnakeMove;
import com.cs3343_Group16.greedySnake.system.SConstant;

public class SnakeMoveLeft implements SnakeMove {

	@Override
	public void move(Snake snake) {
		for (int i = snake.getLength() - 1; i >= 0; i--) {
			snake.setYCoordinate(i + 1, snake.getYCoordinate(i));
		}
		for (int i = snake.getLength(); i >= 0; i--) {
			if (i == 0) {
				snake.setXCoordinate(i, snake.getXCoordinate(i) - SConstant.SC_DEFAULT_NODE_SIZE);
			} else {
				snake.setXCoordinate(i, snake.getXCoordinate(i - 1));
			}
			if(snake.getXCoordinate(i) < SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) {
				snake.setXCoordinate(i, SConstant.SC_SNAKE_AVAIL_MAX_XPOS);
			}
		}
	}

}
