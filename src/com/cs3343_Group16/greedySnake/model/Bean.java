package com.cs3343_Group16.greedySnake.model;

import java.awt.Graphics;
import java.util.Random;

import com.cs3343_Group16.greedySnake.system.SConstant;

public abstract class Bean extends Game{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6862656800321979054L;
	private int beanXPos;
	private int beanYPos;
	private int beanScore;
	private final Random randomNumber = new Random();
	
	protected Bean() {
		this.beanScore = SConstant.SC_DEFAULT_BEAN_SCORE;
		refreshPos();
	}
	
	public abstract void draw(Graphics bean);
	
	public void refreshPos() {
		int beanXPosIdx = randomNumber.nextInt(SConstant.SC_BEAN_XPOS_POSSIBLE_AMOUNT);
		int beanYPosIdx = randomNumber.nextInt(SConstant.SC_BEAN_YPOS_POSSIBLE_AMOUNT);
		beanXPos = beanXPosIdx * SConstant.SC_DEFAULT_NODE_SIZE + SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS;
		beanYPos = beanYPosIdx * SConstant.SC_DEFAULT_NODE_SIZE + SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS;
		if(super.isBeanSnakeOverlap(this.beanXPos, this.beanYPos)) {
			refreshPos();
		}
	}
	
	public int getBeanXPos() {
		return beanXPos;
	}
	
	public int getBeanYPos() {
		return beanYPos;
	}

	public int getBeanScore() {
		return beanScore;
	}

	protected void setBeanScore(int beanScore) {
		this.beanScore = beanScore;
	}
}
