package com.cs3343_Group16.greedySnake.action.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cs3343_Group16.greedySnake.action.SnakeSelfAutoMove;
import com.cs3343_Group16.greedySnake.model.Bean;
import com.cs3343_Group16.greedySnake.model.MapNode;
import com.cs3343_Group16.greedySnake.model.Snake;
import com.cs3343_Group16.greedySnake.model.details.AISnake;
import com.cs3343_Group16.greedySnake.model.details.NormalBean;
import com.cs3343_Group16.greedySnake.service.SnakeMove;
import com.cs3343_Group16.greedySnake.service.impl.FindPathLongest;
import com.cs3343_Group16.greedySnake.service.impl.FindPathShortest;
import com.cs3343_Group16.greedySnake.system.MapStatement;
import com.cs3343_Group16.greedySnake.system.SConstant;


class TestSnakeSelfAutoMove {

	@BeforeEach
	void setUp() throws Exception{
		AISnake.getInstance().initial();
		AISnake.getInstance().setDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
		MapStatement.getInstance().initRecord();
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		AISnake.getInstance().initial();
		AISnake.getInstance().setDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
		MapStatement.getInstance().initRecord();
	}
	
	@Test
	void test_setSnakeMove_Right() {
		SnakeSelfAutoMove.setSnakeMove("Rightward");
		String result = AISnake.getInstance().getDirection();
		assertEquals(result, "Rightward");
	}
	
	@Test
	void test_setSnakeMove_Left() {
		SnakeSelfAutoMove.setSnakeMove("Leftward");
		String result = AISnake.getInstance().getDirection();
		assertEquals(result, "Rightward");
	}
	
	@Test
	void test_setSnakeMove_Up() {
		SnakeSelfAutoMove.setSnakeMove("Upward");
		String result = AISnake.getInstance().getDirection();
		assertEquals(result, "Rightward");
	}
	
	@Test
	void test_setSnakeMove_Down() {
		SnakeSelfAutoMove.setSnakeMove("Downward");
		String result = AISnake.getInstance().getDirection();
		assertEquals(result, "Rightward");
	}

	@Test
	void test_shortestPathToBeanDirection() {
		SnakeSelfAutoMove autoSnake = new SnakeSelfAutoMove();
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 120);
		normalBean.setBeanXPos(150);
		aiSnake.setYCoordinate(0, 120);
		normalBean.setBeanYPos(130);
		
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				if(i==50 && j<80)
					virtualMapState[i][j] = SConstant.SC_MAP_RECORD_SNAKE;
				else
					virtualMapState[i][j] = SConstant.SC_MAP_RECORD_NULL;
			}
		}
		FindPathShortest findShortestPath = new FindPathShortest();
		LinkedList<MapNode> shortestPath =findShortestPath.search(virtualMapState, 50, 80, 60, 100);
