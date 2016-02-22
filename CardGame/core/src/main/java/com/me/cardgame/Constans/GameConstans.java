package com.me.cardgame.Constans;

import com.badlogic.gdx.Gdx;

public class GameConstans {

	// BOARD CONSTANS

	public static Integer BOARD_X_OFFSET = 10;
	public static Integer BOARD_Y_OFFSET = 200;

	public static Integer BOARD_OFFSET_X_SCALE = 160;
	public static Double BOARD_OFFSET_Y_SCALE = 4.5;

	public static Integer BOARD_CARD_X_SCALE = 32;
	public static Integer BOARD_CARD_Y_SCALE = 12;

	public static Integer CARD_SIZE_X = Gdx.graphics.getWidth() / 32;
	public static Integer CARD_SIZE_Y = Gdx.graphics.getHeight() / 12;

        //PLAYER CONSTANS
        
        public static Integer PLAYER_SIZE_X = 140;
	public static Integer PLAYER_SIZE_Y = 180;
        public static Integer OPPONET_POS_X = 1000;
        public static Integer OPPONET_POS_Y = 300;
        
        
	// HAND COSTANS

	public static Integer HAND_X_OFFSET = 160;
	public static Integer HAND_Y_OFFSET = 10;
        public static Integer HAND_Y_SELECTED_OFFSET = 35;
        
	public static Integer HAND_CARD_SIZE_X = 80;
	public static Integer HAND_CARD_SIZE_Y = 120;

	public static Integer HAND_OFFSET_X_SCALE = 10;
	public static Integer HAND_OFFSET_Y_SCALE = 90;

	public static Integer HAND_CARD_X_SCALE = 20;
	public static Double HAND_CARD_Y_SCALE = 7.5;

	public static Integer HAND_SIZE_Y = 0;
	public static Integer HAND_SIZE = 6;

	public static Integer BOARD_SIZE_X = 16;
	public static Integer BOARD_SIZE_Y = 9;

        public static Integer MAX_CARD_SELECTED = 3;
        
        
        //POOL CONSTANS
        
        
        public static Integer POOL_SIZE = 4;
        public static Integer POOL_X_OFFSET = 800;
        public static Integer POOL_Y_OFFSET = 10;
        public static Integer POOL_CARD_SIZE_X = 40;
        public static Integer POOL_CARD_SIZE_Y = 60;
                
	private GameConstans() {

	}

}
