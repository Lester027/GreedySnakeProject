package com.cs3343_Group16.greedySnake.service.impl;

import java.util.LinkedList;

import com.cs3343_Group16.greedySnake.model.MapNode;
import com.cs3343_Group16.greedySnake.service.FindPath;
import com.cs3343_Group16.greedySnake.system.SConstant;
import com.cs3343_Group16.greedySnake.util.StatementUtils;

public class FindPathLongest implements FindPath {
	private String[][] preState;

	@Override
	public LinkedList<MapNode> search(String[][] state, int departmentXPos, int departmentYPos, int destinationXPos,
			int destinationYPos) {
		preState = StatementUtils.copyState(state);

		LinkedList<MapNode> result = new FindPathShortest().search(state, departmentXPos, departmentYPos, destinationXPos, destinationYPos);

		if (result.size() == 0) {
			return result;
		}

		for (int i = 0; i < result.size(); i++) {
			preState[result.get(i).getxIdx()][result.get(i).getyIdx()] = SConstant.SC_MAP_RECORD_PRESERVED;
		}

		int i = 0;
		while (true) {
			if (i >= result.size()) {
				break;
			}

			MapNode trial = result.get(i);
			String direction = trial.getDirection();
			MapNode temp = trial.prevNode(direction);

			MapNode tempLeft = temp.leftward(), trialLeft = trial.leftward();
			if (SConstant.SC_MAP_RECORD_NULL.equals(preState[tempLeft.getxIdx()][tempLeft.getyIdx()])
					&& SConstant.SC_MAP_RECORD_NULL.equals(preState[trialLeft.getxIdx()][trialLeft.getyIdx()])) {
				preState[tempLeft.getxIdx()][tempLeft.getyIdx()] = SConstant.SC_MAP_RECORD_PRESERVED;
				preState[trialLeft.getxIdx()][trialLeft.getyIdx()] = SConstant.SC_MAP_RECORD_PRESERVED;
				result.add(i, tempLeft);
				trialLeft.setDirection(direction);
				result.add(i + 1, trialLeft);
				result.get(i + 2).setDirection(MapNode.OppositeDirection(tempLeft.getDirection()));
				continue;
			}

			MapNode tempRight = temp.rightward(), trialRight = trial.rightward();
			if (SConstant.SC_MAP_RECORD_NULL.equals(preState[tempRight.getxIdx()][tempRight.getyIdx()])
					&& SConstant.SC_MAP_RECORD_NULL.equals(preState[trialRight.getxIdx()][trialRight.getyIdx()])) {
				preState[tempRight.getxIdx()][tempRight.getyIdx()] = SConstant.SC_MAP_RECORD_PRESERVED;
				preState[trialRight.getxIdx()][trialRight.getyIdx()] = SConstant.SC_MAP_RECORD_PRESERVED;
				result.add(i, tempRight);
				trialRight.setDirection(direction);
				result.add(i + 1, trialRight);
				result.get(i + 2).setDirection(MapNode.OppositeDirection(tempRight.getDirection()));
			}

			i++;
		}

		return result;
	}

}
