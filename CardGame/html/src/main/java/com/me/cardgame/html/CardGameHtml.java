package com.me.cardgame.html;

import com.me.cardgame.core.CardGame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class CardGameHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new CardGame();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
