package com.me.cardgame;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.me.cardgame.Controller.GameConrtoller;
import com.me.cardgame.Renderer.GameRenderer;

public class CardGameMain implements ApplicationListener {

	private GameConrtoller gameController;
	private GameRenderer gameRenderer;


	@Override
	public void create() {

		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		// Assets.instance.init(new AssetManager());

		gameController = new GameConrtoller();
		gameRenderer = new GameRenderer(gameController);

	}

	@Override
	public void resize(int width, int height) {

		gameRenderer.resize(width, height);

	}

	@Override
	public void render() {

		gameController.update(Gdx.graphics.getDeltaTime());

		Gdx.gl.glClearColor(0x64 / 255.0f, 0x95 / 255.0f, 0xed / 255.0f, 0xff / 255.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		gameRenderer.render();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {

		gameRenderer.dispose();

		Assets.instance.dispose();
	}

}
