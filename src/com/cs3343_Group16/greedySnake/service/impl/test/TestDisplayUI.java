package com.cs3343_Group16.greedySnake.service.impl.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import org.junit.jupiter.api.Test;

import com.cs3343_Group16.greedySnake.action.UIPainting;
import com.cs3343_Group16.greedySnake.model.Game;
import com.cs3343_Group16.greedySnake.system.SConstant;
import com.cs3343_Group16.greedySnake.util.GameMonitor;

class TestDisplayUI {
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
	
	
	@Test
	void test_DisplayGameModeChoose_Player_1() {
		Game game = new Game();
		game.setMode("player");
		game.painting(stubGraphics);
		UIPainting stubUI = new UIPainting();
		stubUI.paint(stubGraphics);
	}
	
	@Test
	void test_DisplayGameModeChoose_Player_2() {
		Game game = new Game();
		game.setMode("player");
		game.painting(stubGraphics);
		game.getSnake();
		UIPainting stubUI = new UIPainting();
		stubUI.paint(stubGraphics);
	}
	
	@Test
	void test_DisplayGameModeChoose_AI_1() {
		Game game = new Game();
		game.setMode("AI");
		game.painting(stubGraphics);
		UIPainting stubUI = new UIPainting();
		stubUI.paint(stubGraphics);
	}
	
	@Test
	void test_DisplayGameModeChoose_AI_2() {
		Game game = new Game();
		game.setMode("AI");
		game.painting(stubGraphics);
		game.getSnake();
		UIPainting stubUI = new UIPainting();
		stubUI.paint(stubGraphics);	
	}
	
	@Test
	void test_DisplayGameModeChoose_default() {
		Game game = new Game();
		game.setMode(SConstant.SC_GAME_MODE_DEFAULT);
		game.painting(stubGraphics);
		game.getSnake();
		UIPainting stubUI = new UIPainting();
		stubUI.paint(stubGraphics);	
	}
	
	@Test
	void test_DisplayGameModeChoose_reinit() {
		Game game = new Game();
		game.setMode("player");
		game.painting(stubGraphics);
		UIPainting stubUI = new UIPainting();
		stubUI.paint(stubGraphics);
		game.reinit();
	}

	@Test
	void test_Display_GameMonitor_mode_1() {
		Game game = new Game();
		game.setMode("player");
		game.painting(stubGraphics);
		game.getSnake();
		GameMonitor.Monitor(game, stubGraphics);
		UIPainting stubUI = new UIPainting();
		stubUI.paint(stubGraphics);	
	}
	
	@Test
	void test_Display_GameMonitor_mode_2() {
		Game game = new Game();
		game.setMode("AI");
		game.painting(stubGraphics);
		game.getSnake();
		GameMonitor.Monitor(game, stubGraphics);
		UIPainting stubUI = new UIPainting();
		stubUI.paint(stubGraphics);	
	}
	
	@Test
	void test_Display_GameStartDetection_1() {
		Game game = new Game();
		game.setMode("player");
		game.painting(stubGraphics);
		game.getSnake().updateMove();
		GameMonitor.GameStartDetection(game, stubGraphics);
		
	}
}
