package com.cs3343_Group16.greedySnake.service.impl;

import com.cs3343_Group16.greedySnake.model.Game;
import com.cs3343_Group16.greedySnake.service.KeyCommand;
import com.cs3343_Group16.greedySnake.service.UpdateDirection;

public class PressDownKeyCommand implements KeyCommand{

	private static PressDownKeyCommand instance=new PressDownKeyCommand();
	private UpdateDirection update_direc= new UpdateDirectionDown();
	
	public static PressDownKeyCommand getInstance() {
		return instance;
	}

	@Override
	public void execute(Game game) {
		update_direc.update(game.getSnake());
	}

}
