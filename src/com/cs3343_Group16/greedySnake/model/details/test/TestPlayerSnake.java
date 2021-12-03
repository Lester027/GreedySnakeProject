package com.cs3343_Group16.greedySnake.model.details.test;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer; 

import com.cs3343_Group16.greedySnake.model.details.*;
import com.cs3343_Group16.greedySnake.system.SConstant;

import static org.junit.Assert.*;


@TestMethodOrder (MethodOrderer.OrderAnnotation. class )
public class TestPlayerSnake {
	
	@BeforeEach
	void setUp() throws Exception {
		PlayerSnake.getInstance().initial();
	}
	
	@AfterEach
	public void tearDown() throws Exception {
	    PlayerSnake.getInstance().initial();
	}
	
	@Order(1)
	@Test
	public void testInitialization(){
		PlayerSnake psnake=PlayerSnake.getInstance();
		
		//head
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_XPOS,psnake.getHeadXPos());
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_YPOS,psnake.getHeadYPos());
		//body
		int xpos=SConstant.SC_INIT_SNAKE_HEAD_XPOS-SConstant.SC_DEFAULT_NODE_SIZE;
		for(int i = 1; i < SConstant.SC_INIT_SNAKE_LENGTH; i++) {
			assertEquals(xpos,psnake.getXCoordinate(i));
			assertEquals(SConstant.SC_INIT_SNAKE_HEAD_YPOS,psnake.getYCoordinate(i));
			xpos -= SConstant.SC_DEFAULT_NODE_SIZE;
		}
		
	}
	
	@Order(2)
	@Test
	public void testGetInstance(){
		PlayerSnake psnake=PlayerSnake.getInstance();
		
		assertEquals(PlayerSnake.class,psnake.getClass());
		
	}
	
}
