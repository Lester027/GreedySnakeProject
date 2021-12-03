package com.cs3343_Group16.greedySnake.model.details.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer; 

import com.cs3343_Group16.greedySnake.model.details.*;
import com.cs3343_Group16.greedySnake.system.SConstant;

import static org.junit.Assert.*;


@TestMethodOrder (MethodOrderer.OrderAnnotation. class )
public class TestAISnake {
	@BeforeEach
	void setUp() throws Exception {
		AISnake.getInstance().initial();
	}	
	
	@AfterEach
	public void tearDown() throws Exception {
	    AISnake.getInstance().initial();
	}
	
	@Order(1)
	@Test
	public void testInitialization(){
		AISnake asnake=AISnake.getInstance();
		
		//head
		assertEquals(SConstant.SC_INIT_AI_SNAKE_HEAD_XPOS,asnake.getHeadXPos());
		assertEquals(SConstant.SC_INIT_AI_SNAKE_HEAD_YPOS,asnake.getHeadYPos());
		//body
		int xpos=SConstant.SC_INIT_AI_SNAKE_HEAD_XPOS-SConstant.SC_DEFAULT_NODE_SIZE;
		for(int i = 1; i < SConstant.SC_INIT_SNAKE_LENGTH; i++) {
			assertEquals(xpos,asnake.getXCoordinate(i));
			assertEquals(SConstant.SC_INIT_AI_SNAKE_HEAD_YPOS,asnake.getYCoordinate(i));
			xpos -= SConstant.SC_DEFAULT_NODE_SIZE;
		}
		//move
		assertEquals(0,asnake.getMove());
		//direction
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG,asnake.getDirection());
		
	}
	
	@Order(2)
	@Test
	public void testGetInstance() {
		AISnake asnake=AISnake.getInstance();
		
		assertEquals(AISnake.class,asnake.getClass());
	}
	

}
