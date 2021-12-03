package com.cs3343_Group16.greedySnake.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.cs3343_Group16.greedySnake.model.Game;
import com.cs3343_Group16.greedySnake.model.details.AISnake;
import com.cs3343_Group16.greedySnake.model.details.PlayerSnake;
import com.cs3343_Group16.greedySnake.service.Display;
import com.cs3343_Group16.greedySnake.service.impl.DisplayGameStart;
import com.cs3343_Group16.greedySnake.system.SConstant;
import com.cs3343_Group16.greedySnake.util.GameMonitor;

@TestMethodOrder (MethodOrderer.OrderAnnotation. class )
public class TestGameMonitor {
	@BeforeEach
	void setUp() throws Exception {
	
	}
	
	@AfterEach
	public void tearDown() throws Exception {
	    AISnake.getInstance().initial();
	    PlayerSnake.getInstance().initial();
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
	public void testGameStartDetection_1() {
		Game g =new Game();
		g.setMode(SConstant.SC_GAME_MODE_PlAYER);
		boolean result = GameMonitor.GameStartDetection(g, stubGraphics);
		assertTrue(result);
	}
	
	@Order(2)
	@Test
	public void testGameStartDetection_2() {
		Game g =new Game();
		g.setMode(SConstant.SC_GAME_MODE_PlAYER);
		
		//start the game
		g.getSnake().updateMove();
		boolean result = GameMonitor.GameStartDetection(g, stubGraphics);
		assertTrue(result);
	}
	
	@Test
	public void testGameStartDetection_3() {
		Display display = new DisplayGameStart();
		display.display(stubGraphics);
		//boolean result = GameMonitor.GameStartDetection(g, stubGraphics);
		//assertTrue(result);
	}
	
	@Order(3)
	@Test
	public void testDeathDetection_1() {
		Game g =new Game();
		g.setMode(SConstant.SC_GAME_MODE_PlAYER);
		
		boolean result = GameMonitor.DeathDetection(g, stubGraphics);
		assertFalse(result);
	}
	
	
	@Order(4)
	@Test
	public void testDeathDetection_2() {
		Game g =new Game();
		g.setMode(SConstant.SC_GAME_MODE_PlAYER);
		
		//snake head touches its body
		g.getSnake().setXCoordinate(0,SConstant.SC_INIT_SNAKE_HEAD_XPOS-SConstant.SC_DEFAULT_NODE_SIZE);
		boolean result = GameMonitor.DeathDetection(g, stubGraphics);
		assertTrue(result);
	}
	
	@Order(5)
	@Test
	public void testMonitor_1() {
		Game g= new Game();
		boolean result = GameMonitor.Monitor(g, stubGraphics);
		assertFalse(result);
	}
	
	@Order(6)
	@Test
	public void testMonitor_2() {
		Game g= new Game();
		g.setMode(SConstant.SC_GAME_MODE_AI);
		boolean result = GameMonitor.Monitor(g, stubGraphics);
		assertFalse(result);
	}
	
	@Order(7)
	@Test
	public void testMonitor_3() {
		Game g= new Game();
		g.setMode(SConstant.SC_GAME_MODE_AI);
		
		//ai snake head touches its body
		g.getSnake().setXCoordinate(0,SConstant.SC_INIT_AI_SNAKE_HEAD_XPOS-SConstant.SC_DEFAULT_NODE_SIZE);
		boolean result = GameMonitor.Monitor(g, stubGraphics);
		assertTrue(result);
	}
	
	@Order(8)
	@Test
	public void testMonitor_4() {
		Game g= new Game();
		g.setMode(SConstant.SC_GAME_MODE_PlAYER);
		
		g.getSnake().setXCoordinate(0,SConstant.SC_INIT_SNAKE_HEAD_XPOS-SConstant.SC_DEFAULT_NODE_SIZE);
		boolean result = GameMonitor.Monitor(g, stubGraphics);
		
		assertTrue(result);
	}

	@Order(9)
	@Test
	public void testScoreDetection_1() {
		Game g= new Game();
		g.setMode(SConstant.SC_GAME_MODE_PlAYER);
		g.getBean().setBeanXPos(10);
		g.getSnake().setXCoordinate(0, 10);
		g.getBean().setBeanYPos(10);
		g.getSnake().setYCoordinate(0, 20);
		GameMonitor.ScoreDetection(g);
	}
	
	@Order(10)
	@Test
	public void testScoreDetection_2() {
		Game g= new Game();
		g.setMode(SConstant.SC_GAME_MODE_PlAYER);
		g.getBean().setBeanXPos(10);
		g.getSnake().setXCoordinate(0, 10);
		g.getBean().setBeanYPos(10);
		g.getSnake().setYCoordinate(0, 10);
		GameMonitor.ScoreDetection(g);
	}

	
}
