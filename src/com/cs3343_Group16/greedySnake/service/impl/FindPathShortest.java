package com.cs3343_Group16.greedySnake.service.impl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import com.cs3343_Group16.greedySnake.model.MapNode;
import com.cs3343_Group16.greedySnake.service.FindPath;
import com.cs3343_Group16.greedySnake.system.SConstant;
import com.cs3343_Group16.greedySnake.util.StatementUtils;

public class FindPathShortest implements FindPath {
	private String[][] mapState;
	private String[][] preState;
	private MapNode[][] trace;
	PriorityQueue<MapNode> queue;
	
	public FindPathShortest() {
		this.mapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		this.preState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		this.trace = new MapNode[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		this.queue = new PriorityQueue<MapNode>(MapNode.NodeComparator());
	}

	@Override
	public LinkedList<MapNode> search(String[][] state, int departmentXPos, int departmentYPos, int destinationXPos,
			int destinationYPos) {
		this.mapState = StatementUtils.copyState(state);
		preState = StatementUtils.copyState(mapState);

		if (departmentXPos == destinationXPos && departmentYPos == destinationYPos) {
			return new LinkedList<MapNode>();
		}

		MapNode department = new MapNode(departmentXPos, departmentYPos);
		MapNode destination = new MapNode(destinationXPos, destinationYPos);

		searchAroundEmptyCell(department, SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG, destination);
		searchAroundEmptyCell(department, SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG, destination);
		searchAroundEmptyCell(department, SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG, destination);
		searchAroundEmptyCell(department, SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG, destination);

		MapNode temp;
		while (queue.size() > 0) {
			temp = queue.remove();
			if (temp.getxPos() == destinationXPos && temp.getyPos() == destinationYPos) {
				LinkedList<MapNode> result = new LinkedList<MapNode>();
				while (temp.getxPos() != departmentXPos || temp.getyPos() != departmentYPos) {
					result.add(temp);
					temp = trace[temp.getxIdx()][temp.getyIdx()];
				}
				Collections.reverse(result);
				return result;
			}
			if (!SConstant.SC_MAP_RECORD_NULL.equals(mapState[temp.getxIdx()][temp.getyIdx()])) {
				continue;
			}

			SearchAroundNonPreservedCell(temp, SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG, destination);
			SearchAroundNonPreservedCell(temp, SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG, destination);
			SearchAroundNonPreservedCell(temp, SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG, destination);
			SearchAroundNonPreservedCell(temp, SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG, destination);
		}

		return new LinkedList<MapNode>();
	}

	private void searchAroundEmptyCell(MapNode node, String direction, MapNode end) {
		MapNode trial = MapNode.nextNode(node, direction, end);
		if (SConstant.SC_MAP_RECORD_NULL.equals(mapState[trial.getxIdx()][trial.getyIdx()])) {
			queue.add(trial);
			preState[trial.getxIdx()][trial.getyIdx()] = SConstant.SC_MAP_RECORD_PRESERVED;
			trace[trial.getxIdx()][trial.getyIdx()] = node;
		}
		
	}

	private void SearchAroundNonPreservedCell(MapNode node, String direction, MapNode end) {
		MapNode trial = MapNode.nextNode(node, direction, end);
		if (!SConstant.SC_MAP_RECORD_PRESERVED.equals(preState[trial.getxIdx()][trial.getyIdx()])) {
			queue.add(trial);
			preState[trial.getxIdx()][trial.getyIdx()] = SConstant.SC_MAP_RECORD_PRESERVED;
			trace[trial.getxIdx()][trial.getyIdx()] = node;
		}
	}

}
