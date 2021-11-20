package com.cs3343_Group16.greedySnake.system;

//System Setting Constant
public class SConstant {
	// background variable setting
	public final static int SC_JFRAME_BOUNDS_WIDTH = 1320;
	public final static int SC_JFRAME_BOUNDS_HEIGHT = 825;
	public final static int SC_JFRAME_BOUNDS_LENGTH = 10;
	public final static boolean SC_JFRAME_NOREIZEABLE = false;
	public final static boolean SC_JFARME_VISIBLE = true;

	// Title & background & background border variable setting
	public final static int SC_TITLE_BACKGOURND_BORDER_BEGIN_XPOS = 19;
	public final static int SC_TITLE_BACKGROUND_BORDER_BEGIN_YPOS = 9;
	public final static int SC_TITLE_BACKGOURND_BORDER_WIDTH = 1282;
	public final static int SC_TITLE_BACKGOURND_BORDER_HEIGHT = 62;
	public final static int SC_TITLE_BACKGROUND_BEGIN_XPOS = 20;
	public final static int SC_TITLE_BACKGROUND_BEGIN_YPOS = 10;
	public final static int SC_TITLE_BACKGROUND_WIDTH = 1280;
	public final static int SC_TITLE_BACKGROUND_HEIGHT = 60;
	public final static int SC_TITLE_BEGIN_XPOS = 120;
	public final static int SC_TITLE_BEGIN_YPOS = 55;
	public final static int SC_TITLE_FONT_SIZE = 36;

	// game body border & background setting
	public final static int SC_GAMEBODY_BORDER_BEGIN_XPOS = 19;
	public final static int SC_GAMEBODY_BORDER_BEGIN_YPOS = 79;
	public final static int SC_GAMEBODY_BORDER_WIDTH = 1282;
	public final static int SC_GAMEBODY_BORDER_HEIGHT = 702;
	public final static int SC_GAMEBODY_BACKGROUND_BEGIN_XPOS = 20;
	public final static int SC_GAMEBODY_BACKGROUND_BEGIN_YPOS = 80;
	public final static int SC_GAMEBODY_BACKGROUND_WIDTH = 1280;
	public final static int SC_GAMEBODY_BACKGROUND_HEIGHT = 700;

	// game information setting
	public final static int SC_SCORE_BEGIN_XPOS = 1075;
	public final static int SC_SCORE_BEGIN_YPOS = 30;
	public final static int SC_LENGTH_BEGIN_XPOS = 1075;
	public final static int SC_LENGTH_BEGIN_YPOS = 60;

	// game display default font setting;
	public final static String SC_FONT_THEME = "Lucida Handwriting";
	public final static int SC_DEFAULT_FONT_SIZE = 16;

	// Bean & Snake common setting
	public final static int SC_DEFAULT_NODE_SIZE = 20;
	public final static int SC_INIT_MAX_AVAIL_COORDINATE_AMOUNT = 2500;
	public final static int SC_INIT_COORDINATE_CAPACITY = 2;
	public final static int SC_COORDINATE_XPOS_KEY = 0;
	public final static int SC_COORDINATE_YPOS_KEY = 1;
	public final static int SC_INIT_COORDINATE_VALUE = -1;
	
	// Common Map Setting
	public final static int SC_MAP_X_AXIS_CAPACITY = 64;
	public final static int SC_MAP_Y_AXIS_CAPACITY = 35;
	public final static String SC_MAP_RECORD_NULL = " ";
	public final static String SC_MAP_RECORD_SNAKE = "snake";
	public final static String SC_MAP_RECORD_AI_SNAKE = "aiSnake";
	public final static String SC_MAP_RECORD_BEAN = "bean";
	public final static String SC_MAP_RECORD_PRESERVED = "preserved";

	// Common Bean settings
	public final static int SC_DEFAULT_BEAN_SCORE = 1;
	public final static int SC_SCORE_BEAN_SCORE = 3;
	public final static int SC_DEATH_BEAN_SCORE = -5;

	// Advanced Score Bean Settings
	public final static int SC_SCORE_BEAN_DEFAULT_APPEAR_TIME = 300;
	public final static int SC_SCORE_BEAN_DEFAULT_DISAPPEAR_TIME = 50;

