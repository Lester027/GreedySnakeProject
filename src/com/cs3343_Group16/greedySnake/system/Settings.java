package com.cs3343_Group16.greedySnake.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Settings extends JPanel implements KeyListener, ActionListener{
	private ArrayList<int[]> xCoordinate = new ArrayList<int[]>(750);
	private ArrayList<int[]> yCoordinate = new ArrayList<int[]>(750);
	
	private boolean leftward = false;
	private boolean rightward = false;
	private boolean upward = false;
	private boolean downward = false;
	
	private ImageIcon upMouth;
	private ImageIcon downMouth;
	private ImageIcon leftMouth;
	private ImageIcon rightMouth;
	
	
	private Timer timer;
	private int delay = 100;
	private ImageIcon snake;
	
	private ImageIcon headerImg;
	public Settings () {
		
	}
	
	public void paint(Graphics graphic) {
		graphic.setColor(Color.WHITE);
		graphic.drawRect(24, 10 ,851, 55);
		
		//Title
		headerImg = new ImageIcon("Image/title.png");
		headerImg.paintIcon(this, graphic, 25, 11);
		
		//Border
		graphic.setColor(Color.WHITE);
		graphic.drawRect(24, 74, 851, 577);
		
		//Background
		graphic.setColor(Color.BLACK);
		graphic.fillRect(25, 75, 850, 575);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
