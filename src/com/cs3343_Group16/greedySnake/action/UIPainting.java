package com.cs3343_Group16.greedySnake.action;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.cs3343_Group16.greedySnake.model.Game;
import com.cs3343_Group16.greedySnake.model.details.AISnake;
import com.cs3343_Group16.greedySnake.service.SnakeMove;
import com.cs3343_Group16.greedySnake.service.impl.Press1KeyCommand;
import com.cs3343_Group16.greedySnake.service.impl.Press2KeyCommand;
import com.cs3343_Group16.greedySnake.service.impl.PressDownKeyCommand;
import com.cs3343_Group16.greedySnake.service.impl.PressLeftKeyCommand;
import com.cs3343_Group16.greedySnake.service.impl.PressRightKeyCommand;
import com.cs3343_Group16.greedySnake.service.impl.PressUpKeyCommand;
import com.cs3343_Group16.greedySnake.service.impl.SnakeMoveDown;
import com.cs3343_Group16.greedySnake.service.impl.SnakeMoveLeft;
import com.cs3343_Group16.greedySnake.service.impl.SnakeMoveRight;
import com.cs3343_Group16.greedySnake.service.impl.SnakeMoveUp;
import com.cs3343_Group16.greedySnake.system.MapStatement;
import com.cs3343_Group16.greedySnake.system.SConstant;
import com.cs3343_Group16.greedySnake.util.GameMonitor;

public class UIPainting extends JPanel implements KeyListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1402638228577200390L;

	private Timer timer;
	private Game game;
	private String keyLock = SConstant.SC_DEFAULT_KEYBOARD_LOCK;
	private SnakeMove snakemove;

	public UIPainting() {
		addKeyListener(this);
		setFocusable(SConstant.SC_FOCUSABLE);
		setFocusTraversalKeysEnabled(SConstant.SC_FOCUS_TRAVERSAL_KEYS_ENABLED);
		timer = new Timer(SConstant.SC_DEFAULT_TIME_DELAY, this);
		timer.start();
		game=new Game();
	}
	
	public UIPainting(Game g) {
		addKeyListener(this);
		setFocusable(SConstant.SC_FOCUSABLE);
		setFocusTraversalKeysEnabled(SConstant.SC_FOCUS_TRAVERSAL_KEYS_ENABLED);
		timer = new Timer(SConstant.SC_DEFAULT_TIME_DELAY, this);
		timer.start();
		game=g;
	}

	public void paint(Graphics graphic) {
		game.painting(graphic);
		if (GameMonitor.Monitor(game, graphic)) {
			timer.stop();
		}
		graphic.dispose();
	}

	public void setSnakemove(String direction) {
		switch (direction) {
		case SConstant.SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG:
			snakemove=new SnakeMoveRight();
			break;
		case SConstant.SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG:
			snakemove=new SnakeMoveDown();
			break;
		case SConstant.SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG:
			snakemove=new SnakeMoveLeft();
			break;
		case SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG:
			snakemove=new SnakeMoveUp();
			break;
		}
	}
	
	public SnakeMove getSnakemove() {
		return snakemove;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		keyLock = SConstant.SC_UPDATED_KEYBOARD_LOCK;
		timer.start();
		if (!SConstant.SC_GAME_MODE_DEFAULT.equals(game.getMode())) {
			if (SConstant.SC_GAME_MODE_AI.equals(game.getMode())) {
				timer.setDelay(SConstant.SC_DEFAULT_TIME_DELAY);
				MapStatement.getInstance().initRecord();
				game.getSnake().updateMapStatus();
				game.getBean().updateMapStatus();
				game.getSnake().setDirection(SnakeSelfAutoMove.thinkAndMove(((AISnake) game.getSnake()), game.getBean(),
						game.getSnake().getDirection()));
			}if(SConstant.SC_GAME_MODE_PlAYER.equals(game.getMode())) {
				setPlayerSpeedByScore(game);
			}
			
			setSnakemove(game.getSnake().getDirection());
			if(snakemove!=null) {
				snakemove.move(game.getSnake());
			}	
		}

		repaint();
	}
	
	public void setPlayerSpeedByScore(Game game) {
		if(game.getSnake().getScore() == 0) {
			timer.setDelay(SConstant.SC_PLAYER_TIME_DELAY);
		}else {
			if(game.getSnake().getScore() % 300 == 0) {
				timer.setDelay(timer.getDelay() - 30);
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (SConstant.SC_GAME_MODE_DEFAULT.equals(game.getMode())
				|| SConstant.SC_GAME_MODE_PlAYER.equals(game.getMode())) {
			keyLock = SConstant.SC_DEFAULT_KEYBOARD_LOCK;
		} else {
			keyLock = SConstant.SC_UPDATED_KEYBOARD_LOCK;
		}
		if (SConstant.SC_DEFAULT_KEYBOARD_LOCK.equals(keyLock)) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_1:
				Press1KeyCommand.getInstance().execute(game);
				break;
			case KeyEvent.VK_2:
				Press2KeyCommand.getInstance().execute(game);
				break;
			case KeyEvent.VK_DOWN:
				PressDownKeyCommand.getInstance().execute(game);
				break;
			case KeyEvent.VK_LEFT:
				PressLeftKeyCommand.getInstance().execute(game);
				break;
			case KeyEvent.VK_RIGHT:
				PressRightKeyCommand.getInstance().execute(game);
				break;
			case KeyEvent.VK_UP:
				PressUpKeyCommand.getInstance().execute(game);
				break;
			case KeyEvent.VK_SPACE:
				timer.start();
				break;
			}
		}
			
	}

	public int getTimeDelay() {
		return timer.getDelay();
	}

	public String getKeyLock() {
		return keyLock;
	}

	public void setKeyLock(String keyLock) {
		this.keyLock = keyLock;
	}

	
	public boolean getTimerStatus() {
		return timer.isRunning();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
