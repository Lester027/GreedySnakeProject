package com.cs3343_Group16.greedySnake.service.impl;

import com.cs3343_Group16.greedySnake.model.Snake;
import com.cs3343_Group16.greedySnake.service.UpdateDirection;
import com.cs3343_Group16.greedySnake.system.SConstant;

public class UpdateDirectionLeft implements UpdateDirection {

	@Override
	public void update(Snake snake) {
		if(snake != null) {
			if(!SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG.equals(snake.getDirection())) {
				snake.setDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG);
				snake.updateMove();
			}
		}
	}

}
