package com.cs3343_Group16.greedySnake.system;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Settings extends JPanel{
	private ImageIcon headerImg;
	
	public Settings () {
		
	}
	
	public void paint(Graphics graphic) {
		graphic.setColor(Color.white);
		graphic.drawRect(24, 10 ,851, 55);
		
		//Title
		headerImg = new ImageIcon("Image/title.png");
		headerImg.paintIcon(this, graphic, 25, 11);
		
		//Border
		graphic.setColor(Color.WHITE);
		graphic.drawRect(24, 74, 851, 577);
		
		//Background
		graphic.setColor(Color.black);
		graphic.fillRect(25, 75, 850, 575);
	}
}
