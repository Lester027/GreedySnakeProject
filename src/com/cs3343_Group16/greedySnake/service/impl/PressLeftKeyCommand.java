package com.cs3343_Group16.greedySnake.service.impl;

import com.cs3343_Group16.greedySnake.model.Game;
import com.cs3343_Group16.greedySnake.service.KeyCommand;
import com.cs3343_Group16.greedySnake.service.UpdateDirection;

public class PressLeftKeyCommand implements KeyCommand{

	private static PressLeftKeyCommand instance=new PressLeftKeyCommand();
	private UpdateDirection update_direc= new UpdateDirectionLeft();
	
	public static PressLeftKeyCommand getInstance() {
		return instance;
	}

	@Override
	public void execute(Game game) {
		update_direc.update(game.getSnake());
	}

}