	// Common Snake Setting
	public final static int SC_INIT_SNAKE_LENGTH = 3;
	public final static int SC_INIT_SNAKE_HEAD_XPOS = 60;
	public final static int SC_INIT_SNAKE_HEAD_YPOS = 80;
	public final static int SC_SNAKE_AVAIL_MAX_XPOS = 1280;
	public final static int SC_SNAKE_AVAIL_MAX_YPOS = 760;
	public final static String SC_SNAKE_MOVE_DIRECTION_DEFAULT_FLAG = "Rightward";
	public final static String SC_SNAKE_MOVE_DIRECTION_DOWN_FLAG = "Downward";
	public final static String SC_SNAKE_MOVE_DIRECTION_LEFT_FLAG = "Leftward";
	public final static String SC_SNAKE_MOVE_DIRECTION_UP_FLAG = "Upward";
	public final static String SC_SNAKE_MOVE_DIRECTION_DEATH_FLAG = " ";
	
	// Advanced AI Snake Setting
	public final static int SC_INIT_AI_SNAKE_HEAD_XPOS = 60;
	public final static int SC_INIT_AI_SNAKE_HEAD_YPOS = 760;
	
	//Advanced Snake Node Setting
	public final static int SC_SNAKE_NODE_DEFAULT_SCORE_VALUE = 1000000000 + 7;
	public final static int SC_SNAKE_NODE_DEFAULT_INIT_VALUE = 0;

	// Game setting
	public final static String SC_GAME_TITLE = "CS3343 Group16 Project Greedy Snake";
	public final static boolean SC_FOCUSABLE = true;
	public final static boolean SC_FOCUS_TRAVERSAL_KEYS_ENABLED = false;
	public final static String SC_DEFAULT_KEYBOARD_LOCK = "unlocked";
	public final static String SC_UPDATED_KEYBOARD_LOCK = "locked";
	public final static String SC_GAME_MODE_DEFAULT = " "; 
	public final static String SC_GAME_MODE_PlAYER = "player";
	public final static String SC_GAME_MODE_AI = "AI";
	public final static int SC_TIME_DELAY = 1;
	public final static int SC_GAME_HINT_FONT_SIZE = 50;
	public final static int SC_GAME_ASSIST_HINT_FONT_SIZE = 20;
	public final static String SC_GAME_HINT_MODE_CHOOSE = "CHOOSE ONE MODE";
	public final static String SC_GAME_HINT_MODE_CHOOSE_ASSIST_1 = "Press 1 to choose Player Mode";
	public final static String SC_GAME_HINT_MODE_CHOOSE_ASSIST_2 = "Press 2 to choose AI self move Mode";
 	public final static String SC_GAME_HINT_GAME_START = "START GAME";
	public final static String SC_GAME_HINT_START_ASSIST_1 = "Press Any Arrow Keys to Start";
	public final static String SC_GAME_HINT_GAME_OVER = "GAME OVER";
	public final static String SC_GAME_HINT_RESTART_ASSIST = "Press Space to Restart";
	public final static String SC_GAME_HINT_START_ASSIST_2 = "Then Press Any Arrow Keys to Move Your Snake";
	public final static int SC_HINT_GAME_MODE_CHOOSE_BEGIN_XPOS = 350;
	public final static int SC_HINT_GAME_MODE_CHOOSE_BEGIN_YPOS = 400;
	public final static int SC_HINT_GAME_MODE_CHOOSE_ASSIST_1_BEGIN_XPOS = 450;
	public final static int SC_HINT_GAME_MODE_CHOOSE_ASSIST_1_BEGIN_YPOS = 440;
	public final static int SC_HINT_GAME_MODE_CHOOSE_ASSIST_2_BEGIN_XPOS = 450;
	public final static int SC_HINT_GAME_MODE_CHOOSE_ASSIST_2_BEGIN_YPOS = 480;
	public final static int SC_HINT_GAME_START_BEGIN_XPOS = 450;
	public final static int SC_HINT_GAME_START_BEGIN_YPOS = 400;
	public final static int SC_HINT_GAME_START_ASSIST_1_BEGIN_XPOS = 470;
	public final static int SC_HINT_GAME_START_ASSIST_1_BEGIN_YPOS = 440;
	public final static int SC_HINT_GAME_START_ASSIST_2_BEGIN_XPOS = 300;
	public final static int SC_HINT_GAME_START_ASSIST_2_BEGIN_YPOS = 480;
	public final static int SC_HINT_GAME_OVER_BEGIN_XPOS = 400;
	public final static int SC_HINT_GAME_OVER_BEGIN_YPOS = 400;
	public final static int SC_HINT_GAME_RESTART_ASSIST_BEGIN_XPOS = 450;
	public final static int SC_HINT_GAME_RESTART_ASSIST_BEGIN_YPOS = 440;
}
