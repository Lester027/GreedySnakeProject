package com.cs3343_Group16.greedySnake.service.impl;

import java.util.ArrayList;

import com.cs3343_Group16.greedySnake.model.Snake;
import com.cs3343_Group16.greedySnake.service.SnakeMove;
import com.cs3343_Group16.greedySnake.system.SConstant;

public class SnakeMoveRight implements SnakeMove {

	@Override
	public void move(Snake snake) {
		for (int i = snake.getLength() - 1; i >= 0; i--) {
			snake.setYCoordinate(i + 1, snake.getYCoordinate(i));
		}
		for (int i = snake.getLength(); i >= 0; i--) {
			if (i == 0) {
				snake.setXCoordinate(i, snake.getXCoordinate(i) + SConstant.SC_DEFAULT_NODE_SIZE);
			} else {
				snake.setXCoordinate(i, snake.getXCoordinate(i - 1));
			}
			if (snake.getXCoordinate(i) > SConstant.SC_SNAKE_AVAIL_MAX_XPOS) {
				snake.setXCoordinate(i, SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<ArrayList<Integer>> dummyMove(ArrayList<ArrayList<Integer>> snake, int length) {
		ArrayList<ArrayList<Integer>> result = (ArrayList<ArrayList<Integer>>) snake.clone();
		for (int i = length - 1; i >= 0; i--) {
			result.get(i + 1).set(SConstant.SC_COORDINATE_YPOS_KEY,
					result.get(i).get(SConstant.SC_COORDINATE_YPOS_KEY));
		}
		for (int i = length; i >= 0; i--) {
			if (i == 0) {
				result.get(i).set(SConstant.SC_COORDINATE_XPOS_KEY,
						result.get(i).get(SConstant.SC_COORDINATE_XPOS_KEY) + SConstant.SC_DEFAULT_NODE_SIZE);
			} else {
				result.get(i).set(SConstant.SC_COORDINATE_XPOS_KEY,
						result.get(i - 1).get(SConstant.SC_COORDINATE_XPOS_KEY));
			}
			if (result.get(i).get(SConstant.SC_COORDINATE_XPOS_KEY) > SConstant.SC_SNAKE_AVAIL_MAX_XPOS) {
				result.get(i).set(SConstant.SC_COORDINATE_XPOS_KEY, SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS);
			}
		}
		return result;
	}

}
