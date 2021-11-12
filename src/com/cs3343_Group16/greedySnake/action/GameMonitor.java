package com.cs3343_Group16.greedySnake.action;

import java.awt.Graphics;

import com.cs3343_Group16.greedySnake.model.Game;
import com.cs3346_Group16.greedySnake.service.impl.DisplayGameOver;
import com.cs3346_Group16.greedySnake.service.impl.DisplayGameStart;

public class GameMonitor {
	
	public static boolean Monitor(Game game, Graphics graphic) {
		GameStartDetection(game, graphic);
		ScoreDetection(game);
		return DeathDetection(game, graphic);
	}
	
	public static void GameStartDetection(Game game, Graphics graphic) {
		if(game.getSnake().getMove() == -1) {
			new DisplayGameStart().display(graphic);
		}
	}
	
	public static boolean DeathDetection(Game game, Graphics graphic) {
		if(game.getSnake().selfDeathDetection()) {
			new DisplayGameOver().display(graphic);
			return true;
		}
		return false;
	}
	
	public static void ScoreDetection(Game game) {
		if(game.getBean().getBeanXPos() == game.getSnake().getHeadXPos() 
				&& game.getBean().getBeanYpos() == game.getSnake().getHeadYpos()) {
			game.getSnake().updateScore();
			game.getSnake().updateLength();
			game.getBean().refreshPos();
		}
	}
}
