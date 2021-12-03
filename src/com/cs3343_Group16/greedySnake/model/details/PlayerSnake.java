package com.cs3343_Group16.greedySnake.model.details;

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

}
