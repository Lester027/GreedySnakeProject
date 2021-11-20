package com.cs3343_Group16.greedySnake.action;

import java.util.ArrayList;
import java.util.LinkedList;

import com.cs3343_Group16.greedySnake.model.Bean;
import com.cs3343_Group16.greedySnake.model.MapNode;
import com.cs3343_Group16.greedySnake.model.details.AISnake;
import com.cs3343_Group16.greedySnake.system.SConstant;
import com.cs3346_Group16.greedySnake.service.impl.FindPathLongest;
import com.cs3346_Group16.greedySnake.service.impl.FindPathShortest;
import com.cs3346_Group16.greedySnake.service.impl.SnakeMoveDown;
import com.cs3346_Group16.greedySnake.service.impl.SnakeMoveLeft;
import com.cs3346_Group16.greedySnake.service.impl.SnakeMoveRight;
import com.cs3346_Group16.greedySnake.service.impl.SnakeMoveUp;

public class SnakeSelfAutoMove {
	private static String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];

	private static void initVirtualState() {
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = SConstant.SC_MAP_RECORD_NULL;
			}
		}
	}

	private static void updateVirtualMapStatement(ArrayList<ArrayList<Integer>> virtualSnake, int length) {
		// virtual snake x axis index, virtual snake y axis index
		int vsxai, vsyai;
		for (int i = 0; i < length; i++) {
			vsxai = (virtualSnake.get(i).get(SConstant.SC_COORDINATE_XPOS_KEY)
					- SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
			vsyai = (virtualSnake.get(i).get(SConstant.SC_COORDINATE_YPOS_KEY)
					- SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
			virtualMapState[vsxai][vsyai] = SConstant.SC_MAP_RECORD_SNAKE;
		}
	}

	public static String thinkAndMove(AISnake snake, Bean bean, String oldDirection) {
		LinkedList<MapNode> shortestPath, longestPath;
		int headXPos = snake.getHeadXPos();
		int headYPos = snake.getHeadYPos();
		int beanXPos = bean.getBeanXPos();
		int beanYPos = bean.getBeanYPos();
		int prevTailXPos = -1;
		int prevTailYPos = -1;

		initVirtualState();
		updateVirtualMapStatement(snake.clone(), snake.getLength());
		shortestPath = new FindPathShortest().search(virtualMapState, headXPos, headYPos, bean.getBeanXPos(),
				bean.getBeanYPos());

		if (shortestPath.size() > 0) {
			ArrayList<ArrayList<Integer>> dummySnake = snake.clone();
			String dummyDirection = snake.getDirection();
			int dummyLength = snake.getLength();

			for (int i = 0; i < shortestPath.size(); i++) {
				dummyDirection = shortestPath.get(i).getDirection();
				prevTailXPos = dummySnake.get(dummyLength - 1).get(SConstant.SC_COORDINATE_XPOS_KEY);
				prevTailYPos = dummySnake.get(dummyLength - 1).get(SConstant.SC_COORDINATE_YPOS_KEY);
				switch (dummyDirection) {
				case SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG:
					new SnakeMoveRight().dummyMove(dummySnake, dummyLength);
					break;
				case SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG:
					new SnakeMoveDown().dummyMove(dummySnake, dummyLength);
					break;
				case SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG:
					new SnakeMoveLeft().dummyMove(dummySnake, dummyLength);
					break;
				case SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG:
					new SnakeMoveUp().dummyMove(dummySnake, dummyLength);
					break;
				}

			}

			initVirtualState();
			updateVirtualMapStatement(dummySnake, dummyLength);

			headXPos = dummySnake.get(0).get(SConstant.SC_COORDINATE_XPOS_KEY);
			headYPos = dummySnake.get(0).get(SConstant.SC_COORDINATE_YPOS_KEY);

			longestPath = new FindPathLongest().search(virtualMapState, headXPos, headYPos, prevTailXPos, prevTailYPos);

			if (longestPath.size() > 0 || dummySnake.size() <= 3) {
				MapNode result = shortestPath.remove();
				return result.getDirection();
			}
		}

		initVirtualState();
		updateVirtualMapStatement(snake.clone(), snake.getLength());
		headXPos = snake.getHeadXPos();
		headYPos = snake.getHeadYPos();
		prevTailXPos = snake.getXCoordinate(snake.getLength() - 1);
		prevTailYPos = snake.getYCoordinate(snake.getLength() - 1);
		longestPath = new FindPathLongest().search(virtualMapState, headXPos, headYPos, prevTailXPos, prevTailYPos);

		if (longestPath.size() > 0) {
			MapNode result = longestPath.remove();
			return result.getDirection();
		}

		longestPath = new FindPathLongest().search(virtualMapState, headXPos, headYPos, beanXPos, beanYPos);
		if (longestPath.size() > 0) {
			MapNode result = longestPath.remove();
			return result.getDirection();
		}

		int headXIdx = (headXPos - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		int headYIdx = (headYPos - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		
		//last resorts
		if (Math.abs(snake.getHeadXPos() - bean.getBeanXPos()) > Math.abs(snake.getHeadYPos() - bean.getBeanYPos())) {
			if (snake.getHeadXPos() < bean.getBeanXPos()) {
				if (!SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG.equals(snake.getDirection())) {
					if (!SConstant.SC_MAP_RECORD_SNAKE.equals(virtualMapState[headXIdx - 1 >= 0 ? headXIdx - 1
							: SConstant.SC_MAP_X_AXIS_CAPACITY - 1][headYIdx])) {
						return SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG;
					}
				} else {
					if (snake.getHeadYPos() < bean.getBeanYPos()) {
						if (!SConstant.SC_MAP_RECORD_SNAKE
								.equals(virtualMapState[headXIdx][headYIdx - 1 >= 0 ? headYIdx - 1
										: SConstant.SC_MAP_Y_AXIS_CAPACITY - 1])) {
							return SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG;
						}
					} else {
						if (!SConstant.SC_MAP_RECORD_SNAKE.equals(
								virtualMapState[headXIdx][headYIdx + 1 < SConstant.SC_MAP_Y_AXIS_CAPACITY ? headYIdx + 1
										: 0])) {
							return SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG;
						}
					}
				}
			} else if (snake.getHeadYPos() > bean.getBeanXPos()) {
				if (!SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG.equals(snake.getDirection())) {
					if (!SConstant.SC_MAP_RECORD_SNAKE
							.equals(virtualMapState[headXIdx + 1 < SConstant.SC_MAP_X_AXIS_CAPACITY ? headXIdx + 1
									: 0][headYIdx])) {
						return SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG;
					}
				} else {
					if (snake.getHeadYPos() < bean.getBeanYPos()) {
						if (!SConstant.SC_MAP_RECORD_SNAKE
								.equals(virtualMapState[headXIdx][headYIdx - 1 >= 0 ? headYIdx - 1
										: SConstant.SC_MAP_Y_AXIS_CAPACITY - 1])) {
							return SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG;
						}
					} else {
						if (!SConstant.SC_MAP_RECORD_SNAKE.equals(
								virtualMapState[headXIdx][headYIdx + 1 < SConstant.SC_MAP_Y_AXIS_CAPACITY ? headYIdx + 1
										: 0])) {
							return SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG;
						}
					}
				}
			}
		} else {
			if (snake.getHeadYPos() < bean.getBeanYPos()) {
				if (!SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG.equals(snake.getDirection())) {
					if (!SConstant.SC_MAP_RECORD_SNAKE.equals(virtualMapState[headXIdx][headYIdx - 1 >= 0 ? headYIdx - 1
							: SConstant.SC_MAP_Y_AXIS_CAPACITY - 1])) {
						return SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG;
					}
				} else {
					if (snake.getHeadXPos() < bean.getBeanXPos()) {
						if (!SConstant.SC_MAP_RECORD_SNAKE.equals(virtualMapState[headXIdx - 1 >= 0 ? headXIdx - 1
								: SConstant.SC_MAP_X_AXIS_CAPACITY - 1][headYIdx])) {
							return SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG;
						}
					} else {
						if (!SConstant.SC_MAP_RECORD_SNAKE
								.equals(virtualMapState[headXIdx + 1 < SConstant.SC_MAP_X_AXIS_CAPACITY ? headXIdx + 1
										: 0][headYIdx])) {
							return SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG;
						}
					}
				}
			} else if (snake.getHeadYPos() > bean.getBeanYPos()) {
				if (!SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG.equals(snake.getDirection())) {
					if (!SConstant.SC_MAP_RECORD_SNAKE.equals(
							virtualMapState[headXIdx][headYIdx + 1 < SConstant.SC_MAP_Y_AXIS_CAPACITY ? headYIdx + 1
									: 0])) {
						return SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG;
					}
				} else {
					if (snake.getHeadXPos() < bean.getBeanXPos()) {
						if (!SConstant.SC_MAP_RECORD_SNAKE.equals(virtualMapState[headXIdx - 1 >= 0 ? headXIdx - 1
								: SConstant.SC_MAP_X_AXIS_CAPACITY - 1][headYIdx])) {
							return SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG;
						}
					} else {
						if (!SConstant.SC_MAP_RECORD_SNAKE
								.equals(virtualMapState[headXIdx + 1 < SConstant.SC_MAP_X_AXIS_CAPACITY ? headXIdx + 1
										: 0][headYIdx])) {
							return SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG;
						}
					}
				}
			}
		}

		if (headXIdx > 1 && !SConstant.SC_MAP_RECORD_SNAKE.equals(
				virtualMapState[headXIdx - 1 >= 0 ? headXIdx - 1 : SConstant.SC_MAP_X_AXIS_CAPACITY - 1][headYIdx])
				&& !SConstant.SC_MAP_RECORD_SNAKE.equals(virtualMapState[headXIdx - 2 >= 0 ? headXIdx - 2
						: SConstant.SC_MAP_X_AXIS_CAPACITY - 1][headYIdx])) {
			return SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG;
		} else if (headXIdx < SConstant.SC_MAP_X_AXIS_CAPACITY - 1
				&& !SConstant.SC_MAP_RECORD_SNAKE.equals(
						virtualMapState[headXIdx + 1 < SConstant.SC_MAP_X_AXIS_CAPACITY ? headXIdx + 1 : 0][headYIdx])
				&& !SConstant.SC_MAP_RECORD_SNAKE
						.equals(virtualMapState[headXIdx + 2 < SConstant.SC_MAP_X_AXIS_CAPACITY ? headXIdx + 1
								: 0][headYIdx])) {
			return SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG;
		} else if (headYIdx > 1
				&& !SConstant.SC_MAP_RECORD_SNAKE.equals(virtualMapState[headXIdx][headYIdx - 1 >= 0 ? headYIdx - 1
						: SConstant.SC_MAP_Y_AXIS_CAPACITY - 1])
				&& !SConstant.SC_MAP_RECORD_SNAKE.equals(virtualMapState[headXIdx][headYIdx - 2 >= 0 ? headYIdx - 2
						: SConstant.SC_MAP_Y_AXIS_CAPACITY - 1])) {
			return SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG;
		} else if (headYIdx < SConstant.SC_MAP_Y_AXIS_CAPACITY - 2
				&& !SConstant.SC_MAP_RECORD_SNAKE.equals(
						virtualMapState[headXIdx][headYIdx + 1 < SConstant.SC_MAP_Y_AXIS_CAPACITY ? headYIdx + 1 : 0])
				&& !SConstant.SC_MAP_RECORD_SNAKE
						.equals(virtualMapState[headXIdx][headYIdx + 2 < SConstant.SC_MAP_Y_AXIS_CAPACITY ? headYIdx + 2
								: 0])) {
			return SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG;
		}

		return oldDirection;
	}

}
