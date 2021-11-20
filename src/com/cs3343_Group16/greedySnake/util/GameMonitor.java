package com.cs3343_Group16.greedySnake.util;

import java.awt.Graphics;

import com.cs3343_Group16.greedySnake.model.Game;
import com.cs3343_Group16.greedySnake.system.SConstant;
import com.cs3346_Group16.greedySnake.service.impl.DisplayGameModeChoose;
import com.cs3346_Group16.greedySnake.service.impl.DisplayGameOver;
import com.cs3346_Group16.greedySnake.service.impl.DisplayGameStart;

public class GameMonitor {
	
	public static boolean Monitor(Game game, Graphics graphic) {
		if(SConstant.SC_GAME_MODE_DEFAULT.equals(game.getMode())) {
			new DisplayGameModeChoose().display(graphic);
		}else {
			if(SConstant.SC_GAME_MODE_PlAYER.equals(game.getMode())) {
				GameStartDetection(game, graphic);
			}
			ScoreDetection(game);
			return DeathDetection(game, graphic);
		}
		return false;
	}
	
	public static void GameStartDetection(Game game, Graphics graphic) {
		if(game.getSnake().getMove() == -1) {
			new DisplayGameStart().display(graphic);
		}
	}
	
	public static boolean DeathDetection(Game game, Graphics graphic) {
		if(game.getSnake().selfDeathDetection()) {
			new DisplayGameOver().display(graphic);
			game.reinit();
			return true;
		}
		return false;
	}
	
	public static void ScoreDetection(Game game) {
		if(game.getBean().getBeanXPos() == game.getSnake().getHeadXPos() 
				&& game.getBean().getBeanYPos() == game.getSnake().getHeadYPos()) {
			game.getSnake().updateScore(game.getBean().getBeanScore());
			game.getSnake().updateLength();
			game.getBean().refreshPos();
		}
	}
	
}
