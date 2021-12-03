package com.cs3343_Group16.greedySnake.service.impl;

import com.cs3343_Group16.greedySnake.model.Game;
import com.cs3343_Group16.greedySnake.service.KeyCommand;
import com.cs3343_Group16.greedySnake.service.UpdateDirection;

public class PressRightKeyCommand implements KeyCommand{

	private static PressRightKeyCommand instance=new PressRightKeyCommand();
	private UpdateDirection update_direc= new UpdateDirectionRight();
	
	public static PressRightKeyCommand getInstance() {
		return instance;
	}

	@Override
	public void execute(Game game) {
		update_direc.update(game.getSnake());
	}

}