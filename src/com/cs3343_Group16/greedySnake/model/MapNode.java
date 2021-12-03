package com.cs3343_Group16.greedySnake.model;

import java.util.Comparator;

import com.cs3343_Group16.greedySnake.system.SConstant;

public class MapNode {
	private int xPos;
	private int yPos;
	private int xIdx;
	private int yIdx;
	private int distance;
	private int preScore;
	private String direction;

	public static Comparator<MapNode> NodeComparator() {
		return new Comparator<MapNode>() {
			@Override
			public int compare(MapNode sn1, MapNode sn2) {
				if (sn1.preScore != sn2.preScore) {
					return sn1.preScore - sn2.preScore;
				} else {
					return sn2.distance - sn1.distance;
				}
			}
		};
	}

	public MapNode() {
		this.xPos = SConstant.SC_SNAKE_NODE_DEFAULT_INIT_VALUE;
		this.yPos = SConstant.SC_SNAKE_NODE_DEFAULT_INIT_VALUE;
		this.distance = SConstant.SC_SNAKE_NODE_DEFAULT_INIT_VALUE;
		this.direction = SConstant.SC_SNAKE_MOVE_DIRECTION_DEATH_FLAG;
		this.preScore = SConstant.SC_SNAKE_NODE_DEFAULT_SCORE_VALUE;
		this.xIdx = (this.xPos - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		this.yIdx = (this.yPos - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
	}

	public MapNode(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.distance = SConstant.SC_SNAKE_NODE_DEFAULT_INIT_VALUE;
		this.direction = SConstant.SC_SNAKE_MOVE_DIRECTION_DEATH_FLAG;
		this.preScore = SConstant.SC_SNAKE_NODE_DEFAULT_SCORE_VALUE;
		this.xIdx = (this.xPos - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		this.yIdx = (this.yPos - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
	}

	public MapNode(int xPos, int yPos, String direction) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.distance = SConstant.SC_SNAKE_NODE_DEFAULT_INIT_VALUE;
		this.direction = direction;
		this.preScore = SConstant.SC_SNAKE_NODE_DEFAULT_SCORE_VALUE;
		this.xIdx = (this.xPos - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		this.yIdx = (this.yPos - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
	}

	public MapNode(int xPos, int yPos, String direction, int distance, int score) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.distance = distance;
		this.direction = direction;
		this.preScore = score;
		this.xIdx = (this.xPos - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		this.yIdx = (this.yPos - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
	}

	public MapNode(int xPos, int yPos, String direction, int distance, MapNode goal) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.distance = distance;
		this.direction = direction;
		this.preScore = distance + Math.abs(goal.xPos - xPos) + Math.abs(goal.yPos - yPos);
		this.xIdx = (this.xPos - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		this.yIdx = (this.yPos - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
	}

	public static MapNode nextNode(MapNode current, String direction, MapNode destination) {
		if (SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG.equals(direction)) {
			if (current.xPos + SConstant.SC_DEFAULT_NODE_SIZE > SConstant.SC_SNAKE_AVAIL_MAX_XPOS) {
				return new MapNode(SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS, current.yPos, direction,
						current.distance + 1, destination);
			} else {
				return new MapNode(current.xPos + SConstant.SC_DEFAULT_NODE_SIZE, current.yPos, direction,
						current.distance + 1, destination);
			}
		} else if (SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG.equals(direction)) {
			if (current.yPos + SConstant.SC_DEFAULT_NODE_SIZE > SConstant.SC_SNAKE_AVAIL_MAX_YPOS) {
				return new MapNode(current.xPos, SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS, direction,
						current.distance + 1, destination);
			} else {
				return new MapNode(current.xPos, current.yPos + SConstant.SC_DEFAULT_NODE_SIZE, direction,
						current.distance + 1, destination);
			}
		} else if (SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG.equals(direction)) {
			if (current.xPos - SConstant.SC_DEFAULT_NODE_SIZE < SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) {
				return new MapNode(SConstant.SC_SNAKE_AVAIL_MAX_XPOS, current.yPos, direction, current.distance + 1,
						destination);
			} else {
				return new MapNode(current.xPos - SConstant.SC_DEFAULT_NODE_SIZE, current.yPos, direction,
						current.distance + 1, destination);
			}
		} else if (SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG.equals(direction)) {
			if (current.yPos - SConstant.SC_DEFAULT_NODE_SIZE < SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) {
				return new MapNode(current.xPos, SConstant.SC_SNAKE_AVAIL_MAX_YPOS, direction, current.distance + 1,
						destination);
			} else {
				return new MapNode(current.xPos, current.yPos - SConstant.SC_DEFAULT_NODE_SIZE, direction,
						current.distance + 1, destination);
			}
		}
		return null;
	}

	public MapNode nextNode(String currentDirection) {
		if (SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG.equals(currentDirection)) {
			if (this.xPos + SConstant.SC_DEFAULT_NODE_SIZE > SConstant.SC_SNAKE_AVAIL_MAX_XPOS) {
				return new MapNode(SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS, this.yPos, currentDirection);
			} else {
				return new MapNode(this.xPos + SConstant.SC_DEFAULT_NODE_SIZE, this.yPos, currentDirection);
			}
		} else if (SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG.equals(currentDirection)) {
			if (this.yPos + SConstant.SC_DEFAULT_NODE_SIZE > SConstant.SC_SNAKE_AVAIL_MAX_YPOS) {
				return new MapNode(this.xPos, SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS, currentDirection);
			} else {
				return new MapNode(this.xPos, this.yPos + SConstant.SC_DEFAULT_NODE_SIZE, currentDirection);
			}
		} else if (SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG.equals(currentDirection)) {
			if (this.xPos - SConstant.SC_DEFAULT_NODE_SIZE < SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) {
				return new MapNode(SConstant.SC_SNAKE_AVAIL_MAX_XPOS, this.yPos, currentDirection);
			} else {
				return new MapNode(this.xPos - SConstant.SC_DEFAULT_NODE_SIZE, this.yPos, currentDirection);
			}
		} else if (SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG.equals(currentDirection)) {
			if (this.yPos - SConstant.SC_DEFAULT_NODE_SIZE < SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) {
				return new MapNode(this.xPos, SConstant.SC_SNAKE_AVAIL_MAX_YPOS, currentDirection);
			} else {
				return new MapNode(this.xPos, this.yPos - SConstant.SC_DEFAULT_NODE_SIZE, currentDirection);
			}
		}
		return null;
	}

	public MapNode prevNode(String currentDirection) {
		if (SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG.equals(currentDirection)) {
			if (this.xPos - SConstant.SC_DEFAULT_NODE_SIZE < SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) {
				return new MapNode(SConstant.SC_SNAKE_AVAIL_MAX_XPOS, this.yPos, currentDirection);
			} else {
				return new MapNode(this.xPos - SConstant.SC_DEFAULT_NODE_SIZE, this.yPos, currentDirection);
			}
		} else if (SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG.equals(currentDirection)) {
			if (this.yPos - SConstant.SC_DEFAULT_NODE_SIZE < SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) {
				return new MapNode(this.xPos, SConstant.SC_SNAKE_AVAIL_MAX_YPOS, currentDirection);
			} else {
				return new MapNode(this.xPos, this.yPos - SConstant.SC_DEFAULT_NODE_SIZE, currentDirection);
			}
		} else if (SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG.equals(currentDirection)) {
			if (this.xPos + SConstant.SC_DEFAULT_NODE_SIZE > SConstant.SC_SNAKE_AVAIL_MAX_XPOS) {
				return new MapNode(SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS, this.yPos, currentDirection);
			} else {
				return new MapNode(this.xPos + SConstant.SC_DEFAULT_NODE_SIZE, this.yPos, currentDirection);
			}
		} else if (SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG.equals(currentDirection)) {
			if (this.yPos + SConstant.SC_DEFAULT_NODE_SIZE > SConstant.SC_SNAKE_AVAIL_MAX_YPOS) {
				return new MapNode(this.xPos, SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS, currentDirection);
			} else {
				return new MapNode(this.xPos, this.yPos + SConstant.SC_DEFAULT_NODE_SIZE, currentDirection);
			}
		}
		return null;
	}

	public MapNode leftward() {
		if (SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG.equals(this.direction)) {
			return this.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG);
		} else if (SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG.equals(this.direction)) {
			return this.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
		} else if (SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG.equals(this.direction)) {
			return this.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG);
		} else if (SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG.equals(this.direction)) {
			return this.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG);
		}
		return null;
	}

	public MapNode rightward() {
		if (SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG.equals(this.direction)) {
			return this.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG);
		} else if (SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG.equals(this.direction)) {
			return this.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG);
		} else if (SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG.equals(this.direction)) {
			return this.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG);
		} else if (SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG.equals(this.direction)) {
			return this.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
		}
		return null;
	}

	public static String OppositeDirection(String currentDirection) {
		if (SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG.equals(currentDirection)) {
			return SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG;
		} else if (SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG.equals(currentDirection)) {
			return SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG;
		} else if (SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG.equals(currentDirection)) {
			return SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG;
		} else if (SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG.equals(currentDirection)) {
			return SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG;
		}
		return null;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getxIdx() {
		return xIdx;
	}

	public void setxIdx(int xIdx) {
		this.xIdx = xIdx;
	}

	public int getyIdx() {
		return yIdx;
	}

	public void setyIdx(int yIdx) {
		this.yIdx = yIdx;
	}

	public int getLength() {
		return distance;
	}

	public void setLength(int length) {
		this.distance = length;
	}

	public int getForeseeScore() {
		return preScore;
	}

	public void setForeseeScore(int foreseeScore) {
		this.preScore = foreseeScore;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

}
