package com.cs3343_Group16.greedySnake.model.details;

import java.awt.Color;
import java.awt.Graphics;

import com.cs3343_Group16.greedySnake.model.Snake;
import com.cs3343_Group16.greedySnake.system.SConstant;

public class AISnake extends Snake {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2932099652767788170L;

	private static AISnake instance = null;

	private AISnake() {
		super();
		initSnake();
		super.updateMove();
		super.setDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
	}

	public static AISnake getInstance() {
		if (instance == null) {
			instance = new AISnake();
		}
		return instance;
	}

	@Override
	public void drawSnake(Graphics snake) {
		for (int i = 0; i < super.getLength(); i++) {
			if (i == 0) {
				snake.setColor(Color.YELLOW);
			} else {
				snake.setColor(Color.PINK);
			}
			snake.fillRect(super.getXCoordinate(i), super.getYCoordinate(i), SConstant.SC_DEFAULT_NODE_SIZE,
					SConstant.SC_DEFAULT_NODE_SIZE);

		}
		
		super.drawInformation(snake);
	}

	@Override
	public void initial() {
		super.initial();
		super.setDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
		
		this.initSnake();
	}

	@Override
	protected void initSnake() {
		int tempXPos = SConstant.SC_INIT_AI_SNAKE_HEAD_XPOS;
		int tempYPos = SConstant.SC_INIT_AI_SNAKE_HEAD_YPOS;
		for (int i = 0; i < SConstant.SC_INIT_SNAKE_LENGTH; i++) {
			super.setXCoordinate(i, tempXPos);
			super.setYCoordinate(i, tempYPos);
			tempXPos -= SConstant.SC_DEFAULT_NODE_SIZE;
		}
	}

	

}