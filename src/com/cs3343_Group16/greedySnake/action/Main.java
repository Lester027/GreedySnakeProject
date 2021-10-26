package com.cs3343_Group16.greedySnake.action;

import java.awt.Color;

import javax.swing.JFrame;

import com.cs3343_Group16.greedySnake.system.Settings;

public class Main {

	public static void main(String[] args) {
		JFrame obj = new JFrame();
		Settings gameSetting = new Settings ();
		
		obj.setBounds(10, 10, 905, 700);
		obj.setBackground(Color.BLACK);
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gameSetting);
	}
}
