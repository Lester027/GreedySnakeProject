package com.cs3343_Group16.greedySnake.system.test;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.cs3343_Group16.greedySnake.model.Background;
import com.cs3343_Group16.greedySnake.model.Snake;
import com.cs3343_Group16.greedySnake.model.details.AISnake;
import com.cs3343_Group16.greedySnake.model.details.DeathBean;
import com.cs3343_Group16.greedySnake.model.details.NormalBean;
import com.cs3343_Group16.greedySnake.model.details.PlayerSnake;
import com.cs3343_Group16.greedySnake.model.details.ScoreBean;
import com.cs3343_Group16.greedySnake.system.MapStatement;
import com.cs3343_Group16.greedySnake.system.SConstant;

public class TestMapStatement {
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@AfterEach
	public void tearDown() throws Exception {
	    AISnake.getInstance().initial();
	    PlayerSnake.getInstance().initial();
	}
	
	@Test
	public void testInitialization() {
		MapStatement m= MapStatement.getInstance();
		m.initRecord();
		String[][] result= new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				result[i][j] = SConstant.SC_MAP_RECORD_NULL;
			}
		}
		
		assertArrayEquals(result,m.getRecords());
	}
	
	
	@Test
	public void testUpdateStatus_1() {
		Snake snake= (Snake)PlayerSnake.getInstance();
		MapStatement m= MapStatement.getInstance();
		m.initRecord();
		m.updateStatus(snake, SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS, SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS);
		
		String[][] records=m.getRecords();
		assertEquals(SConstant.SC_MAP_RECORD_SNAKE,records[0][0]);
	}
	
	@Test
	public void testUpdateStatus_2() {
		AISnake asnake= AISnake.getInstance();
		
		MapStatement m= MapStatement.getInstance();
		m.initRecord();
		m.updateStatus(asnake, SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS, SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS);
		
		String[][] records=m.getRecords();
		assertEquals(SConstant.SC_MAP_RECORD_AI_SNAKE,records[0][0]);
	}
	
	@Test
	public void testUpdateStatus_3() {
		NormalBean nBean= NormalBean.getInstance();
		
		MapStatement m= MapStatement.getInstance();
		m.initRecord();
		m.updateStatus(nBean, SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS, SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS);
		
		String[][] records=m.getRecords();
		assertEquals(SConstant.SC_MAP_RECORD_BEAN,records[0][0]);
	}
	
	@Test
	public void testUpdateStatus_4() {
		ScoreBean sBean= ScoreBean.getInstance();
		
		MapStatement m= MapStatement.getInstance();
		m.initRecord();
		m.updateStatus(sBean, SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS, SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS);
		
		String[][] records=m.getRecords();
		assertEquals(SConstant.SC_MAP_RECORD_BEAN,records[0][0]);
	}
	
	@Test
	public void testUpdateStatus_5() {
		DeathBean dBean= DeathBean.getInstance();
		
		MapStatement m= MapStatement.getInstance();
		m.initRecord();
		m.updateStatus(dBean, SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS, SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS);
		
		String[][] records=m.getRecords();
		assertEquals(SConstant.SC_MAP_RECORD_BEAN,records[0][0]);
	}
	
	@Test
	public void testUpdateStatus_6() {
		Background b= Background.getInstance();
		
		MapStatement m= MapStatement.getInstance();
		m.initRecord();
		m.updateStatus(b, SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_XPOS, SConstant.SC_GAMEBODY_BACKGROUND_BEGIN_YPOS);
		
		String[][] records=m.getRecords();
		assertEquals(SConstant.SC_MAP_RECORD_NULL,records[0][0]);
	}
	
	@Test
	public void testSetRecords() {
		String[][] result= new String[SConstant.SC_MAP_X_AXIS_CAPACITY][SConstant.SC_MAP_Y_AXIS_CAPACITY];
		for (int i = 0; i < SConstant.SC_MAP_X_AXIS_CAPACITY; i++) {
			for (int j = 0; j < SConstant.SC_MAP_Y_AXIS_CAPACITY; j++) {
				result[i][j] = "test";
			}
		}
		
		MapStatement m= MapStatement.getInstance();
		m.initRecord();
		m.setRecords(result);
		String[][] records=m.getRecords();
		
		assertArrayEquals(result,records);
		
	}
}
