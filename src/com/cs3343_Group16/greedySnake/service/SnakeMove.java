package com.cs3343_Group16.greedySnake.service;

import java.util.ArrayList;

import com.cs3343_Group16.greedySnake.model.Snake;

public interface SnakeMove {
	public void move(Snake snake);
	
	public ArrayList<ArrayList<Integer>> dummyMove(ArrayList<ArrayList<Integer>> snake, int length);
}
