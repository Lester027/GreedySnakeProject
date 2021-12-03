package com.cs3343_Group16.greedySnake.model.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.cs3343_Group16.greedySnake.model.Game;
import com.cs3343_Group16.greedySnake.model.MapNode;
import com.cs3343_Group16.greedySnake.model.Snake;
import com.cs3343_Group16.greedySnake.model.details.*;
import com.cs3343_Group16.greedySnake.system.SConstant;

import static org.junit.Assert.*;

public class TestMapNode {
	
	@BeforeEach
	void setUp() throws Exception {
		 AISnake.getInstance().initial();
		 PlayerSnake.getInstance().initial();
	}
	
	@AfterEach
	public void tearDown() throws Exception {
	    AISnake.getInstance().initial();
	    PlayerSnake.getInstance().initial();
	}
	
	@Test
	public void testConstructor_1() {
		MapNode m =new MapNode();
		assertEquals(m.getxPos(),SConstant.SC_SNAKE_NODE_DEFAULT_INIT_VALUE);
		assertEquals(m.getyPos(),SConstant.SC_SNAKE_NODE_DEFAULT_INIT_VALUE);
		assertEquals(m.getLength(),SConstant.SC_SNAKE_NODE_DEFAULT_INIT_VALUE);
		assertEquals(m.getDirection(),SConstant.SC_SNAKE_MOVE_DIRECTION_DEATH_FLAG);
		assertEquals(m.getForeseeScore(),SConstant.SC_SNAKE_NODE_DEFAULT_SCORE_VALUE);
		assertEquals(m.getxIdx(),(m.getxPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE);
		assertEquals(m.getyIdx(),(m.getyPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE);
	}
	
	@Test
	public void testConstructor_2() {
		MapNode m =new MapNode(1,1);
		assertEquals(m.getxPos(),1);
		assertEquals(m.getyPos(),1);
		assertEquals(m.getLength(),SConstant.SC_SNAKE_NODE_DEFAULT_INIT_VALUE);
		assertEquals(m.getDirection(),SConstant.SC_SNAKE_MOVE_DIRECTION_DEATH_FLAG);
		assertEquals(m.getForeseeScore(),SConstant.SC_SNAKE_NODE_DEFAULT_SCORE_VALUE);
		assertEquals(m.getxIdx(),(m.getxPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE);
		assertEquals(m.getyIdx(),(m.getyPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE);
	}
	
	@Test
	public void testConstructor_3() {
		MapNode m =new MapNode(1,1,SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG);
		assertEquals(m.getxPos(),1);
		assertEquals(m.getyPos(),1);
		assertEquals(m.getLength(),SConstant.SC_SNAKE_NODE_DEFAULT_INIT_VALUE);
		assertEquals(m.getDirection(),SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG);
		assertEquals(m.getForeseeScore(),SConstant.SC_SNAKE_NODE_DEFAULT_SCORE_VALUE);
		assertEquals(m.getxIdx(),(m.getxPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE);
		assertEquals(m.getyIdx(),(m.getyPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE);
	}
	
	@Test
	public void testConstructor_4() {
		MapNode m =new MapNode(1,1,SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG,1,1);
		assertEquals(m.getxPos(),1);
		assertEquals(m.getyPos(),1);
		assertEquals(m.getLength(),1);
		assertEquals(m.getDirection(),SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG);
		assertEquals(m.getForeseeScore(),1);
		assertEquals(m.getxIdx(),(m.getxPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE);
		assertEquals(m.getyIdx(),(m.getyPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE);
	}
	
	@Test
	public void testConstructor_5() {
		MapNode goal = new MapNode();
		MapNode m =new MapNode(1,1,SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG,1,goal);
		int s_result=1 + Math.abs(goal.getxPos() - 1)+Math.abs(goal.getyPos() - 1);
		assertEquals(m.getxPos(),1);
		assertEquals(m.getyPos(),1);
		assertEquals(m.getLength(),1);
		assertEquals(m.getDirection(),SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG);
		assertEquals(m.getForeseeScore(),s_result);
		assertEquals(m.getxIdx(),(m.getxPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS) / SConstant.SC_DEFAULT_NODE_SIZE);
		assertEquals(m.getyIdx(),(m.getyPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS) / SConstant.SC_DEFAULT_NODE_SIZE);
	}
	
	@Test
	public void testStaticNextNode_1() {
		//Current MapNode is on the right border of the game body
		MapNode current=new MapNode(SConstant.SC_SNAKE_AVAIL_MAX_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS,SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
		
		//Use default MapNode as destination to test
		MapNode destination = new MapNode();
		
		//Search for the nest node in right direction
		MapNode result=MapNode.nextNode(current, SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG, destination);
		
		//Result MapNode is on the left border of the game body
		assertEquals(SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS,result.getxPos());
		//Result MapNode is on the y pos as current MapNode
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_YPOS,result.getyPos());
		//Result direction is "rightward"
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG,result.getDirection());
		//Result MapNode increase the current distance by 1
		assertEquals(SConstant.SC_SNAKE_NODE_DEFAULT_INIT_VALUE+1,result.getLength());
		//Result MapNode compute the preScore according to the destination MapNode	
		int s_result=SConstant.SC_SNAKE_NODE_DEFAULT_INIT_VALUE+1 + Math.abs(destination.getxPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS)+Math.abs(destination.getyPos() - SConstant.SC_INIT_SNAKE_HEAD_YPOS);
		assertEquals(s_result,result.getForeseeScore());
		
	}
	
	@Test
	public void testStaticNextNode_2() {
		//Current MapNode is not on the right border of the game body
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS,SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
		
		//Use default MapNode as destination to test
		MapNode destination = new MapNode();
		
		//Search for the next node in right direction
		MapNode result=MapNode.nextNode(current, SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG, destination);
		
		//Result MapNode is one move to the right from the current MapNode
		int x_result=SConstant.SC_INIT_SNAKE_HEAD_XPOS+SConstant.SC_DEFAULT_NODE_SIZE;
		assertEquals(x_result,result.getxPos());
		//Result MapNode is on the y pos as current MapNode
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_YPOS,result.getyPos());
		//Result direction is "rightward"
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG,result.getDirection());
		//Result MapNode increase the current distance by 1
		assertEquals(SConstant.SC_SNAKE_NODE_DEFAULT_INIT_VALUE+1,result.getLength());
		//Result MapNode compute the preScore according to the destination MapNode	
		int s_result=SConstant.SC_SNAKE_NODE_DEFAULT_INIT_VALUE+1 + Math.abs(destination.getxPos() - x_result)+Math.abs(destination.getyPos() - SConstant.SC_INIT_SNAKE_HEAD_YPOS);
		assertEquals(s_result,result.getForeseeScore());
		
	}
	
	@Test
	public void testStaticNextNode_3() {
		//Current MapNode is on the bottom border of the game body
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_SNAKE_AVAIL_MAX_YPOS,SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
		
		//Use default MapNode as destination to test
		MapNode destination = new MapNode();
		
		//Search for the next node in downward direction
		MapNode result=MapNode.nextNode(current, SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG, destination);
		
		//Result MapNode is on the upper border of the game body
		assertEquals(SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS,result.getyPos());
		//Result MapNode is on the x pos as current MapNode
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_XPOS,result.getxPos());
		//Result direction is "downward"
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG,result.getDirection());
		//Result MapNode increase the current distance by 1
		assertEquals(SConstant.SC_SNAKE_NODE_DEFAULT_INIT_VALUE+1,result.getLength());
		//Result MapNode compute the preScore according to the destination MapNode	
		int s_result=SConstant.SC_SNAKE_NODE_DEFAULT_INIT_VALUE+1 + Math.abs(destination.getxPos() - SConstant.SC_INIT_SNAKE_HEAD_XPOS)+Math.abs(destination.getyPos() - SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS);
		assertEquals(s_result,result.getForeseeScore());
		
	}
	
	@Test
	public void testStaticNextNode_4() {
		//Current MapNode is not on the bottom border of the game body
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS,SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
				
		//Use default MapNode as destination to test
		MapNode destination = new MapNode();
		
		//Search for the next node in downward direction
		MapNode result=MapNode.nextNode(current, SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG, destination);
		
		//Result MapNode is one move to the bottom from the current MapNode
		int y_result=SConstant.SC_INIT_SNAKE_HEAD_YPOS+SConstant.SC_DEFAULT_NODE_SIZE;
		assertEquals(y_result,result.getyPos());
		//Result MapNode is on the x pos as current MapNode
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_XPOS,result.getxPos());
		//Result direction is "downward"
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG,result.getDirection());
		//Result MapNode increase the current distance by 1
		assertEquals(SConstant.SC_SNAKE_NODE_DEFAULT_INIT_VALUE+1,result.getLength());
		//Result MapNode compute the preScore according to the destination MapNode	
		int s_result=SConstant.SC_SNAKE_NODE_DEFAULT_INIT_VALUE+1 + Math.abs(destination.getxPos() - SConstant.SC_INIT_SNAKE_HEAD_XPOS)+Math.abs(destination.getyPos() - y_result);
		assertEquals(s_result,result.getForeseeScore());
		
	}
	
	@Test
	public void testStaticNextNode_5() {
		//Current MapNode is on the left border of the game body
		MapNode current=new MapNode(SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS,SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
		
		//Use default MapNode as destination to test
		MapNode destination = new MapNode();
		
		//Search for the next node in leftward direction
		MapNode result=MapNode.nextNode(current, SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG, destination);
		
		//Result MapNode is on the right border of the game body
		assertEquals(SConstant.SC_SNAKE_AVAIL_MAX_XPOS,result.getxPos());
		//Result MapNode is on the y pos as current MapNode
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_YPOS,result.getyPos());
		//Result direction is "leftward"
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG,result.getDirection());
		//Result MapNode increase the current distance by 1
		assertEquals(SConstant.SC_SNAKE_NODE_DEFAULT_INIT_VALUE+1,result.getLength());
		//Result MapNode compute the preScore according to the destination MapNode	
		int s_result=SConstant.SC_SNAKE_NODE_DEFAULT_INIT_VALUE+1 + Math.abs(destination.getxPos() - SConstant.SC_SNAKE_AVAIL_MAX_XPOS)+Math.abs(destination.getyPos() - SConstant.SC_INIT_SNAKE_HEAD_YPOS);
		assertEquals(s_result,result.getForeseeScore());
		
	}
	
