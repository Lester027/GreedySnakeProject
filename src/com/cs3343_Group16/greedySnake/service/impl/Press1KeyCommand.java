package com.cs3343_Group16.greedySnake.service.impl;

import com.cs3343_Group16.greedySnake.model.Game;
import com.cs3343_Group16.greedySnake.service.KeyCommand;
import com.cs3343_Group16.greedySnake.system.SConstant;

public class Press1KeyCommand implements KeyCommand{
	
	private static Press1KeyCommand instance=new Press1KeyCommand();
	@Override
	public void execute(Game game) {
		game.setMode(SConstant.SC_GAME_MODE_PlAYER);
	}

	public static Press1KeyCommand getInstance() {
		return instance;
	}

}
