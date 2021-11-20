package com.cs3343_Group16.greedySnake.model.details;

import java.awt.Graphics;

import com.cs3343_Group16.greedySnake.model.Snake;

public class PlayerSnake extends Snake {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8210578070428082187L;

	private static PlayerSnake instance = null;

	private PlayerSnake() {
		super();
	}

	public static PlayerSnake getInstance() {
		if (instance == null) {
			instance = new PlayerSnake();
		}
		return instance;
	}

	@Override
	public void drawSnake(Graphics snake) {
		super.drawSnake(snake);
	}

	@Override
	public void initial() {
		super.initial();
	}

	@Override
	protected void initSnake() {
		super.initSnake();
	}

	@Override
	public boolean selfDeathDetection() {
		return super.selfDeathDetection();
	}

	@Override
	public boolean selfForeignalItemDetection(int fiXPos, int fiYPos) {
		return super.selfForeignalItemDetection(fiXPos, fiYPos);
	}
	
	@Override
	public void updateMapStatus() {
		super.updateMapStatus();
	}

	@Override
	public int getHeadXPos() {
		return super.getHeadXPos();
	}

	@Override
	public int getHeadYPos() {
		return super.getHeadYPos();
	}

	@Override
	public int getMove() {
		return super.getMove();
	}

	@Override
	public void updateMove() {
		super.updateMove();
	}

	@Override
	public int getScore() {
		return super.getScore();
	}

	@Override
	public void updateScore(int point) {
		super.updateScore(point);
	}

	@Override
	public int getLength() {
		return super.getLength();
	}

	@Override
	public void updateLength() {
		super.updateLength();
	}

	@Override
	public String getDirection() {
		return super.getDirection();
	}

	@Override
	public void setDirection(String moveDirection) {
		super.setDirection(moveDirection);
	}

	@Override
	public int getXCoordinate(int index) {
		return super.getXCoordinate(index);
	}

	@Override
	public void setXCoordinate(int index, int xPos) {
		super.setXCoordinate(index, xPos);
	}

	@Override
	public int getYCoordinate(int index) {
		return super.getYCoordinate(index);
	}

	@Override
	public void setYCoordinate(int index, int yPos) {
		super.setYCoordinate(index, yPos);
	}

}
