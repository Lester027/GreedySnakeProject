package com.cs3346_Group16.greedySnake.service.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.cs3343_Group16.greedySnake.service.Display;
import com.cs3343_Group16.greedySnake.system.SConstant;

public class DisplayGameModeChoose implements Display {

	@Override
	public void display(Graphics graphic) {
		gameChooseMode(graphic);
		gameModeChooseAssist1(graphic);
		gameModeChooseAssist2(graphic);
	}

	public void gameChooseMode(Graphics gameGraphic) {
		gameGraphic.setColor(Color.BLACK);
		gameGraphic.setFont(new Font(SConstant.SC_FONT_THEME, Font.BOLD, SConstant.SC_GAME_HINT_FONT_SIZE));
		gameGraphic.drawString(SConstant.SC_GAME_HINT_MODE_CHOOSE, SConstant.SC_HINT_GAME_MODE_CHOOSE_BEGIN_XPOS,
				SConstant.SC_HINT_GAME_MODE_CHOOSE_BEGIN_YPOS);
	}

	public void gameModeChooseAssist1(Graphics gameGraphic) {
		gameGraphic.setColor(Color.BLACK);
		gameGraphic.setFont(new Font(SConstant.SC_FONT_THEME, Font.BOLD, SConstant.SC_GAME_ASSIST_HINT_FONT_SIZE));
		gameGraphic.drawString(SConstant.SC_GAME_HINT_MODE_CHOOSE_ASSIST_1,
				SConstant.SC_HINT_GAME_MODE_CHOOSE_ASSIST_1_BEGIN_XPOS,
				SConstant.SC_HINT_GAME_MODE_CHOOSE_ASSIST_1_BEGIN_YPOS);
	}

	public void gameModeChooseAssist2(Graphics gameGraphic) {
		gameGraphic.setColor(Color.BLACK);
		gameGraphic.setFont(new Font(SConstant.SC_FONT_THEME, Font.BOLD, SConstant.SC_GAME_ASSIST_HINT_FONT_SIZE));
		gameGraphic.drawString(SConstant.SC_GAME_HINT_MODE_CHOOSE_ASSIST_2,
				SConstant.SC_HINT_GAME_MODE_CHOOSE_ASSIST_2_BEGIN_XPOS,
				SConstant.SC_HINT_GAME_MODE_CHOOSE_ASSIST_2_BEGIN_YPOS);
	}

}