	@Test
	public void testStaticNextNode_6() {
		//Current MapNode is not on the left border of the game body
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS,SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
		
		//Use default MapNode as destination to test
		MapNode destination = new MapNode();
		
		//Search for the next node in leftward direction
		MapNode result=MapNode.nextNode(current, SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG, destination);
		
		//Result MapNode is one move to the left from the current MapNode
		int x_result=SConstant.SC_INIT_SNAKE_HEAD_XPOS-SConstant.SC_DEFAULT_NODE_SIZE;
		assertEquals(x_result,result.getxPos());
		//Result MapNode is on the y pos as current MapNode
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_YPOS,result.getyPos());
		//Result direction is "leftward"
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG,result.getDirection());
		//Result MapNode increase the current distance by 1
		assertEquals(SConstant.SC_SNAKE_NODE_DEFAULT_INIT_VALUE+1,result.getLength());
		//Result MapNode compute the preScore according to the destination MapNode	
		int s_result=SConstant.SC_SNAKE_NODE_DEFAULT_INIT_VALUE+1 + Math.abs(destination.getxPos() - x_result)+Math.abs(destination.getyPos() - SConstant.SC_INIT_SNAKE_HEAD_YPOS);
		assertEquals(s_result,result.getForeseeScore());
		
	}
	
	@Test
	public void testStaticNextNode_7() {
		//Current MapNode is on the upper border of the game body
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS,SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
		
		//Use default MapNode as destination to test
		MapNode destination = new MapNode();
		
		//Search for the next node in upward direction
		MapNode result=MapNode.nextNode(current, SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG, destination);
		
		//Result MapNode is on the bottom border of the game body
		assertEquals(SConstant.SC_SNAKE_AVAIL_MAX_YPOS,result.getyPos());
		//Result MapNode is on the x pos as current MapNode
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_XPOS,result.getxPos());
		//Result direction is "upward"
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG,result.getDirection());
		//Result MapNode increase the current distance by 1
		assertEquals(SConstant.SC_SNAKE_NODE_DEFAULT_INIT_VALUE+1,result.getLength());
		//Result MapNode compute the preScore according to the destination MapNode	
		int s_result=SConstant.SC_SNAKE_NODE_DEFAULT_INIT_VALUE+1 + Math.abs(destination.getxPos() - SConstant.SC_INIT_SNAKE_HEAD_XPOS)+Math.abs(destination.getyPos() - SConstant.SC_SNAKE_AVAIL_MAX_YPOS);
		assertEquals(s_result,result.getForeseeScore());
		
	}
	
	@Test
	public void testStaticNextNode_8() {
		//Current MapNode is not on the upper border of the game body
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS+SConstant.SC_DEFAULT_NODE_SIZE,SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
				
		//Use default MapNode as destination to test
		MapNode destination = new MapNode();
		
		//Search for the next node in upward direction
		MapNode result=MapNode.nextNode(current, SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG, destination);
		
		//Result MapNode is one move to the up from the current MapNode
		int y_result=SConstant.SC_INIT_SNAKE_HEAD_YPOS;
		assertEquals(y_result,result.getyPos());
		//Result MapNode is on the x pos as current MapNode
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_XPOS,result.getxPos());
		//Result direction is "downward"
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG,result.getDirection());
		//Result MapNode increase the current distance by 1
		assertEquals(SConstant.SC_SNAKE_NODE_DEFAULT_INIT_VALUE+1,result.getLength());
		//Result MapNode compute the preScore according to the destination MapNode	
		int s_result=SConstant.SC_SNAKE_NODE_DEFAULT_INIT_VALUE+1 + Math.abs(destination.getxPos() - SConstant.SC_INIT_SNAKE_HEAD_XPOS)+Math.abs(destination.getyPos() - y_result);
		assertEquals(s_result,result.getForeseeScore());
		
	}
	
	@Test
	public void testStaticNextNode_9() {
		//Current MapNode is not on the upper border of the game body
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS+SConstant.SC_DEFAULT_NODE_SIZE,SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
				
		//Use default MapNode as destination to test
		MapNode destination = new MapNode();
		
		//Invalid direction
		MapNode result=MapNode.nextNode(current,"test", destination);
		
		assertNull(result);
		
	}
	
	@Test
	public void testNextNode_1() {
		//Current MapNode is on the right border of the game body
		MapNode current=new MapNode(SConstant.SC_SNAKE_AVAIL_MAX_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS);
		
		//Search for the next node in rightward direction
		MapNode result=current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
		
		//Result MapNode is on the left border of the game body
		assertEquals(SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS,result.getxPos());
		//Result MapNode is on the y pos as current MapNode
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_YPOS,result.getyPos());
		//Result direction is "rightward"
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG,result.getDirection());		
	}
	
	@Test
	public void testNextNode_2() {
		//Current MapNode is not on the right border of the game body
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS);
		
		//Search for the next node in right direction
		MapNode result=current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
		
		//Result MapNode is one move to the right from the current MapNode
		int x_result=SConstant.SC_INIT_SNAKE_HEAD_XPOS+SConstant.SC_DEFAULT_NODE_SIZE;
		assertEquals(x_result,result.getxPos());
		//Result MapNode is on the y pos as current MapNode
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_YPOS,result.getyPos());
		//Result direction is "rightward"
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG,result.getDirection());
		
	}
	
	@Test
	public void testNextNode_3() {
		//Current MapNode is on the bottom border of the game body
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_SNAKE_AVAIL_MAX_YPOS);
		
		//Search for the next node in downward direction
		MapNode result=current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG);
		
		//Result MapNode is on the upper border of the game body
		assertEquals(SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS,result.getyPos());
		//Result MapNode is on the x pos as current MapNode
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_XPOS,result.getxPos());
		//Result direction is "downward"
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG,result.getDirection());
	}
	
	@Test
	public void testNextNode_4() {
		//Current MapNode is not on the bottom border of the game body
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS);
		
		//Search for the next node in downward direction
		MapNode result=current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG);
		
		//Result MapNode is one move to the bottom from the current MapNode
		int y_result=SConstant.SC_INIT_SNAKE_HEAD_YPOS+SConstant.SC_DEFAULT_NODE_SIZE;
		assertEquals(y_result,result.getyPos());
		//Result MapNode is on the x pos as current MapNode
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_XPOS,result.getxPos());
		//Result direction is "downward"
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG,result.getDirection());
		
	}
	
	@Test
	public void testNextNode_5() {
		//Current MapNode is on the left border of the game body
		MapNode current=new MapNode(SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS);
		
		//Search for the next node in leftward direction
		MapNode result=current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG);
		
		//Result MapNode is on the right border of the game body
		assertEquals(SConstant.SC_SNAKE_AVAIL_MAX_XPOS,result.getxPos());
		//Result MapNode is on the y pos as current MapNode
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_YPOS,result.getyPos());
		//Result direction is "leftward"
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG,result.getDirection());
	}
	
	@Test
	public void testNextNode_6() {
		//Current MapNode is not on the left border of the game body
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS);

		//Search for the next node in leftward direction
		MapNode result=current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG);
		
		//Result MapNode is one move to the left from the current MapNode
		int x_result=SConstant.SC_INIT_SNAKE_HEAD_XPOS-SConstant.SC_DEFAULT_NODE_SIZE;
		assertEquals(x_result,result.getxPos());
		//Result MapNode is on the y pos as current MapNode
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_YPOS,result.getyPos());
		//Result direction is "leftward"
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG,result.getDirection());
	}
	
	@Test
	public void testNextNode_7() {
		//Current MapNode is on the upper border of the game body
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS);
		
		//Search for the next node in downward direction
		MapNode result=current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG);
		
		//Result MapNode is on the bottom border of the game body
		assertEquals(SConstant.SC_SNAKE_AVAIL_MAX_YPOS,result.getyPos());
		//Result MapNode is on the x pos as current MapNode
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_XPOS,result.getxPos());
		//Result direction is "upward"
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG,result.getDirection());
	}
	
	@Test
	public void testNextNode_8() {
		//Current MapNode is not on the upper border of the game body
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS+SConstant.SC_DEFAULT_NODE_SIZE);

		//Search for the next node in upward direction
		MapNode result=current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG);
		
		//Result MapNode is one move to the up from the current MapNode
		int y_result=SConstant.SC_INIT_SNAKE_HEAD_YPOS;
		assertEquals(y_result,result.getyPos());
		//Result MapNode is on the x pos as current MapNode
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_XPOS,result.getxPos());
		//Result direction is "downward"
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG,result.getDirection());
	}
	
	@Test
	public void testNextNode_9() {
		//Current MapNode is not on the upper border of the game body
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS+SConstant.SC_DEFAULT_NODE_SIZE);
		
		//Invalid direction
		MapNode result=current.nextNode("test");
		
		assertNull(result);		
	}
	
	@Test
	public void testPrevNode_1() {
		//Current MapNode is on the left border of the game body
		MapNode current=new MapNode(SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS);
		
		//current MapNode is moving rightward
		MapNode result=current.prevNode(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
		
		//Result MapNode is on the right border of the game body
		assertEquals(SConstant.SC_SNAKE_AVAIL_MAX_XPOS,result.getxPos());
		//Result MapNode is on the y pos as current MapNode
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_YPOS,result.getyPos());
		//Result direction is "rightward"
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG,result.getDirection());		
	}
	
	@Test
	public void testPrevNode_2() {
		//Current MapNode is not on the left border of the game body
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS);
		
		//current MapNode is moving rightward
		MapNode result=current.prevNode(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
		
		//Result MapNode is one move to the left from the current MapNode
		int x_result=SConstant.SC_INIT_SNAKE_HEAD_XPOS-SConstant.SC_DEFAULT_NODE_SIZE;
		assertEquals(x_result,result.getxPos());
		//Result MapNode is on the y pos as current MapNode
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_YPOS,result.getyPos());
		//Result direction is "rightward"
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG,result.getDirection());
		
	}
	
	@Test
	public void testPrevNode_3() {
		//Current MapNode is on the upper border of the game body
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS);
		
		//current MapNode is moving downward
		MapNode result=current.prevNode(SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG);
		
		//Result MapNode is on the bottom border of the game body
		assertEquals(SConstant.SC_SNAKE_AVAIL_MAX_YPOS,result.getyPos());
		//Result MapNode is on the x pos as current MapNode
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_XPOS,result.getxPos());
		//Result direction is "downward"
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG,result.getDirection());
	}
	
	@Test
	public void testPrevNode_4() {
		//Current MapNode is not on the upper border of the game body
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_SNAKE_AVAIL_MAX_YPOS);
		
		//current MapNode is moving downward
		MapNode result=current.prevNode(SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG);
		
		//Result MapNode is one move to the up from the current MapNode
		int y_result=SConstant.SC_SNAKE_AVAIL_MAX_YPOS-SConstant.SC_DEFAULT_NODE_SIZE;
		assertEquals(y_result,result.getyPos());
		//Result MapNode is on the x pos as current MapNode
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_XPOS,result.getxPos());
		//Result direction is "downward"
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG,result.getDirection());
		
	}
	
	@Test
	public void testPrevNode_5() {
		//Current MapNode is on the right border of the game body
		MapNode current=new MapNode(SConstant.SC_SNAKE_AVAIL_MAX_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS);
		
		//current MapNode is moving leftward
		MapNode result=current.prevNode(SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG);
		
		//Result MapNode is on the left border of the game body
		assertEquals(SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS,result.getxPos());
		//Result MapNode is on the y pos as current MapNode
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_YPOS,result.getyPos());
		//Result direction is "leftward"
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG,result.getDirection());
	}
	
	@Test
	public void testPrevNode_6() {
		//Current MapNode is not on the right border of the game body
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS);

		//current MapNode is moving leftward
		MapNode result=current.prevNode(SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG);
		
		//Result MapNode is one move to the right from the current MapNode
		int x_result=SConstant.SC_INIT_SNAKE_HEAD_XPOS+SConstant.SC_DEFAULT_NODE_SIZE;
		assertEquals(x_result,result.getxPos());
		//Result MapNode is on the y pos as current MapNode
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_YPOS,result.getyPos());
		//Result direction is "leftward"
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG,result.getDirection());
	}
	
	@Test
	public void testPrevNode_7() {
		//Current MapNode is on the bottom border of the game body
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_SNAKE_AVAIL_MAX_YPOS);
		
		//current MapNode is moving upward
		MapNode result=current.prevNode(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG);
		
		//Result MapNode is on the upper border of the game body
		assertEquals(SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS,result.getyPos());
		//Result MapNode is on the x pos as current MapNode
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_XPOS,result.getxPos());
		//Result direction is "upward"
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG,result.getDirection());
	}
	
	@Test
	public void testPrevNode_8() {
		//Current MapNode is not on the bottom border of the game body
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS);

		//current MapNode is moving upward
		MapNode result=current.prevNode(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG);
		
		//Result MapNode is one move to the bottom from the current MapNode
		int y_result=SConstant.SC_INIT_SNAKE_HEAD_YPOS+SConstant.SC_DEFAULT_NODE_SIZE;
		assertEquals(y_result,result.getyPos());
		//Result MapNode is on the x pos as current MapNode
		assertEquals(SConstant.SC_INIT_SNAKE_HEAD_XPOS,result.getxPos());
		//Result direction is "downward"
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG,result.getDirection());
	}
	
	@Test
	public void testPrevNode_9() {
		//Current MapNode is not on the upper border of the game body
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS+SConstant.SC_DEFAULT_NODE_SIZE);
		
		//Invalid direction
		MapNode result=current.prevNode("test");
		
		assertNull(result);		
	}
	
	@Test
	public void testLeftward_1() {
		
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS,SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
		
		MapNode result=current.leftward();
		
		//right -> up
		assertEquals(current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG).getxPos(),result.getxPos());
		assertEquals(current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG).getyPos(),result.getyPos());
		assertEquals(current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG).getDirection(),result.getDirection());
	}
	
	@Test
	public void testLeftward_2() {
		
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS,SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG);
		
		MapNode result=current.leftward();
		
		//up->left
		assertEquals(current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG).getxPos(),result.getxPos());
		assertEquals(current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG).getyPos(),result.getyPos());
		assertEquals(current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG).getDirection(),result.getDirection());
	}
	@Test
	public void testLeftward_3() {
		
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS,SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG);
		
		MapNode result=current.leftward();
		
		//left->down
		assertEquals(current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG).getxPos(),result.getxPos());
		assertEquals(current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG).getyPos(),result.getyPos());
		assertEquals(current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG).getDirection(),result.getDirection());
	}
	@Test
	public void testLeftward_4() {
		
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS,SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG);
		
		MapNode result=current.leftward();
		
		//down->right
		assertEquals(current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG).getxPos(),result.getxPos());
		assertEquals(current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG).getyPos(),result.getyPos());
		assertEquals(current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG).getDirection(),result.getDirection());
	}
	@Test
	public void testLeftward_5() {
		
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS,"test");
		
		MapNode result=current.leftward();
		
		assertNull(result);
	}
	
	@Test
	public void testRightward_1() {
		
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS,SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
		
		MapNode result=current.rightward();
		
		//right -> down
		assertEquals(current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG).getxPos(),result.getxPos());
		assertEquals(current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG).getyPos(),result.getyPos());
		assertEquals(current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG).getDirection(),result.getDirection());
	}
	
	@Test
	public void testRightward_2() {
		
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS,SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG);
		
		MapNode result=current.rightward();
		
		//down->left
		assertEquals(current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG).getxPos(),result.getxPos());
		assertEquals(current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG).getyPos(),result.getyPos());
		assertEquals(current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG).getDirection(),result.getDirection());
	}
	@Test
	public void testRightward_3() {
		
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS,SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG);
		
		MapNode result=current.rightward();
		
		//left->up
		assertEquals(current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG).getxPos(),result.getxPos());
		assertEquals(current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG).getyPos(),result.getyPos());
		assertEquals(current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG).getDirection(),result.getDirection());
	}
	@Test
	public void testRightward_4() {
		
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS,SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG);
		
		MapNode result=current.rightward();
		
		//up->right
		assertEquals(current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG).getxPos(),result.getxPos());
		assertEquals(current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG).getyPos(),result.getyPos());
		assertEquals(current.nextNode(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG).getDirection(),result.getDirection());
	}
	@Test
	public void testRightward_5() {
		
		MapNode current=new MapNode(SConstant.SC_INIT_SNAKE_HEAD_XPOS,SConstant.SC_INIT_SNAKE_HEAD_YPOS,"test");
		
		MapNode result=current.rightward();
		
		assertNull(result);
	}
	
	@Test
	public void testOppositeDirection_1() {
		String result=MapNode.OppositeDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
		
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG,result);
	}
	
	@Test
	public void testOppositeDirection_2() {
		String result=MapNode.OppositeDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG);
		
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG,result);
	}
	
	@Test
	public void testOppositeDirection_3() {
		String result=MapNode.OppositeDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG);
		
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG,result);
	}
	
	@Test
	public void testOppositeDirection_4() {
		String result=MapNode.OppositeDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG);
		
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG,result);
	}
	
	@Test
	public void testOppositeDirection_5() {
		String result=MapNode.OppositeDirection("test");
		
		assertNull(result);
	}
	
}
