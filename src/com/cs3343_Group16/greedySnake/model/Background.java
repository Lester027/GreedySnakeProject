package com.cs3343_Group16.greedySnake.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.cs3343_Group16.greedySnake.system.SConstant;

public class Background extends Game{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1616490547013853151L;
	private static Background instance = null;
	private Snake snake;
	
	private Background() {
		
	}
	
	public static Background getInstance() {
		if(instance == null) {
			instance = new Background();
		}
		return instance;
	}
	
	public void drawBackground(Graphics gameGround) {
		//draw title background border
		gameGround.setColor(Color.YELLOW);
		gameGround.drawRect(SConstant.SC_TITLE_BACKGOURND_BORDER_BEGIN_XPOS, SConstant.SC_TITLE_BACKGROUND_BORDER_BEGIN_YPOS, SConstant.SC_TITLE_BACKGOURND_BORDER_WIDTH, SConstant.SC_TITLE_BACKGOURND_BORDER_HEIGHT);
		
		//draw title background
		gameGround.setColor(Color.ORANGE);
		gameGround.fillRect(SConstant.SC_TITLE_BACKGROUND_BEGIN_XPOS, SConstant.SC_TITLE_BACKGROUND_BEGIN_YPOS, SConstant.SC_TITLE_BACKGROUND_WIDTH, SConstant.SC_TITLE_BACKGROUND_HEIGHT);
		
		//draw title information
		gameGround.setColor(Color.BLUE);
		gameGround.setFont(new Font(SConstant.SC_FONT_THEME, Font.BOLD, SConstant.SC_TITLE_FONT_SIZE));
		gameGround.drawString(SConstant.SC_GAME_TITLE, SConstant.SC_TITLE_BEGIN_XPOS, SConstant.SC_TITLE_BEGIN_YPOS);
		
		//draw background border
		gameGround.setColor(Color.YELLOW);
		gameGround.drawRect(SConstant.SC_GAMEBODY_BORDER_BEGIN_XPOS, SConstant.SC_GAMEBODY_BORDER_BEGIN_YPOS, SConstant.SC_GAMEBODY_BORDER_WIDTH, SConstant.SC_GAMEBODY_BORDER_WIDTH);
		
		//draw background 
		gameGround.setColor(Color.WHITE);
		gameGround.fillRect(SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS, SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS, SConstant.SC_GAMEBODY_BACKGROUND_WIDTH, SConstant.SC_GAMEBODY_BACKGROUND_HEIGHT);
		
		//draw game information
		snake = Snake.getInstance();
		//score
		gameGround.setColor(Color.WHITE);
		gameGround.setFont(new Font(SConstant.SC_FONT_THEME, Font.PLAIN, SConstant.SC_DEFAULT_FONT_SIZE));
		gameGround.drawString("Scores: " + snake.getScore(), SConstant.SC_SCORE_BEGIN_XPOS, SConstant.SC_SCORE_BEGIN_YPOS);
		
		//length
		gameGround.setColor(Color.WHITE);
		gameGround.setFont(new Font(SConstant.SC_FONT_THEME, Font.PLAIN, SConstant.SC_DEFAULT_FONT_SIZE));
		gameGround.drawString("Length: " + snake.getLength(), SConstant.SC_LENGTH_BEGIN_XPOS, SConstant.SC_LENGTH_BEGIN_YPOS);
		
	}
}
