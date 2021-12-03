package com.cs3343_Group16.greedySnake.service.impl;

import com.cs3343_Group16.greedySnake.model.Game;
import com.cs3343_Group16.greedySnake.service.KeyCommand;
import com.cs3343_Group16.greedySnake.service.UpdateDirection;

public class PressUpKeyCommand implements KeyCommand{

	private static PressUpKeyCommand instance=new PressUpKeyCommand();
	private UpdateDirection update_direc= new UpdateDirectionUp();
	
	public static PressUpKeyCommand getInstance() {
		return instance;
	}

	@Override
	public void execute(Game game) {
		update_direc.update(game.getSnake());
	}

}