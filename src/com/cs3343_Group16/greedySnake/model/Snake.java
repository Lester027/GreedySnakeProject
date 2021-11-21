package com.cs3343_Group16.greedySnake.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;

import com.cs3343_Group16.greedySnake.system.MapStatement;
import com.cs3343_Group16.greedySnake.system.SConstant;

public class Snake extends Game {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4939229904486002144L;

	private int score = 0;
	private int moves = -1;
	private int length = SConstant.SC_INIT_SNAKE_LENGTH;
	private String direction = SConstant.SC_SNAKE_MOVE_DIRECTION_DEATH_FLAG;
	private ArrayList<ArrayList<Integer>> coordinate;

	protected Snake() {
		initCoordinate();
		initSnake();
	}

	@SuppressWarnings("unchecked")
	private void initCoordinate() {
		this.coordinate = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(SConstant.SC_INIT_COORDINATE_VALUE);
		temp.add(SConstant.SC_INIT_COORDINATE_VALUE);
		for (int i = 0; i < SConstant.SC_INIT_MAX_AVAIL_COORDINATE_AMOUNT; i++) {
			this.coordinate.add((ArrayList<Integer>) temp.clone());
		}
		temp.clear();
	}

	protected void drawSnake(Graphics snake) {
		for (int i = 0; i < length; i++) {
			if (i == 0) {
				snake.setColor(Color.DARK_GRAY);
			} else {
				snake.setColor(Color.BLACK);
			}
			snake.fillRect(coordinate.get(i).get(SConstant.SC_COORDINATE_XPOS_KEY),
					coordinate.get(i).get(SConstant.SC_COORDINATE_YPOS_KEY), SConstant.SC_DEFAULT_NODE_SIZE,
					SConstant.SC_DEFAULT_NODE_SIZE);

		}
	}

	protected void initial() {
		moves = 0;
		score = 0;
		length = SConstant.SC_INIT_SNAKE_LENGTH;

		initSnake();
	}

	protected void initSnake() {
		int tempXPos = SConstant.SC_INIT_SNAKE_HEAD_XPOS;
		int tempYPos = SConstant.SC_INIT_SNAKE_HEAD_YPOS;
		for (int i = 0; i < SConstant.SC_INIT_SNAKE_LENGTH; i++) {
			coordinate.get(i).set(SConstant.SC_COORDINATE_XPOS_KEY, tempXPos);
			coordinate.get(i).set(SConstant.SC_COORDINATE_YPOS_KEY, tempYPos);
			tempXPos -= SConstant.SC_DEFAULT_NODE_SIZE;
		}
	}

	private void death() {
		this.direction = SConstant.SC_SNAKE_MOVE_DIRECTION_DEATH_FLAG;
	}

	public boolean selfDeathDetection() {
		ArrayList<Integer> head = coordinate.get(0);
		coordinate.remove(0);
		if (coordinate.contains(head)) {
			this.death();
			return true;
		}
		coordinate.add(0, head);
		return false;
	}

	protected boolean selfForeignalItemDetection(int fiXPos, int fiYPos) {
		if (coordinate.contains(new ArrayList<Integer>(Arrays.asList(fiXPos, fiYPos)))) {
			return true;
		}
		return false;
	}

	public void updateMapStatus() {
		for (int i = 0; i < length; i++) {
			MapStatement.getInstance().updateStatus(this, coordinate.get(i).get(SConstant.SC_COORDINATE_XPOS_KEY),
					coordinate.get(i).get(SConstant.SC_COORDINATE_YPOS_KEY));
		}
	}

	public int getHeadXPos() {
		return coordinate.get(0).get(SConstant.SC_COORDINATE_XPOS_KEY);
	}

	public int getHeadYPos() {
		return coordinate.get(0).get(SConstant.SC_COORDINATE_YPOS_KEY);
	}

	public int getMove() {
		return moves;
	}

	public void updateMove() {
		moves++;
	}

	protected int getScore() {
		return score;
	}

	public void updateScore(int point) {
		this.score += point;
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
		return coordinate.get(index).get(SConstant.SC_COORDINATE_XPOS_KEY);
	}

	public void setXCoordinate(int index, int xPos) {
		this.coordinate.get(index).set(SConstant.SC_COORDINATE_XPOS_KEY, xPos);
	}

	public int getYCoordinate(int index) {
		return coordinate.get(index).get(SConstant.SC_COORDINATE_YPOS_KEY);
	}

	public void setYCoordinate(int index, int yPos) {
		this.coordinate.get(index).set(SConstant.SC_COORDINATE_YPOS_KEY, yPos);
	}

	public ArrayList<ArrayList<Integer>> clone() {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < this.coordinate.size(); i++) {
			result.add(new ArrayList<Integer>());
			for (int j = 0; j < this.coordinate.get(i).size(); j++) {
				result.get(i).add(this.coordinate.get(i).get(j));
			}
		}
		return result;
	}

}
