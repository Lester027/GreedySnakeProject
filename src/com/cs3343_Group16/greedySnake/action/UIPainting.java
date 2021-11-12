package com.cs3343_Group16.greedySnake.action;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.cs3343_Group16.greedySnake.model.Game;
import com.cs3343_Group16.greedySnake.system.SConstant;
import com.cs3346_Group16.greedySnake.service.impl.SnakeMoveDown;
import com.cs3346_Group16.greedySnake.service.impl.SnakeMoveLeft;
import com.cs3346_Group16.greedySnake.service.impl.SnakeMoveRight;
import com.cs3346_Group16.greedySnake.service.impl.SnakeMoveUp;
import com.cs3346_Group16.greedySnake.service.impl.UpdateDirectionDown;
import com.cs3346_Group16.greedySnake.service.impl.UpdateDirectionLeft;
import com.cs3346_Group16.greedySnake.service.impl.UpdateDirectionRight;
import com.cs3346_Group16.greedySnake.service.impl.UpdateDirectionUp;

public class UIPainting extends JPanel implements KeyListener, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1402638228577200390L;
	
	private Timer timer;
	private Game game = new Game();
	private String keyLock = SConstant.SC_DEFAULT_KEYBOARD_LOCK;

	public UIPainting() {
		addKeyListener(this);
		setFocusable(SConstant.SC_FOCUSABLE);
		setFocusTraversalKeysEnabled(SConstant.SC_FOCUS_TRAVERSAL_KEYS_ENABLED);
		timer = new Timer(SConstant.SC_TIME_DELAY, this);
		timer.start();
	}
	
	public void paint(Graphics graphic) {
		game.painting(graphic);
		if(GameMonitor.Monitor(game, graphic)) {
			timer.stop();
		}
		graphic.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		keyLock = SConstant.SC_DEFAULT_KEYBOARD_LOCK;
		timer.start();
		switch(game.getSnake().getDirection()) {
		case SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG:	new SnakeMoveRight().move(game.getSnake()); break;
		case SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG: 		new SnakeMoveDown().move(game.getSnake()); break;
		case SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG:	 	new SnakeMoveLeft().move(game.getSnake()); break;
		case SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG: 		new SnakeMoveUp().move(game.getSnake()); break;
		}
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(SConstant.SC_DEFAULT_KEYBOARD_LOCK.equals(keyLock)) {
			keyLock = SConstant.SC_UPDATED_KEYBOARD_LOCK;
			switch(e.getKeyCode()) {
			case KeyEvent.VK_DOWN: 	new UpdateDirectionDown().update(game.getSnake()); break;
			case KeyEvent.VK_LEFT: 	new UpdateDirectionLeft().update(game.getSnake()); break;
			case KeyEvent.VK_RIGHT: new UpdateDirectionRight().update(game.getSnake()); break;
			case KeyEvent.VK_UP:	new UpdateDirectionUp().update(game.getSnake()); break;
			case KeyEvent.VK_SPACE: timer.start(); break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	public String getKeyLock() {
		return keyLock;
	}

	public void setKeyLock(String keyLock) {
		this.keyLock = keyLock;
	}

}
