package com.me.cardgame;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.me.cardgame.CardGameEngine;
import com.me.cardgame.CardGameMain;
import com.badlogic.gdx.ai.pfa.Graph;




public class Main {
	
	
		
	public static void main(String[] args) {
     LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Card Game Engine "  + CardGameEngine.Wersja;
		cfg.useGL30 = false;
		//cfg.vSyncEnabled = true;
		cfg.width = 1600;
		cfg.height = 900;
		cfg.fullscreen = false;

	
		
		//new LwjglApplication(new CardGameEngine(), cfg);
		
		
		new LwjglApplication(new CardGameMain(), cfg);
		
		

	}
}