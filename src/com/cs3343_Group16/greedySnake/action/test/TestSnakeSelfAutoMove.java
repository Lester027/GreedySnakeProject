package com.cs3343_Group16.greedySnake.action.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cs3343_Group16.greedySnake.action.SnakeSelfAutoMove;
import com.cs3343_Group16.greedySnake.model.Bean;
import com.cs3343_Group16.greedySnake.model.Snake;
import com.cs3343_Group16.greedySnake.model.details.AISnake;
import com.cs3343_Group16.greedySnake.model.details.NormalBean;
import com.cs3343_Group16.greedySnake.system.SConstant;

class TestSnakeSelfAutoMove {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test_setSnakeMove_Right() {
		SnakeSelfAutoMove.setSnakeMove("Rightward");
	}
	
	@Test
	void test_setSnakeMove_Left() {
		SnakeSelfAutoMove.setSnakeMove("Leftward");
	}
	
	@Test
	void test_setSnakeMove_Up() {
		SnakeSelfAutoMove.setSnakeMove("Upward");
	}
	
	@Test
	void test_setSnakeMove_Down() {
		SnakeSelfAutoMove.setSnakeMove("Downward");
	}

	@Test
	void test_shortestPathToBeanDirection() {
		SnakeSelfAutoMove autoSnake = new SnakeSelfAutoMove();
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 20);
		normalBean.setBeanXPos(50);
		aiSnake.setYCoordinate(0, 20);
		normalBean.setBeanYPos(30);
		SnakeSelfAutoMove.shortestPathToBeanDirection(aiSnake, normalBean);
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
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "snake";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
	}
	
	@Test
	void test_snakeWanderDirection_2_0() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 20);
		normalBean.setBeanXPos(50);	
		aiSnake.setYCoordinate(0, 90);
		normalBean.setBeanYPos(80);
		aiSnake.setDirection("Rightward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "snake";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
	}
	
	@Test
	void test_snakeWanderDirection_2_0_1() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 20);
		normalBean.setBeanXPos(50);	
		aiSnake.setYCoordinate(0, 90);
		normalBean.setBeanYPos(80);
		aiSnake.setDirection("Rightward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "null";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
	}
	
	@Test
	void test_snakeWanderDirection_2_1() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 20);
		normalBean.setBeanXPos(50);	
		aiSnake.setYCoordinate(0, 80);
		normalBean.setBeanYPos(90);
		aiSnake.setDirection("Rightward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "snake";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
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
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "null";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
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
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
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
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "null";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
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
				virtualMapState[i][j] = "snake";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
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
				virtualMapState[i][j] = "null";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
	}
	
	@Test
	void test_snakeWanderDirection_5() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 80);	
		normalBean.setBeanXPos(60);	
		aiSnake.setYCoordinate(0, 50);
		normalBean.setBeanYPos(40);
		aiSnake.setDirection("Leftward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "snake";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
	}
	
	@Test
	void test_snakeWanderDirection_5_0() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 80);	
		normalBean.setBeanXPos(60);	
		aiSnake.setYCoordinate(0, 50);
		normalBean.setBeanYPos(40);
		aiSnake.setDirection("Leftward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "null";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
	}
	
	@Test
	void test_snakeWanderDirection_5_1() {
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
				virtualMapState[i][j] = "snake";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
	}
	
	@Test
	void test_snakeWanderDirection_5_1_1() {
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
				virtualMapState[i][j] = "null";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
	}
	
	@Test
	void test_snakeWanderDirection_5_2() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 50);	
		normalBean.setBeanXPos(10);	
		aiSnake.setYCoordinate(0, 50);
		normalBean.setBeanYPos(40);
		aiSnake.setDirection("Rightward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "snake";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
	}
	
	@Test
	void test_snakeWanderDirection_5_2_1() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 50);	
		normalBean.setBeanXPos(10);	
		aiSnake.setYCoordinate(0, 50);
		normalBean.setBeanYPos(40);
		aiSnake.setDirection("Rightward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "null";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
	}
	
	@Test
	void test_snakeWanderDirection_6() {
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
				virtualMapState[i][j] = "snake";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
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
				virtualMapState[i][j] = "null";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
	}
	
	@Test
	void test_snakeWanderDirection_7() {
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
				virtualMapState[i][j] = "snake";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
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
				virtualMapState[i][j] = "null";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
	}
	
	@Test
	void test_snakeWanderDirection_7_1() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 50);	
		normalBean.setBeanXPos(40);	
		aiSnake.setYCoordinate(0, 10);
		normalBean.setBeanYPos(50);
		aiSnake.setDirection("Downward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "snake";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
	}
	
	@Test
	void test_snakeWanderDirection_7_1_1() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 50);	
		normalBean.setBeanXPos(40);	
		aiSnake.setYCoordinate(0, 10);
		normalBean.setBeanYPos(50);
		aiSnake.setDirection("Downward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "null";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
	}
	
	@Test
	void test_snakeWanderDirection_8() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 40);	
		normalBean.setBeanXPos(50);	
		aiSnake.setYCoordinate(0, 10);
		normalBean.setBeanYPos(50);
		aiSnake.setDirection("Downward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "snake";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
	}
	
	@Test
	void test_snakeWanderDirection_8_1() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 40);	
		normalBean.setBeanXPos(50);	
		aiSnake.setYCoordinate(0, 10);
		normalBean.setBeanYPos(50);
		aiSnake.setDirection("Downward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "null";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
	}
	
	@Test
	void test_snakeWanderDirection_9() {
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
				virtualMapState[i][j] = "snake";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
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
				virtualMapState[i][j] = "null";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
	}
	
	@Test
	void test_snakeWanderDirection_9_1() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 40);	
		normalBean.setBeanXPos(50);	
		aiSnake.setYCoordinate(0, 50);
		normalBean.setBeanYPos(10);
		aiSnake.setDirection("Upward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "snake";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
	}
	
	@Test
	void test_snakeWanderDirection_9_1_1() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 40);	
		normalBean.setBeanXPos(50);	
		aiSnake.setYCoordinate(0, 50);
		normalBean.setBeanYPos(10);
		aiSnake.setDirection("Upward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "null";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
	}
	
	@Test
	void test_snakeWanderDirection_9_2() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 50);	
		normalBean.setBeanXPos(40);	
		aiSnake.setYCoordinate(0, 50);
		normalBean.setBeanYPos(10);
		aiSnake.setDirection("Upward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "snake";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
	}
	
	@Test
	void test_snakeWanderDirection_9_2_1() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		aiSnake.setXCoordinate(0, 50);	
		normalBean.setBeanXPos(40);	
		aiSnake.setYCoordinate(0, 50);
		normalBean.setBeanYPos(10);
		aiSnake.setDirection("Upward");
		SnakeSelfAutoMove selfMove = new SnakeSelfAutoMove();
		String[][] virtualMapState = new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				virtualMapState[i][j] = "null";
			}
		}
		selfMove.setVirtualMapState(virtualMapState);
		SnakeSelfAutoMove.snakeWanderDirection(aiSnake, normalBean);
	}
	
	@Test
	void test_longestPathToTailDirection_1() {
		AISnake aiSnake = AISnake.getInstance();
		aiSnake.setXCoordinate(0, 50);	

		SnakeSelfAutoMove.longestPathToTailDirection(aiSnake);
	}
	
	@Test
	void test_longestPathToTailDirection_2() {
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		aiSnake.setXCoordinate(0, 50);	
		normalBean.setBeanXPos(40);	
		aiSnake.setYCoordinate(0, 50);
		normalBean.setBeanYPos(10);
		aiSnake.setDirection("Upward");
		SnakeSelfAutoMove.longestPathToBeanDirection(aiSnake, normalBean);
	}
	
	@Test
	void test_thinkAndMove_1() {
		Snake snake = AISnake.getInstance();
		AISnake aiSnake = AISnake.getInstance();
		Bean normalBean = NormalBean.getInstance();
		
		SnakeSelfAutoMove.thinkAndMove(aiSnake, normalBean, "Rightward");
	}
}
