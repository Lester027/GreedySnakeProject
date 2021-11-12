package com.cs3346_Group16.greedySnake.service.impl;

import com.cs3343_Group16.greedySnake.model.Snake;
import com.cs3343_Group16.greedySnake.service.UpdateDirection;
import com.cs3343_Group16.greedySnake.system.SConstant;

public class UpdateDirectionUp implements UpdateDirection {

	@Override
	public void update(Snake snake) {
		if(!SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG.equals(snake.getDirection())) {
			snake.setDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG);
			snake.updateMove();
		}
	}

}
