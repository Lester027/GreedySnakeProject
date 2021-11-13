package com.cs3343_Group16.greedySnake.model.details;

import java.awt.Color;
import java.awt.Graphics;

import com.cs3343_Group16.greedySnake.model.Bean;
import com.cs3343_Group16.greedySnake.system.SConstant;

public class NormalBean extends Bean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7840888776119486505L;

	public static NormalBean instance = null;

	private NormalBean() {
		super();
	}

	public static NormalBean getInstance() {
		if (instance == null) {
			instance = new NormalBean();
		}
		return instance;
	}

	@Override
	public void draw(Graphics bean) {
		bean.setColor(Color.green);
		bean.fillRect(super.getBeanXPos(), super.getBeanYPos(), SConstant.SC_DEFAULT_NODE_SIZE,
				SConstant.SC_DEFAULT_NODE_SIZE);
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
