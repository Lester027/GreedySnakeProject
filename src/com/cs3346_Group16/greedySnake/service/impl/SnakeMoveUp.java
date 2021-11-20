package com.cs3346_Group16.greedySnake.service.impl;

import java.util.ArrayList;

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

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<ArrayList<Integer>> dummyMove(ArrayList<ArrayList<Integer>> snake, int length) {
		ArrayList<ArrayList<Integer>> result = (ArrayList<ArrayList<Integer>>)snake.clone();
		for(int i = length - 1; i >= 0; i--) {
			result.get(i+1).set(SConstant.SC_COORDINATE_XPOS_KEY, result.get(i).get(SConstant.SC_COORDINATE_XPOS_KEY));
		}
		
		for(int i = length; i >= 0; i--) {
			if(i==0) {
				result.get(i).set(SConstant.SC_COORDINATE_YPOS_KEY, result.get(i).get(SConstant.SC_COORDINATE_YPOS_KEY) - SConstant.SC_DEFAULT_NODE_SIZE);
			}
			else {
				result.get(i).set(SConstant.SC_COORDINATE_YPOS_KEY, result.get(i-1).get(SConstant.SC_COORDINATE_YPOS_KEY));
			}
			if(result.get(i).get(SConstant.SC_COORDINATE_YPOS_KEY) < SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS){
				result.get(i).set(SConstant.SC_COORDINATE_YPOS_KEY, SConstant.SC_SNAKE_AVAIL_MAX_YPOS);
			}
		}
		return result;
	}
}
