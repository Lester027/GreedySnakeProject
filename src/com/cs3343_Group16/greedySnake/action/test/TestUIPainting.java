package com.cs3343_Group16.greedySnake.action.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.awt.event.*;
import java.text.AttributedCharacterIterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.cs3343_Group16.greedySnake.action.SnakeSelfAutoMove;
import com.cs3343_Group16.greedySnake.action.UIPainting;
import com.cs3343_Group16.greedySnake.model.Game;
import com.cs3343_Group16.greedySnake.model.details.AISnake;
import com.cs3343_Group16.greedySnake.model.details.PlayerSnake;
import com.cs3343_Group16.greedySnake.service.impl.*;
import com.cs3343_Group16.greedySnake.system.MapStatement;
import com.cs3343_Group16.greedySnake.system.SConstant;

@TestMethodOrder (MethodOrderer.OrderAnnotation. class )
class TestUIPainting {
	@BeforeEach
	void setUp() throws Exception {
//	    AISnake.getInstance().initial();
//	    PlayerSnake.getInstance().initial();
//	    MapStatement.getInstance().initRecord();
	}
	
	@AfterEach
	public void tearDown() throws Exception {
	    AISnake.getInstance().initial();
	    PlayerSnake.getInstance().initial();
	    MapStatement.getInstance().initRecord();
	}
	
