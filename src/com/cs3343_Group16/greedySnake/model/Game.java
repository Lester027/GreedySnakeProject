package com.cs3343_Group16.greedySnake.model;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Game extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -30962980554608186L;
	
	private Background background;
	private ScoreBean bean;
	private Snake snake;
	
	public Game() {
		
	}
	
	public void painting(Graphics gameGraphic) {
		background = Background.getInstance();
		bean = ScoreBean.getInstance();
		snake = Snake.getInstance();
		
		background.drawBackground(gameGraphic);
		bean.drawBean(gameGraphic);
		snake.drawSnake(gameGraphic);
	}

	public Snake getSnake() {
		return Snake.getInstance();
	}
	
	public ScoreBean getBean() {
		return ScoreBean.getInstance();
	}
	
	public static void reinit() {
		Snake.getInstance().initial();
		ScoreBean.getInstance().refreshPos();
	}
	
}
