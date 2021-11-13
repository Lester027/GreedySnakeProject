package com.cs3343_Group16.greedySnake.model;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.cs3343_Group16.greedySnake.model.details.NormalBean;
import com.cs3343_Group16.greedySnake.model.details.ScoreBean;
import com.cs3343_Group16.greedySnake.system.SConstant;

public class Game extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -30962980554608186L;

	private Background background;
	private Bean bean;
	private Snake snake;
	private int time = 0;
	private int countTime = -1;
	private int prevScore = 0;

	public Game() {
	}

	public void painting(Graphics gameGraphic) {
		time++;
		background = Background.getInstance();
		bean = NormalBean.getInstance();
		snake = Snake.getInstance();
		
		if(countTime > 0 && snake.getScore() == prevScore) {
			bean = ScoreBean.getInstance();
			countTime--;
		}
		
		if(countTime > 0 && snake.getScore() > prevScore) {
			bean = NormalBean.getInstance();
			countTime = -1;
			time = 0;
		}
		
		if(time >= SConstant.SC_SCORE_BEAN_DEFAULT_APPEAR_TIME & snake.getScore() > prevScore) {
			bean = ScoreBean.getInstance();
			countTime = SConstant.SC_SCORE_BEAN_DEFAULT_DISAPPEAR_TIME;
		}
		
		if(countTime == 0) {
			time = 0;
		}
		
		prevScore = snake.getScore();

		background.drawBackground(gameGraphic);
		bean.draw(gameGraphic);
		snake.drawSnake(gameGraphic);
	}

	public Snake getSnake() {
		return Snake.getInstance();
	}

	public Bean getBean() {
		if(countTime > 0) {
			return ScoreBean.getInstance();
		}
		return NormalBean.getInstance();
	}

	public void reinit() {
		Snake.getInstance().initial();
		NormalBean.getInstance().refreshPos();
	}
	
	protected boolean isBeanSnakeOverlap(int beanXPos, int beanYPos) {
		if(Snake.getInstance().selfForeignalItemDetection(beanXPos, beanYPos)) {
			return true;
		}
		return false;
	}

}
