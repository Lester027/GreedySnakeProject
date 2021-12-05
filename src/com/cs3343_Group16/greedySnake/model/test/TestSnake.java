package com.cs3343_Group16.greedySnake.model.test;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer; 

import com.cs3343_Group16.greedySnake.model.details.*;
import com.cs3343_Group16.greedySnake.system.MapStatement;
import com.cs3343_Group16.greedySnake.system.SConstant;

import static org.junit.Assert.*;

import java.util.ArrayList;

@TestMethodOrder (MethodOrderer.OrderAnnotation. class )
public class TestSnake {
	
	@BeforeEach
	void setUp() throws Exception {
		AISnake.getInstance().initial();
		AISnake.getInstance().setDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
		PlayerSnake.getInstance().initial();
		PlayerSnake.getInstance().setDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
		MapStatement.getInstance().initRecord();
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		AISnake.getInstance().initial();
		AISnake.getInstance().setDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
		PlayerSnake.getInstance().initial();
		PlayerSnake.getInstance().setDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
		MapStatement.getInstance().initRecord();
	}
	
	@Order(2)
	@Test
	public void testClone() {
		PlayerSnake psnake=PlayerSnake.getInstance();
		
		ArrayList<ArrayList<Integer>> result=psnake.clone();
		
		int xpos=SConstant.SC_INIT_SNAKE_HEAD_XPOS;
		for(int i = 0; i < SConstant.SC_INIT_SNAKE_LENGTH; i++) {
			int x =result.get(i).get(SConstant.SC_COORDINATE_XPOS_KEY);
			int y=result.get(i).get(SConstant.SC_COORDINATE_YPOS_KEY);
			assertEquals(xpos,x);
			assertEquals(SConstant.SC_INIT_SNAKE_HEAD_YPOS,y);
			xpos -= SConstant.SC_DEFAULT_NODE_SIZE;
		}		
	}
	
	@Order(3)
	@Test
	public void testUpdateMove() {
		PlayerSnake psnake=PlayerSnake.getInstance();
	
		psnake.updateMove();
		
		int move=psnake.getMove();
		assertEquals(1,move);		
	}
	
	@Order(4)
	@Test
	public void testUpdateScore() {
		PlayerSnake psnake=PlayerSnake.getInstance();
	
		psnake.updateScore(1);
		
		int score=psnake.getScore();
		assertEquals(1,score);		
	}
	
	@Order(5)
	@Test
	public void testSetDirection() {
		PlayerSnake psnake=PlayerSnake.getInstance();
		psnake.setDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG);
		String direction=psnake.getDirection();
		
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG,direction);
	}
	
	@Order(6)
	@Test
	public void testUpdateLength() {
		PlayerSnake psnake=PlayerSnake.getInstance();
			
		psnake.updateLength();
			
		int length=psnake.getLength();
		
		//update coordinate after increasing the length
		int x=SConstant.SC_INIT_SNAKE_HEAD_XPOS+SConstant.SC_DEFAULT_NODE_SIZE;
		for(int i=0;i<psnake.getLength();i++) {
			psnake.setXCoordinate(i, x);
			psnake.setYCoordinate(i, SConstant.SC_INIT_SNAKE_HEAD_YPOS);
			x-=SConstant.SC_DEFAULT_NODE_SIZE;
		}
		
		assertEquals(SConstant.SC_INIT_SNAKE_LENGTH+1,length);		
	}
	

	@Order(7)
	@Test
	public void testUpdateMapStatus() {
		PlayerSnake psnake=PlayerSnake.getInstance();
		psnake.updateMapStatus();
		String[][] records = MapStatement.getInstance().getRecords();
		
		int x,y;
		for(int i=0;i<psnake.getLength();i++) {
			x=(psnake.getXCoordinate(i) - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
			y=(psnake.getYCoordinate(i) - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE;
			assertEquals(SConstant.SC_MAP_RECORD_SNAKE,records[x][y]);
		}
	}
	
	@Order(8)
	@Test
	public void testSelfForeignalItemDetection_1(){
		boolean result = PlayerSnake.getInstance().selfForeignalItemDetection(SConstant.SC_INIT_SNAKE_HEAD_XPOS, SConstant.SC_INIT_SNAKE_HEAD_YPOS);
		assertTrue(result);
	}
	
	@Order(9)
	@Test
	public void testSelfForeignalItemDetection_2(){
		boolean result = PlayerSnake.getInstance().selfForeignalItemDetection(SConstant.SC_MAP_X_AXIS_CAPACITY, SConstant.SC_MAP_Y_AXIS_CAPACITY);
		assertFalse(result);
	}
	
	@Order(10)
	@Test
	public void testSelfDeathDetection_1() {
		PlayerSnake psnake=PlayerSnake.getInstance();
		
		assertFalse(psnake.selfDeathDetection());
	}
	


	@Order(11)
	@Test
	public void testSelfDeathDetection_2() {
		PlayerSnake psnake=PlayerSnake.getInstance();
		psnake.setXCoordinate(0,SConstant.SC_INIT_SNAKE_HEAD_XPOS-SConstant.SC_DEFAULT_NODE_SIZE);
		
		assertTrue(psnake.selfDeathDetection());
	}
	
}
