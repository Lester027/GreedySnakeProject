package com.cs3343_Group16.greedySnake.model;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.cs3343_Group16.greedySnake.model.details.AISnake;
import com.cs3343_Group16.greedySnake.model.details.NormalBean;
import com.cs3343_Group16.greedySnake.model.details.PlayerSnake;
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
	private String mode;
	private int time = 0;
	private int countTime = -1;
	private int prevScore = 0;

	public Game() {
		this.mode = SConstant.SC_GAME_MODE_DEFAULT;
	}

	public void painting(Graphics gameGraphic) {
		increaseTime();
		setSnake();
		background = Background.getInstance();
		bean = NormalBean.getInstance();
		background.drawBackground(gameGraphic);
		
		if(!SConstant.SC_GAME_MODE_DEFAULT.equals(this.mode)) {
			generateBean();			
			bean.draw(gameGraphic);
			snake.drawSnake(gameGraphic);
		}
		
		}

	public void increaseTime() {
		time++;
	}
		
	public void setCountTime(int c) {
		countTime=c;
	}
	
	public void generateBean() {
			if (countTime > 0 && snake.getScore() == prevScore) {
				bean = ScoreBean.getInstance();
				countTime--;
			}

			if (countTime > 0 && snake.getScore() > prevScore) {
				bean = NormalBean.getInstance();
				countTime = -1;
				time = 0;
			}

		if (time >= SConstant.SC_SCORE_BEAN_DEFAULT_APPEAR_TIME && snake.getScore() > prevScore) {
				bean = ScoreBean.getInstance();
				countTime = SConstant.SC_SCORE_BEAN_DEFAULT_DISAPPEAR_TIME;
			}

			if (countTime == 0) {
				time = 0;
			}
			
			prevScore = snake.getScore();
		}
		
	public void setSnake() {
		if(SConstant.SC_GAME_MODE_PlAYER.equals(this.mode)) {
			snake= PlayerSnake.getInstance();
		}else if(SConstant.SC_GAME_MODE_AI.equals(this.mode)) {
			snake= AISnake.getInstance();
		}
	}

	public Snake getSnake() {
		if(snake==null) {
			setSnake();
		}
		return snake;
	}

	public Bean getBean() {
		if(bean==null) {
		return NormalBean.getInstance();
	}
		return bean;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public void reinit() {
		PlayerSnake.getInstance().initial();
		AISnake.getInstance().initial();
		NormalBean.getInstance().refreshPos();
		this.mode = SConstant.SC_GAME_MODE_DEFAULT;
	}

	public boolean isBeanSnakeOverlap(int beanXPos, int beanYPos) {
		if (PlayerSnake.getInstance().selfForeignalItemDetection(beanXPos, beanYPos)
				|| AISnake.getInstance().selfForeignalItemDetection(beanXPos, beanYPos)) {
			return true;
		}
		return false;
	}
}
