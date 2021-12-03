package com.cs3343_Group16.greedySnake.service.impl.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import com.cs3343_Group16.greedySnake.model.*;
import com.cs3343_Group16.greedySnake.service.KeyCommand;
import com.cs3343_Group16.greedySnake.service.impl.*;
import com.cs3343_Group16.greedySnake.system.SConstant;

import static org.junit.Assert.*;

public class TestPressUpKeyCommand {
	
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	public void testGetInstance() {
		KeyCommand p=PressUpKeyCommand.getInstance();
		assertEquals(PressUpKeyCommand.class,p.getClass());
	}

	@Test
	public void testExecute() {
		Game g=new Game();
		g.setMode(SConstant.SC_GAME_MODE_PlAYER);
		PressUpKeyCommand.getInstance().execute(g);
		
		assertEquals(SConstant.SC_SNAKE_MOVE_DIRECTION_UP_FLAG,g.getSnake().getDirection());
	}
}