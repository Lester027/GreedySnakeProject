package com.cs3343_Group16.greedySnake.service;

import java.util.LinkedList;

import com.cs3343_Group16.greedySnake.model.MapNode;

public interface FindPath {
	public LinkedList<MapNode> search(String[][] state, int departmentXPos, int departmentYPos, int destinationXPos, int destinationYPos);
}
