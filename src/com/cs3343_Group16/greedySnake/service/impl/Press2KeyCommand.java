package com.cs3343_Group16.greedySnake.service.impl;

import com.cs3343_Group16.greedySnake.model.Game;
import com.cs3343_Group16.greedySnake.service.KeyCommand;
import com.cs3343_Group16.greedySnake.system.SConstant;

public class Press2KeyCommand implements KeyCommand{
	
	private static Press2KeyCommand instance=new Press2KeyCommand();
	@Override
	public void execute(Game game) {
		game.setMode(SConstant.SC_GAME_MODE_AI);
	}

	public static Press2KeyCommand getInstance() {
		return instance;
	}


}
