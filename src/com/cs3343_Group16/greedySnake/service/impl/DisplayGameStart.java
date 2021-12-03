package com.cs3343_Group16.greedySnake.service.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.cs3343_Group16.greedySnake.service.Display;
import com.cs3343_Group16.greedySnake.system.SConstant;

public class DisplayGameStart implements Display {

	@Override
	public void display(Graphics graphic) {
		gameStart(graphic);
		gameStartAssist1(graphic);
	}
	

	public void gameStart(Graphics gameGraphic) {
		gameGraphic.setColor(Color.BLACK);
		gameGraphic.setFont(new Font(SConstant.SC_FONT_THEME, Font.BOLD, SConstant.SC_GAME_HINT_FONT_SIZE));
		gameGraphic.drawString(SConstant.SC_GAME_HINT_GAME_START, SConstant.SC_HINT_GAME_START_BEGIN_XPOS, SConstant.SC_HINT_GAME_START_BEGIN_YPOS);
	}
	
	public void gameStartAssist1(Graphics gameGraphic) {
		gameGraphic.setColor(Color.BLACK);
		gameGraphic.setFont(new Font(SConstant.SC_FONT_THEME, Font.BOLD, SConstant.SC_GAME_ASSIST_HINT_FONT_SIZE));
		gameGraphic.drawString(SConstant.SC_GAME_HINT_START_ASSIST_1, SConstant.SC_HINT_GAME_START_ASSIST_1_BEGIN_XPOS, SConstant.SC_HINT_GAME_START_ASSIST_1_BEGIN_YPOS);
	}
}
