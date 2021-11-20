package com.cs3343_Group16.greedySnake.model.details;

import java.awt.Color;
import java.awt.Graphics;

import com.cs3343_Group16.greedySnake.model.Bean;
import com.cs3343_Group16.greedySnake.system.SConstant;

public class DeathBean extends Bean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3143149165197872730L;
	
	private static DeathBean instance = null;
	
	private DeathBean() {
		super();
		super.setBeanScore(SConstant.SC_DEATH_BEAN_SCORE);
	}
	
	public static DeathBean getInstance() {
		if(instance != null) {
			instance = new DeathBean();
		}
		return instance;
	}
	
	@Override
	public void draw(Graphics bean) {
		bean.setColor(Color.DARK_GRAY);
		bean.fillRect(super.getBeanXPos(), super.getBeanYPos(), SConstant.SC_DEFAULT_NODE_SIZE, SConstant.SC_DEFAULT_NODE_SIZE);
	}
	
	@Override
	public void refreshPos() {
		super.refreshPos();
	}
	
	@Override
	public void updateMapStatus() {
		super.updateMapStatus();
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
