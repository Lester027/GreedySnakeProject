package com.cs3346_Group16.greedySnake.service.impl;

import com.cs3343_Group16.greedySnake.model.Snake;
import com.cs3343_Group16.greedySnake.service.SnakeMove;
import com.cs3343_Group16.greedySnake.system.SConstant;

public class SnakeMoveUp implements SnakeMove {

	@Override
	public void move(Snake snake) {
		for (int i = snake.getLength() - 1; i >= 0; i--) {
			snake.setXCoordinate(i + 1, snake.getXCoordinate(i));
		}
		for (int i = snake.getLength(); i >= 0; i--) {
			if (i == 0) {
				snake.setYCoordinate(i, snake.getYCoordinate(i) - SConstant.SC_DEFAULT_NODE_SIZE);
			} else {
				snake.setYCoordinate(i, snake.getYCoordinate(i - 1));
			}
			if(snake.getYCoordinate(i) < SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) {
				snake.setYCoordinate(i, SConstant.SC_SNAKE_AVAIL_MAX_YPOS);
			}
		}
	}

}
