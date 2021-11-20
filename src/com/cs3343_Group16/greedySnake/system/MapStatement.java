package com.cs3343_Group16.greedySnake.system;

import com.cs3343_Group16.greedySnake.model.Bean;
import com.cs3343_Group16.greedySnake.model.Snake;
import com.cs3343_Group16.greedySnake.model.details.AISnake;
import com.cs3343_Group16.greedySnake.model.details.DeathBean;
import com.cs3343_Group16.greedySnake.model.details.NormalBean;
import com.cs3343_Group16.greedySnake.model.details.PlayerSnake;
import com.cs3343_Group16.greedySnake.model.details.ScoreBean;

public class MapStatement {
	private static MapStatement instance = null;
	private String[][] records;

	private MapStatement() {
		records = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		this.initRecord();
	}

	public static MapStatement getInstance() {
		if (instance == null) {
			instance = new MapStatement();
		}
		return instance;
	}

	public void initRecord() {
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				records[i][j] = SConstant.SC_MAP_RECORD_NULL;
			}
		}
	}

	public void updateStatus(Object obj, int xPos, int yPos) {
		int xIdx = (xPos - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		int yIdx = (yPos - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		if (obj.getClass() == Snake.class || obj.getClass() == PlayerSnake.class) {
			records[xIdx][yIdx] = SConstant.SC_MAP_RECORD_SNAKE;
		} else if (obj.getClass() == AISnake.class) {
			records[xIdx][yIdx] = SConstant.SC_MAP_RECORD_AI_SNAKE;
		} else if (obj.getClass() == Bean.class || obj.getClass() == NormalBean.class
				|| obj.getClass() == ScoreBean.class || obj.getClass() == DeathBean.class) {
			records[xIdx][yIdx] = SConstant.SC_MAP_RECORD_BEAN;
		}
	}

	public String[][] getRecords() {
		return records;
	}

	public void setRecords(String[][] records) {
		this.records = records;
	}

}
