package com.cs3343_Group16.greedySnake.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Settings extends JPanel implements KeyListener, ActionListener{
	private int[] xCoordinate = new int [750];
	private int[] yCoordinate = new int [750];
	
	private boolean leftward = false;
	private boolean rightward = false;
	private boolean upward = false;
	private boolean downward = false;
	
	private ImageIcon upMouth;
	private ImageIcon downMouth;
	private ImageIcon leftMouth;
	private ImageIcon rightMouth;
	
	private int SnakeLength = 3;
	
	private Timer timer;
	private int delay = 100;
	private ImageIcon snake;
	
	private int [] pointXCoordinate = {25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325,
			350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625, 650,
			675, 700, 725, 750, 775, 800, 825, 850};
	private int [] pointYCoordinate = {75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350,
			375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625};
	
	private ImageIcon pointImage;
	
	private Random randomNumber = new Random();
	
	private int xpos = randomNumber.nextInt(34);
	private int ypos = randomNumber.nextInt(23);
	
	private int score = 0;
	
	private int moves = 0;
	
	private ImageIcon headerImg;
	public Settings () {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}
	
	public void paint(Graphics graphic) {
		
		if (moves == 0) {
			xCoordinate[2] = 50;
			xCoordinate[1] = 75;
			xCoordinate[0] = 100;
			
			yCoordinate[2] = 100;
			yCoordinate[1] = 100;
			yCoordinate[0] = 100;
		}
		
		graphic.setColor(Color.WHITE);
		graphic.drawRect(24, 10 ,851, 55);
		
		//Title
		headerImg = new ImageIcon("Image/title.png");
		headerImg.paintIcon(this, graphic, 25, 11);
		
		//Border
		graphic.setColor(Color.WHITE);
		graphic.drawRect(24, 74, 851, 577);
		
		//Background
		graphic.setColor(Color.WHITE);
		graphic.fillRect(25, 75, 850, 575);
		
		//Score
		graphic.setColor(Color.WHITE);
		graphic.setFont(new Font("arial", Font.PLAIN, 14));
		graphic.drawString("Scores: " + score, 780, 30);
		
		//Length
		graphic.setColor(Color.WHITE);
		graphic.setFont(new Font("arial", Font.PLAIN, 14));
		graphic.drawString("Length: " + SnakeLength, 780, 50);
		
		rightMouth = new ImageIcon("Image/SnakeHeadRight.png");
		rightMouth.paintIcon(this, graphic, xCoordinate[0] ,yCoordinate[0]);
		
		for (int a =0; a < SnakeLength; a++) {
			if (a==0 && rightward) {
				rightMouth = new ImageIcon("Image/SnakeHeadRight.png");
				rightMouth.paintIcon(this, graphic, xCoordinate[a] ,yCoordinate[a]);
			}
			if (a==0 && leftward) {
				leftMouth = new ImageIcon("Image/SnakeHeadLeft.png");
				leftMouth.paintIcon(this, graphic, xCoordinate[a] ,yCoordinate[a]);
			}
			if (a==0 && downward) {
				downMouth = new ImageIcon("Image/SnakeHeadDown.png");
				downMouth.paintIcon(this, graphic, xCoordinate[a] ,yCoordinate[a]);
			}
			if (a==0 && upward) {
				upMouth = new ImageIcon("Image/SnakeHeadUp.png");
				upMouth.paintIcon(this, graphic, xCoordinate[a] ,yCoordinate[a]);
			}
			
			if (a!=0) {
				snake = new ImageIcon("Image/SnakeBody.png");
				snake.paintIcon(this, graphic, xCoordinate[a] ,yCoordinate[a]);
			}
			
		}
		
		pointImage = new ImageIcon("Image/Point.png");
		
		if ((pointXCoordinate[xpos] == xCoordinate[0]) && pointYCoordinate [ypos] == yCoordinate[0]) {
			score++;
			SnakeLength++;
			xpos = randomNumber.nextInt(34);
			ypos = randomNumber.nextInt(23);
		}
		
		pointImage.paintIcon(this, graphic, pointXCoordinate[xpos], pointYCoordinate[ypos]);
		
		for (int i = 1; i < SnakeLength; i++) {
			if(xCoordinate[i] == xCoordinate[0] && yCoordinate[i] == yCoordinate[0]) {
				rightward = false;
				leftward = false;
				upward = false;
				downward = false;
				
				graphic.setColor(Color.BLACK);
				graphic.setFont(new Font("arial", Font.BOLD, 50));
				graphic.drawString("Game Over", 300, 300);
				
				graphic.setColor(Color.BLACK);
				graphic.setFont(new Font("arial", Font.BOLD, 20));
				graphic.drawString("Press Space to Restart", 350, 340);
			}
		}
		graphic.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if (rightward) {
			for (int r = SnakeLength-1; r>=0; r--) {
				yCoordinate[r+1] = yCoordinate[r];
			}
			for (int r = SnakeLength; r>=0; r--) {
				if (r==0) {
					xCoordinate[r] = xCoordinate[r] + 25;
					
				}
				else {
					xCoordinate[r] = xCoordinate[r-1];
				}
				if (xCoordinate[r] > 850 ) {
					xCoordinate[r] = 25;
				}
			}
			
			repaint();
		}
		if (leftward) {
			for (int r = SnakeLength-1; r>=0; r--) {
				yCoordinate[r+1] = yCoordinate[r];
			}
			for (int r = SnakeLength; r>=0; r--) {
				if (r==0) {
					xCoordinate[r] = xCoordinate[r] - 25;
					
				}
				else {
					xCoordinate[r] = xCoordinate[r-1];
				}
				if (xCoordinate[r] < 25 ) {
					xCoordinate[r] = 850;
				}
			}
			
			repaint();
			
		}
		if (upward) {
			for (int r = SnakeLength-1; r>=0; r--) {
				xCoordinate[r+1] = xCoordinate[r];
			}
			for (int r = SnakeLength; r>=0; r--) {
				if (r==0) {
					yCoordinate[r] = yCoordinate[r] - 25;
					
				}
				else {
					yCoordinate[r] = yCoordinate[r-1];
				}
				if (yCoordinate[r] < 75 ) {
					yCoordinate[r] = 625;
				}
			}
			
			repaint();
		}
		if (downward) {
			for (int r = SnakeLength-1; r>=0; r--) {
				xCoordinate[r+1] = xCoordinate[r];
			}
			for (int r = SnakeLength; r>=0; r--) {
				if (r==0) {
					yCoordinate[r] = yCoordinate[r] + 25;
					
				}
				else {
					yCoordinate[r] = yCoordinate[r-1];
				}
				if (yCoordinate[r] > 625 ) {
					yCoordinate[r] = 75;
				}
			}
			
			repaint();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			moves = 0;
			score = 0;
			SnakeLength = 3;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moves++;
			rightward = true;
			if (!leftward) {
				rightward = true;
			}
			else {
				rightward = false;
				leftward = true;
			}
			upward = false;
			downward = false;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			moves++;
			leftward = true;
			if (!rightward) {
				leftward = true;
			}
			else {
				leftward = false;
				rightward = true;
			}
			upward = false;
			downward = false;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			moves++;
			upward = true;
			if (!downward) {
				upward = true;
			}
			else {
				upward = false;
				downward = true;
			}
			leftward = false;
			rightward = false;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			moves++;
			downward = true;
			if (!upward) {
				downward = true;
			}
			else {
				downward = false;
				upward = true;
			}
			
			leftward = false;
			rightward = false;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}


