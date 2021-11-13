package com.cs3346_Group16.greedySnake.service.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.cs3343_Group16.greedySnake.model.Game;
import com.cs3343_Group16.greedySnake.service.Display;
import com.cs3343_Group16.greedySnake.system.SConstant;

public class DisplayGameOver implements Display {

	@Override
	public void display(Graphics graphic) {
		gameOver(graphic);
		gameRestartAssist(graphic);
		gameStartAssist2(graphic);
	}
	

	public void gameOver(Graphics gameGraphic) {
		gameGraphic.setColor(Color.BLACK);
		gameGraphic.setFont(new Font(SConstant.SC_FONT_THEME, Font.BOLD, SConstant.SC_GAME_HINT_FONT_SIZE));
		gameGraphic.drawString(SConstant.SC_GAME_HINT_GAME_OVER, SConstant.SC_HINT_GAME_OVER_BEGIN_XPOS, SConstant.SC_HINT_GAME_OVER_BEGIN_YPOS);
	}
	
	public void gameRestartAssist(Graphics gameGraphic) {
		gameGraphic.setColor(Color.BLACK);
		gameGraphic.setFont(new Font(SConstant.SC_FONT_THEME, Font.BOLD, SConstant.SC_GAME_ASSIST_HINT_FONT_SIZE));
		gameGraphic.drawString(SConstant.SC_GAME_HINT_RESTART_ASSIST, SConstant.SC_HINT_GAME_RESTART_ASSIST_BEGIN_XPOS, SConstant.SC_HINT_GAME_RESTART_ASSIST_BEGIN_YPOS);
	}
	
	public void gameStartAssist2(Graphics gameGraphic) {
		gameGraphic.setColor(Color.BLACK);
		gameGraphic.setFont(new Font(SConstant.SC_FONT_THEME, Font.BOLD, SConstant.SC_GAME_ASSIST_HINT_FONT_SIZE));
		gameGraphic.drawString(SConstant.SC_GAME_HINT_START_ASSIST_2, SConstant.SC_HINT_GAME_START_ASSIST_2_BEGIN_XPOS, SConstant.SC_HINT_GAME_START_ASSIST_2_BEGIN_YPOS);
	}
}
