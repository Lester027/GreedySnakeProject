package com.cs3343_Group16.greedySnake.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.cs3343_Group16.greedySnake.system.SConstant;

public class ScoreBean extends Game{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6862656800321979054L;
	private static ScoreBean instance = null;
	private int beanXPos;
	private int beanYPos;
	private final Random randomNumber = new Random();
	
	private ScoreBean() {
		int beanXPosIdx = randomNumber.nextInt(SConstant.SC_BEAN_XPOS_POSSIBLE_AMOUNT);
		int beanYPosIdx = randomNumber.nextInt(SConstant.SC_BEAN_YPOS_POSSIBLE_AMOUNT);
		beanXPos = beanXPosIdx * SConstant.SC_DEFAULT_NODE_SIZE + SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS;
		beanYPos = beanYPosIdx * SConstant.SC_DEFAULT_NODE_SIZE + SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS;
	}
	
	public static ScoreBean getInstance() {
		if(instance == null) {
			instance = new ScoreBean();
		}
		return instance;
	}
	
	public void drawBean(Graphics bean) {
		bean.setColor(Color.RED);
		bean.fillRect(beanXPos, beanYPos, SConstant.SC_DEFAULT_NODE_SIZE, SConstant.SC_DEFAULT_NODE_SIZE);
	}
	
	public void refreshPos() {
		int beanXPosIdx = randomNumber.nextInt(SConstant.SC_BEAN_XPOS_POSSIBLE_AMOUNT);
		int beanYPosIdx = randomNumber.nextInt(SConstant.SC_BEAN_YPOS_POSSIBLE_AMOUNT);
		beanXPos = beanXPosIdx * SConstant.SC_DEFAULT_NODE_SIZE + SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS;
		beanYPos = beanYPosIdx * SConstant.SC_DEFAULT_NODE_SIZE + SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS;
	}
	
	public int getBeanXPos() {
		return beanXPos;
	}
	
	public int getBeanYpos() {
		return beanYPos;
	}
}
