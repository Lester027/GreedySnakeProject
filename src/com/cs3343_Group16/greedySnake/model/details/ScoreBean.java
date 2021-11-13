package com.cs3343_Group16.greedySnake.model.details;

import java.awt.Color;
import java.awt.Graphics;

import com.cs3343_Group16.greedySnake.model.Bean;
import com.cs3343_Group16.greedySnake.system.SConstant;

public class ScoreBean extends Bean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2975280262155316311L;
	
	private static ScoreBean instance = null;
	
	private ScoreBean() {
		super();
		super.setBeanScore(SConstant.SC_SCORE_BEAN_SCORE);
	}
	
	public static ScoreBean getInstance() {
		if(instance == null) {
			instance = new ScoreBean();
		}
		return instance;
	}
	
	@Override
	public void draw(Graphics bean) {
		bean.setColor(Color.RED);
		bean.fillRect(super.getBeanXPos(), super.getBeanYPos(), SConstant.SC_DEFAULT_NODE_SIZE, SConstant.SC_DEFAULT_NODE_SIZE);
	}

	@Override
	public void refreshPos() {
		super.refreshPos();
	}

	@Override
	public int getBeanXPos() {
		return super.getBeanXPos();
	}

	@Override
	public int getBeanYPos() {
		return super.getBeanYPos();
	}

	@Override
	public int getBeanScore() {
		return super.getBeanScore();
	}
}
