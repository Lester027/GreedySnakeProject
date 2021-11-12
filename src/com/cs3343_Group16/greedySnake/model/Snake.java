package com.cs3343_Group16.greedySnake.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Hashtable;

import com.cs3343_Group16.greedySnake.system.SConstant;

public class Snake extends Game {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4939229904486002144L;

	private static Snake instance = null;
	private int score = 0;
	private int moves = -1;
	private int length = SConstant.SC_INIT_SNAKE_LENGTH;
	private String direction = SConstant.SC_SNAKE_MOVE_DIRECTION_DEATH_FLAG;
	private int[] xCoordinate = new int[750];
	private int[] yCoordinate = new int[750];
	private Hashtable<String, Integer> coordinate;
	private ArrayList<Hashtable<String, Integer>> snakePos;

	private Snake() {
		coordinate = new Hashtable<String, Integer>();
		snakePos = new ArrayList<Hashtable<String, Integer>>();
		coordinate.put(SConstant.SC_COORDINATE_KEY_XPOS, -1);
		coordinate.put(SConstant.SC_COORDINATE_KEY_YPOS, -1);
	}

	public static Snake getInstance() {
		if (instance == null) {
			instance = new Snake();
		}
		return instance;
	}

	public void drawSnake(Graphics snake) {
		if (moves == -1) {
			initCoordinate();
		}

		for (int i = 0; i < length; i++) {
			if (i == 0) {
				snake.setColor(Color.DARK_GRAY);
			} else {
				snake.setColor(Color.BLACK);
			}
			snake.fillRect(xCoordinate[i], yCoordinate[i], SConstant.SC_DEFAULT_NODE_SIZE,
					SConstant.SC_DEFAULT_NODE_SIZE);

		}
	}

	public void initial() {
		moves = 0;
		score = 0;
		length = SConstant.SC_INIT_SNAKE_LENGTH;

		initCoordinate();
	}

	private void initCoordinate() {
		int tempXPos = SConstant.SC_INIT_SNAKE_HEAD_XPOS;
		for(int i = 0; i<SConstant.SC_INIT_SNAKE_LENGTH; i++) {
			coordinate.replace(SConstant.SC_COORDINATE_KEY_XPOS, tempXPos);
			coordinate.replace(SConstant.SC_COORDINATE_KEY_YPOS, SConstant.SC_INIT_SNAKE_HEAD_YPOS);
			snakePos.add(coordinate);
			tempXPos -= SConstant.SC_DEFAULT_NODE_SIZE;
		}
		xCoordinate[0] = SConstant.SC_INIT_SNAKE_HEAD_XPOS;
		xCoordinate[1] = SConstant.SC_INIT_SNAKE_HEAD_XPOS - SConstant.SC_DEFAULT_NODE_SIZE;
		xCoordinate[2] = SConstant.SC_INIT_SNAKE_HEAD_XPOS - 2 * SConstant.SC_DEFAULT_NODE_SIZE;

		yCoordinate[0] = SConstant.SC_INIT_SNAKE_HEAD_YPOS;
		yCoordinate[1] = SConstant.SC_INIT_SNAKE_HEAD_YPOS;
		yCoordinate[2] = SConstant.SC_INIT_SNAKE_HEAD_YPOS;
	}

	private void death() {
		this.direction = SConstant.SC_SNAKE_MOVE_DIRECTION_DEATH_FLAG;
	}

	public boolean selfDeathDetection() {
		for (int i = 1; i < length; i++) {
			if (snakePos.get(i) == snakePos.get(0)) {
				this.death();
				return true;
			}
		}
		return false;
	}

	public int getHeadXPos() {
		return snakePos.get(0).get(SConstant.SC_COORDINATE_KEY_XPOS);
	}

	public int getHeadYpos() {
		return snakePos.get(0).get(SConstant.SC_COORDINATE_KEY_YPOS);
	}

	public int getMove() {
		return moves;
	}

	public void updateMove() {
		moves++;
	}

	public int getScore() {
		return score;
	}

	public void updateScore() {
		this.score++;
	}

	public int getLength() {
		return length;
	}

	public void updateLength() {
		this.length++;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String moveDirection) {
		this.direction = moveDirection;
	}

	public int getXCoordinate(int index) {
		return xCoordinate[index];
	}

	public void setXCoordinate(int index, int xpos) {
		this.xCoordinate[index] = xpos;
	}

	public int getYCoordinate(int index) {
		return yCoordinate[index];
	}

	public void setYCoordinate(int index, int ypos) {
		this.yCoordinate[index] = ypos;
	}

}