//		SnakeSelfAutoMove.setShortestPath(shortestPath);
		assertEquals(shortestPath.size(), 0);
		String result = SnakeSelfAutoMove.shortestPathToBeanDirection(aiSnake, normalBean);
		assertEquals(result, null);
	}
	
	@Test
	void test_shortestPathToBeanDirection_2() {
		SnakeSelfAutoMove autoSnake = new SnakeSelfAutoMove();
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		normalBean.setBeanYPos(SConstant.SC_INIT_AI_SNAKE_HEAD_YPOS);
		normalBean.setBeanXPos(SConstant.SC_SNAKE_AVAIL_MAX_XPOS);
		
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		int xIdx = (aiSnake.getHeadXPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		int yIdx = (aiSnake.getHeadYPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		int len=aiSnake.getLength();
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				if(i==yIdx && j==xIdx && len>0) {
					virtualMapState[i][j] = SConstant.SC_MAP_RECORD_SNAKE;
					xIdx--;
					len--;
				}					
				else
					virtualMapState[i][j] = SConstant.SC_MAP_RECORD_NULL;
			}
		}
		FindPathShortest findShortestPath = new FindPathShortest();
		LinkedList<MapNode> shortestPath =findShortestPath.search(virtualMapState, SConstant.SC_INIT_AI_SNAKE_HEAD_XPOS, SConstant.SC_INIT_AI_SNAKE_HEAD_YPOS, SConstant.SC_SNAKE_AVAIL_MAX_XPOS, SConstant.SC_INIT_AI_SNAKE_HEAD_YPOS);
		String result = SnakeSelfAutoMove.shortestPathToBeanDirection(aiSnake, normalBean);
		assertEquals(result, shortestPath.remove().getDirection());
	}
	
	@Test
	void test_snakeWanderDirection_1() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 20);
		normalBean.setBeanXPos(50);
		aiSnake.setYCoordinate(0, 90);
		normalBean.setBeanYPos(80);

		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
	}
	
	@Test
	void test_snakeWanderDirection_2() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 20);
		normalBean.setBeanXPos(50);	
		aiSnake.setYCoordinate(0, 90);
		normalBean.setBeanYPos(80);
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		int xIdx = (aiSnake.getHeadXPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		int yIdx = (aiSnake.getHeadYPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		int len=aiSnake.getLength();
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				if(i==yIdx && j==xIdx && len>0) {
					virtualMapState[i][j] = SConstant.SC_MAP_RECORD_SNAKE;
					xIdx--;
					len--;
				}					
				else
					virtualMapState[i][j] = SConstant.SC_MAP_RECORD_NULL;
			}
		}
		FindPathShortest findShortestPath = new FindPathShortest();
		LinkedList<MapNode> shortestPath =findShortestPath.search(virtualMapState, 50, 80, 60, 100);
		assertEquals(shortestPath.size(), 0);
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, "Downward");
	}
	
	@Test
	void test_snakeWanderDirection_2_0() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 120);
		normalBean.setBeanXPos(150);	
		aiSnake.setYCoordinate(0, 190);
		normalBean.setBeanYPos(180);
		aiSnake.setDirection("Rightward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		int xIdx = (aiSnake.getHeadXPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		int yIdx = (aiSnake.getHeadYPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		int len=aiSnake.getLength();
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				if(i==yIdx && j==xIdx && len>0) {
					virtualMapState[i][j] = SConstant.SC_MAP_RECORD_SNAKE;
					xIdx--;
					len--;
				}					
				else
					virtualMapState[i][j] = SConstant.SC_MAP_RECORD_SNAKE;
			}
		}
		FindPathShortest findShortestPath = new FindPathShortest();
		LinkedList<MapNode> shortestPath =findShortestPath.search(virtualMapState, 50, 80, 60, 100);
		//SnakeSelfAutoMove.setShortestPath(shortestPath);
		assertEquals(shortestPath.size(), 0);
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, null);
	}
	
	@Test
	void test_snakeWanderDirection_2_0_1() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 120);
		normalBean.setBeanXPos(150);	
		aiSnake.setYCoordinate(0, 740);
		normalBean.setBeanYPos(730);
		aiSnake.setDirection("Upward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		int xIdx = (aiSnake.getHeadXPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		int yIdx = (aiSnake.getHeadYPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		int len=aiSnake.getLength();
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				if(i==yIdx && j==xIdx && len>0) {
					virtualMapState[i][j] = SConstant.SC_MAP_RECORD_SNAKE;
					xIdx--;
					len--;
				}					
				else
					virtualMapState[i][j] = SConstant.SC_MAP_RECORD_NULL;
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		//assertEquals(result, "Downward");
	}
	
	@Test
	void test_snakeWanderDirection_2_0_2() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 120);
		normalBean.setBeanXPos(150);	
		aiSnake.setYCoordinate(0, 190);
		normalBean.setBeanYPos(180);
		aiSnake.setDirection("Upward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		int xIdx = (aiSnake.getHeadXPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		int yIdx = (aiSnake.getHeadYPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		int len=aiSnake.getLength();
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				if(i==yIdx && j==xIdx && len>0) {
					virtualMapState[i][j] = SConstant.SC_MAP_RECORD_NULL;
					xIdx--;
					len--;
				}					
				else
					virtualMapState[i][j] = SConstant.SC_MAP_RECORD_SNAKE;
			}
		}
		FindPathShortest findShortestPath = new FindPathShortest();
		LinkedList<MapNode> shortestPath =findShortestPath.search(virtualMapState, 50, 80, 60, 100);
		//SnakeSelfAutoMove.setShortestPath(shortestPath);
		assertEquals(shortestPath.size(), 0);
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, null);
	}
	
	@Test
	void test_snakeWanderDirection_2_1() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 120);
		normalBean.setBeanXPos(150);	
		aiSnake.setYCoordinate(0, 180);
		normalBean.setBeanYPos(190);
		aiSnake.setDirection("Rightward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		int xIdx = (aiSnake.getHeadXPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		int yIdx = (aiSnake.getHeadYPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		int len=aiSnake.getLength();
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = SConstant.SC_MAP_RECORD_SNAKE;
				xIdx--;
				len--;
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, null);
	}

	@Test
	void test_snakeWanderDirection_2_2() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 20);
		normalBean.setBeanXPos(50);	
		aiSnake.setYCoordinate(0, 80);
		normalBean.setBeanYPos(90);
		aiSnake.setDirection("Rightward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		int xIdx = (aiSnake.getHeadXPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		int yIdx = (aiSnake.getHeadYPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		int len=aiSnake.getLength();
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = SConstant.SC_MAP_RECORD_NULL;
				xIdx--;
				len--;
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, "Upward");
	}
	
	@Test
	void test_snakeWanderDirection_3() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 60);	
		normalBean.setBeanXPos(50);	
		aiSnake.setYCoordinate(0, 90);
		normalBean.setBeanYPos(80);
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "snake";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, null);
	}
	
	@Test
	void test_snakeWanderDirection_3_1() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 60);	
		normalBean.setBeanXPos(50);	
		aiSnake.setYCoordinate(0, 90);
		normalBean.setBeanYPos(80);
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		int xIdx = (aiSnake.getHeadXPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		int yIdx = (aiSnake.getHeadYPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		int len=aiSnake.getLength();
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				if(i==yIdx && j==xIdx && len>0) {
					virtualMapState[i][j] = SConstant.SC_MAP_RECORD_SNAKE;
					xIdx--;
					len--;
				}					
				else
					virtualMapState[i][j] = SConstant.SC_MAP_RECORD_NULL;
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, "Downward");
	}
	
	@Test
	void test_snakeWanderDirection_4() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 50);	
		normalBean.setBeanXPos(10);	
		aiSnake.setYCoordinate(0, 50);
		normalBean.setBeanYPos(40);
		aiSnake.setDirection("Leftward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				if(i==50 && j<80)
					virtualMapState[i][j] = "snake";
				else
					virtualMapState[i][j] = " ";
			}
		}
		FindPathShortest findShortestPath = new FindPathShortest();
		LinkedList<MapNode> shortestPath =findShortestPath.search(virtualMapState, 50, 80, 60, 100);
		//SnakeSelfAutoMove.setShortestPath(shortestPath);
		assertEquals(shortestPath.size(), 0);
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, "Downward");
	}
	
	@Test
	void test_snakeWanderDirection_4_1() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 50);	
		normalBean.setBeanXPos(10);	
		aiSnake.setYCoordinate(0, 50);
		normalBean.setBeanYPos(40);
		aiSnake.setDirection("Leftward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = " ";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, "Downward");
	}
	
	@Test
	void test_snakeWanderDirection_5() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 180);	
		normalBean.setBeanXPos(160);	
		aiSnake.setYCoordinate(0, 150);
		normalBean.setBeanYPos(140);
		aiSnake.setDirection("Leftward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				if(i==50 && j<80)
					virtualMapState[i][j] = "snake";
				else
					virtualMapState[i][j] = " ";
			}
		}
		FindPathShortest findShortestPath = new FindPathShortest();
		LinkedList<MapNode> shortestPath =findShortestPath.search(virtualMapState, 50, 80, 60, 100);
		//SnakeSelfAutoMove.setShortestPath(shortestPath);
		assertEquals(shortestPath.size(), 0);
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, "Leftward");
	}
	
	@Test
	void test_snakeWanderDirection_5_0() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 180);	
		normalBean.setBeanXPos(160);	
		aiSnake.setYCoordinate(0, 150);
		normalBean.setBeanYPos(140);
		aiSnake.setDirection("Upward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = " ";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, "Leftward");
	}
	
	@Test
	void test_snakeWanderDirection_5_1() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 150);	
		normalBean.setBeanXPos(110);	
		aiSnake.setYCoordinate(0, 150);
		normalBean.setBeanYPos(140);
		aiSnake.setDirection("Leftward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "snake";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, null);
	}
	
	@Test
	void test_snakeWanderDirection_5_1_1() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 150);	
		normalBean.setBeanXPos(110);	
		aiSnake.setYCoordinate(0, 150);
		normalBean.setBeanYPos(140);
		aiSnake.setDirection("Leftward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		int xIdx = (aiSnake.getHeadXPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		int yIdx = (aiSnake.getHeadYPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		int len=aiSnake.getLength();
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = SConstant.SC_MAP_RECORD_SNAKE;
				xIdx--;
				len--;
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, null);
	}
	
	@Test
	void test_snakeWanderDirection_5_2() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 150);	
		normalBean.setBeanXPos(110);	
		aiSnake.setYCoordinate(0, 150);
		normalBean.setBeanYPos(140);
		aiSnake.setDirection("Rightward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "snake";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, null);
	}
	
	@Test
	void test_snakeWanderDirection_5_2_1() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 150);	
		normalBean.setBeanXPos(110);	
		aiSnake.setYCoordinate(0, 150);
		normalBean.setBeanYPos(140);
		aiSnake.setDirection("Rightward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 1; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 1; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = " ";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, "Rightward");
	}
	
	@Test
	void test_snakeWanderDirection_6() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 150);	
		normalBean.setBeanXPos(110);	
		aiSnake.setYCoordinate(0, 140);
		normalBean.setBeanYPos(150);
		aiSnake.setDirection("Leftward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "snake";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, null);
	}
	
	@Test
	void test_snakeWanderDirection_6_1() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 50);	
		normalBean.setBeanXPos(10);	
		aiSnake.setYCoordinate(0, 40);
		normalBean.setBeanYPos(50);
		aiSnake.setDirection("Leftward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = " ";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, "Upward");
	}
	
	@Test
	void test_snakeWanderDirection_7() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 150);	
		normalBean.setBeanXPos(140);	
		aiSnake.setYCoordinate(0, 110);
		normalBean.setBeanYPos(150);
		aiSnake.setDirection("Leftward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "snake";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, null);
	}
	
	@Test
	void test_snakeWanderDirection_7_0() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 50);	
		normalBean.setBeanXPos(40);	
		aiSnake.setYCoordinate(0, 10);
		normalBean.setBeanYPos(50);
		aiSnake.setDirection("Leftward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = " ";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, "Upward");
	}
	
	@Test
	void test_snakeWanderDirection_7_1() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 150);	
		normalBean.setBeanXPos(140);	
		aiSnake.setYCoordinate(0, 110);
		normalBean.setBeanYPos(150);
		aiSnake.setDirection("Downward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "snake";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, null);
	}
	
	@Test
	void test_snakeWanderDirection_7_1_1() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 125);	
		normalBean.setBeanXPos(120);	
		aiSnake.setYCoordinate(0, 115);
		normalBean.setBeanYPos(125);
		aiSnake.setDirection("Downward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = " ";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, "Rightward");
	}
	
	@Test
	void test_snakeWanderDirection_8() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 140);	
		normalBean.setBeanXPos(150);	
		aiSnake.setYCoordinate(0, 110);
		normalBean.setBeanYPos(150);
		aiSnake.setDirection("Downward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "snake";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, null);
	}
	
	@Test
	void test_snakeWanderDirection_8_1() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 140);	
		normalBean.setBeanXPos(150);	
		aiSnake.setYCoordinate(0, 110);
		normalBean.setBeanYPos(150);
		aiSnake.setDirection("Downward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = " ";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, "Leftward");
	}
	
	@Test
	void test_snakeWanderDirection_9() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 140);	
		normalBean.setBeanXPos(150);	
		aiSnake.setYCoordinate(0, 150);
		normalBean.setBeanYPos(110);
		aiSnake.setDirection("Downward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "snake";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, null);
	}
	
	@Test
	void test_snakeWanderDirection_9_0() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 40);	
		normalBean.setBeanXPos(50);	
		aiSnake.setYCoordinate(0, 50);
		normalBean.setBeanYPos(10);
		aiSnake.setDirection("Downward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = " ";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, "Downward");
	}
	
	@Test
	void test_snakeWanderDirection_9_1() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 140);	
		normalBean.setBeanXPos(150);	
		aiSnake.setYCoordinate(0, 150);
		normalBean.setBeanYPos(110);
		aiSnake.setDirection("Upward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "snake";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, null);
	}
	
	@Test
	void test_snakeWanderDirection_9_1_1() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 140);	
		normalBean.setBeanXPos(150);	
		aiSnake.setYCoordinate(0, 150);
		normalBean.setBeanYPos(110);
		aiSnake.setDirection("Upward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = " ";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, "Leftward");
	}
	
	@Test
	void test_snakeWanderDirection_9_2() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 150);	
		normalBean.setBeanXPos(140);	
		aiSnake.setYCoordinate(0, 150);
		normalBean.setBeanYPos(110);
		aiSnake.setDirection("Upward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "snake";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, null);
	}
	
	@Test
	void test_snakeWanderDirection_9_2_1() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 150);	
		normalBean.setBeanXPos(140);	
		aiSnake.setYCoordinate(0, 150);
		normalBean.setBeanYPos(110);
		aiSnake.setDirection("Upward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = " ";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, "Rightward");
	}
	
	@Test
	void test_snakeWanderDirection_10_1() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 50);	
		normalBean.setBeanXPos(140);	
		aiSnake.setYCoordinate(0, 150);
		normalBean.setBeanYPos(110);
		aiSnake.setDirection("Upward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "snake";
			}
		}
		virtualMapState[2][3] = " ";
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, "Rightward");
	}
	
	@Test
	void test_snakeWanderDirection_10_2() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 60);	
		normalBean.setBeanXPos(140);	
		aiSnake.setYCoordinate(0, 150);
		normalBean.setBeanYPos(110);
		aiSnake.setDirection("Upward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "snake";
			}
		}
		virtualMapState[2][2] = " ";
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, null);
	}
	
	@Test
	void test_snakeWanderDirection_10_3() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 60);	
		normalBean.setBeanXPos(140);	
		aiSnake.setYCoordinate(0, 150);
		normalBean.setBeanYPos(110);
		aiSnake.setDirection("Upward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "snake";
			}
		}
		virtualMapState[2][1] = " ";
		virtualMapState[2][2] = " ";
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		assertEquals(result, "Upward");
		virtualMapState[2][1] = " ";
		virtualMapState[2][2] = "snake";
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		
	}
	
	@Test
	void test_snakeWanderDirection_10_4() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 60);	
		normalBean.setBeanXPos(140);	
		aiSnake.setYCoordinate(0, 150);
		normalBean.setBeanYPos(110);
		aiSnake.setDirection("Upward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "snake";
			}
		}
		virtualMapState[1][4] = " ";
		virtualMapState[1][5] = " ";
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
		//assertEquals(result, "Upward");
		virtualMapState[1][4] = "snake";
		virtualMapState[1][5] = "snake";
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
	}
	
	@Test
	void test_snakeWanderDirection_10_5() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 20);	
		normalBean.setBeanXPos(140);	
		aiSnake.setYCoordinate(0, 150);
		normalBean.setBeanYPos(110);
		aiSnake.setDirection("Upward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		int xIdx = (aiSnake.getHeadXPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		int yIdx = (aiSnake.getHeadYPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		int len=aiSnake.getLength();
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				if(i==yIdx && j==xIdx && len>0) {
					virtualMapState[i][j] = SConstant.SC_MAP_RECORD_SNAKE;
					xIdx--;
					len--;
				}					
				else
					virtualMapState[i][j] = SConstant.SC_MAP_RECORD_NULL;
			}
		}
		virtualMapState[63][5] = " ";
		selfMove.setVirtualMapState(virtualMapState);
		String result = SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
	}
	
	@Test
	void test_longestPathToTailDirection_1() {
		AISnake aiSnake = AISnake.getInstance();
		aiSnake.setXCoordinate(0, 50);	

		SnakeSelfAutoMove.longestPathToTailDirection(aiSnake);
	}
	
	@Test
	void test_longestPathToBeanDirection_1() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		aiSnake.setXCoordinate(0, 150);	
		normalBean.setBeanXPos(140);	
		aiSnake.setYCoordinate(0, 150);
		normalBean.setBeanYPos(110);
		aiSnake.setDirection("Upward");
		SnakeSelfAutoMove.longestPathToBeanDirection(aiSnake, normalBean);
	}
	
	@Test
	void test_longestPathToBeanDirection_2() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();	
		normalBean.setBeanYPos(SConstant.SC_INIT_AI_SNAKE_HEAD_YPOS);
		normalBean.setBeanXPos(SConstant.SC_SNAKE_AVAIL_MAX_XPOS);
		
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		int xIdx = (aiSnake.getHeadXPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		int yIdx = (aiSnake.getHeadYPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		int len=aiSnake.getLength();
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				if(i==yIdx && j==xIdx && len>0) {
					virtualMapState[i][j] = SConstant.SC_MAP_RECORD_SNAKE;
					xIdx--;
					len--;
				}					
				else
					virtualMapState[i][j] = SConstant.SC_MAP_RECORD_NULL;
			}
		}
		FindPathLongest findLongestPath = new FindPathLongest();
		SnakeSelfAutoMove.longestPathToBeanDirection(aiSnake, normalBean);
		LinkedList<MapNode> longestPath =findLongestPath.search(virtualMapState, SConstant.SC_INIT_AI_SNAKE_HEAD_XPOS, SConstant.SC_INIT_AI_SNAKE_HEAD_YPOS, SConstant.SC_SNAKE_AVAIL_MAX_XPOS, SConstant.SC_INIT_AI_SNAKE_HEAD_YPOS);
		String result = SnakeSelfAutoMove.longestPathToBeanDirection(aiSnake, normalBean);
		assertEquals(longestPath.remove().getDirection(),"Downward");
	}
	
	@Test
	void test_thinkAndMove_1() {
		Snake snake = AISnake.getInstance();
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		int xIdx = (aiSnake.getHeadXPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		int yIdx = (aiSnake.getHeadYPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
		int len=aiSnake.getLength();
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				if(i==yIdx && j==xIdx && len>0) {
					virtualMapState[i][j] = SConstant.SC_MAP_RECORD_SNAKE;
					xIdx--;
					len--;
				}					
				else
					virtualMapState[i][j] = SConstant.SC_MAP_RECORD_NULL;
			}
		}
		FindPathLongest findLongestPath = new FindPathLongest();
		SnakeSelfAutoMove.longestPathToBeanDirection(aiSnake, normalBean);
		LinkedList<MapNode> longestPath =findLongestPath.search(virtualMapState, SConstant.SC_INIT_AI_SNAKE_HEAD_XPOS, SConstant.SC_INIT_AI_SNAKE_HEAD_YPOS, SConstant.SC_SNAKE_AVAIL_MAX_XPOS, SConstant.SC_INIT_AI_SNAKE_HEAD_YPOS);
		String result = SnakeSelfAutoMove.thinkAndMove(aiSnake, normalBean, "Rightward");
		assertEquals(result, "Rightward");
	}
}
