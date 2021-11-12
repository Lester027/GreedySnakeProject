package com.cs3343_Group16.greedySnake.system;

import java.awt.Color;

import javax.swing.JFrame;

import com.cs3343_Group16.greedySnake.action.UIPainting;

public class Main {
	public static void main(String[] args) {
		JFrame obj = new JFrame();
		
		UIPainting ui = new UIPainting ();
		
		obj.setTitle(SConstant.SC_GAME_TITLE);
		obj.setBounds(SConstant.SC_JFRAME_BOUNDS_LENGTH, SConstant.SC_JFRAME_BOUNDS_LENGTH, SConstant.SC_JFRAME_BOUNDS_WIDTH, SConstant.SC_JFRAME_BOUNDS_HEIGHT);
		obj.setBackground(Color.LIGHT_GRAY);
		obj.setResizable(SConstant.SC_JFRAME_NOREIZEABLE);
		obj.setVisible(SConstant.SC_JFARME_VISIBLE);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(ui);
	}
}