	Graphics stubGraphics = new Graphics() {
		
		@Override
		public void translate(int x, int y) {
			// TODO Auto-generated method stub
		}
		
		@Override
		public void setXORMode(Color c1) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void setPaintMode() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void setFont(Font font) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void setColor(Color c) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void setClip(int x, int y, int width, int height) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void setClip(Shape clip) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public FontMetrics getFontMetrics(Font f) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Font getFont() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Color getColor() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Rectangle getClipBounds() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Shape getClip() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void fillRect(int x, int y, int width, int height) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void fillOval(int x, int y, int width, int height) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void drawString(AttributedCharacterIterator iterator, int x, int y) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void drawString(String str, int x, int y) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void drawOval(int x, int y, int width, int height) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void drawLine(int x1, int y1, int x2, int y2) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
				Color bgcolor, ImageObserver observer) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
				ImageObserver observer) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public Graphics create() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void copyArea(int x, int y, int width, int height, int dx, int dy) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void clipRect(int x, int y, int width, int height) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void clearRect(int x, int y, int width, int height) {
			// TODO Auto-generated method stub
			
		}
	};
	
	

	
	@Order(1)
	@Test
	public void testPaint_1() {		
		UIPainting ui = new UIPainting();
		ui.paint(stubGraphics);
		
		assertTrue(ui.getTimerStatus());
	}
	
	@Order(2)
	@Test
	public void testPaint_2() {
		Game g =new Game();
		g.setMode(SConstant.SC_GAME_MODE_PlAYER);
		g.getSnake().setXCoordinate(0,SConstant.SC_INIT_SNAKE_HEAD_XPOS-SConstant.SC_DEFAULT_NODE_SIZE);
		
		UIPainting ui = new UIPainting(g);
		ui.paint(stubGraphics);
		
		assertFalse(ui.getTimerStatus());		
	}
	
	@Order(3)
	@Test
	public void testSetSnakemove_1() {
		UIPainting ui = new UIPainting();
		ui.setSnakemove(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);
		
		assertEquals(SnakeMoveRight.class,ui.getSnakemove().getClass());
	}
	
	@Order(4)
	@Test
	public void testSetSnakemove_2() {
		UIPainting ui = new UIPainting();
		ui.setSnakemove(SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG);
		
		assertEquals(SnakeMoveLeft.class,ui.getSnakemove().getClass());
	}
	
	@Order(5)
	@Test
	public void testSetSnakemove_3() {
		UIPainting ui = new UIPainting();
		ui.setSnakemove(SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG);
		
		assertEquals(SnakeMoveDown.class,ui.getSnakemove().getClass());
	}
	
	@Order(6)
	@Test
	public void testSetSnakemove_4() {
		UIPainting ui = new UIPainting();
		ui.setSnakemove(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG);
		
		assertEquals(SnakeMoveUp.class,ui.getSnakemove().getClass());
	}
	
	@Order(7)
	@Test
	public void testSetSnakemove_5() {
		UIPainting ui = new UIPainting();
		ui.setSnakemove("test");
		
		assertNull(ui.getSnakemove());
	}
	
	@Order(8)
	@Test
	public void testActionPerformed_1() {
		Game g =new Game();
		g.setMode(SConstant.SC_GAME_MODE_PlAYER);
		g.getSnake().setDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG);
		UIPainting ui = new UIPainting(g);
		ActionEvent e=new ActionEvent(ui, 0, "test");
		
		ui.actionPerformed(e);
		
		//map statement result should not be updated
		String[][] result= new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				result[i][j] = SConstant.SC_MAP_RECORD_NULL;
			}
		}
		assertArrayEquals(result,MapStatement.getInstance().getRecords());
		//snakemove is changed according to player snake's moving direction
		assertEquals(SnakeMoveUp.class,ui.getSnakemove().getClass());
	}
	
	
	@Order(9)
	@Test
	public void testKeyPress_1() {
		Game g=new Game();
		UIPainting ui = new UIPainting(g);
		@SuppressWarnings("deprecation")
		KeyEvent e= new KeyEvent(ui, 0, 0, 0, KeyEvent.VK_SPACE);
		
		ui.keyPressed(e);
		assertEquals(SConstant.SC_DEFAULT_KEYBOARD_LOCK,ui.getKeyLock());
	}
	
	@Order(11)
	@Test
	public void testKeyPress_2() {
		Game g=new Game();
		g.setMode(SConstant.SC_GAME_MODE_PlAYER);
		UIPainting ui = new UIPainting(g);
		@SuppressWarnings("deprecation")
		KeyEvent e= new KeyEvent(ui, 0, 0, 0, KeyEvent.VK_SPACE);
		
		ui.keyPressed(e);
		assertEquals(SConstant.SC_DEFAULT_KEYBOARD_LOCK,ui.getKeyLock());
	}
	
	@Order(12)
	@Test
	public void testKeyPress_3() {
		Game g=new Game();
		g.setMode(SConstant.SC_GAME_MODE_AI);
		UIPainting ui = new UIPainting(g);
		@SuppressWarnings("deprecation")
		KeyEvent e= new KeyEvent(ui, 0, 0, 0, KeyEvent.VK_SPACE);
		
		ui.keyPressed(e);
		assertEquals(SConstant.SC_UPDATED_KEYBOARD_LOCK,ui.getKeyLock());
	}
	
	@Order(13)
	@Test
	public void testKeyPress_4() {
		Game g=new Game();
		UIPainting ui = new UIPainting(g);
		@SuppressWarnings("deprecation")
		KeyEvent e= new KeyEvent(ui, 0, 0, 0, KeyEvent.VK_1);
		
		ui.keyPressed(e);
		assertEquals(SConstant.SC_GAME_MODE_PlAYER,g.getMode());
	}
	
	
	@Order(14)
	@Test
	public void testKeyPress_5() {
		Game g=new Game();
		UIPainting ui = new UIPainting(g);
		@SuppressWarnings("deprecation")
		KeyEvent e= new KeyEvent(ui, 0, 0, 0, KeyEvent.VK_2);
		
		ui.keyPressed(e);
		assertEquals(SConstant.SC_GAME_MODE_AI,g.getMode());
	}
	
	
	@Order(15)
	@Test
	public void testKeyPress_6() {
		Game g=new Game();
		g.setMode(SConstant.SC_GAME_MODE_PlAYER);
		g.getSnake().setDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);		
		UIPainting ui = new UIPainting(g);
		@SuppressWarnings("deprecation")
		KeyEvent e= new KeyEvent(ui, 0, 0, 0, KeyEvent.VK_DOWN);
		
		ui.keyPressed(e);
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG,g.getSnake().getDirection());
	}
	
	@Order(16)
	@Test
	public void testKeyPress_7() {
		Game g=new Game();
		g.setMode(SConstant.SC_GAME_MODE_PlAYER);
		g.getSnake().setDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);		
		UIPainting ui = new UIPainting(g);
		@SuppressWarnings("deprecation")
		KeyEvent e= new KeyEvent(ui, 0, 0, 0, KeyEvent.VK_UP);
		
		ui.keyPressed(e);
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG,g.getSnake().getDirection());
	}
	
	@Order(17)
	@Test
	public void testKeyPress_8() {
		Game g=new Game();
		g.setMode(SConstant.SC_GAME_MODE_PlAYER);
		g.getSnake().setDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG);		
		UIPainting ui = new UIPainting(g);
		@SuppressWarnings("deprecation")
		KeyEvent e= new KeyEvent(ui, 0, 0, 0, KeyEvent.VK_LEFT);
		
		ui.keyPressed(e);
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG,g.getSnake().getDirection());
	}
	
	@Order(18)
	@Test
	public void testKeyPress_9() {
		Game g=new Game();
		g.setMode(SConstant.SC_GAME_MODE_PlAYER);
		g.getSnake().setDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG);		
		UIPainting ui = new UIPainting(g);
		@SuppressWarnings("deprecation")
		KeyEvent e= new KeyEvent(ui, 0, 0, 0, KeyEvent.VK_RIGHT);
		
		ui.keyPressed(e);
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG,g.getSnake().getDirection());
	}
	
	@Order(19)
	@Test
	public void testKeyPress_10() {
		Game g=new Game();
		g.setMode(SConstant.SC_GAME_MODE_PlAYER);
		g.getSnake().setDirection(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG);		
		UIPainting ui = new UIPainting(g);
		@SuppressWarnings("deprecation")
		KeyEvent e= new KeyEvent(ui, 0, 0, 0, KeyEvent.VK_ENTER);
		
		ui.keyPressed(e);
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG,g.getSnake().getDirection());
	}

	@Order(20)
	@Test
	public void testSetKeaylock() {
		UIPainting ui = new UIPainting();
		ui.setKeyLock(SConstant.SC_UPDATED_KEYBOARD_LOCK);
		assertEquals(SConstant.SC_UPDATED_KEYBOARD_LOCK,ui.getKeyLock());
	}
	
	@Order(21)
	@Test
	public void testActionPerformed_2() {
		Game g =new Game();
		g.setMode(SConstant.SC_GAME_MODE_AI);
		UIPainting ui = new UIPainting(g);
		g.getSnake().updateMapStatus();
		g.getBean().updateMapStatus();
		String direction=SnakeSelfAutoMove.thinkAndMove(((AISnake) g.getSnake()), g.getBean(),g.getSnake().getDirection());
		ActionEvent e=new ActionEvent(ui, 0, "test");
		
		ui.actionPerformed(e);
		
		//snake move direction should be computed by the AI
//		assertEquals(direction,AISnake.getInstance().getDirection());
		assertNotNull(ui.getSnakemove());
	}

}


