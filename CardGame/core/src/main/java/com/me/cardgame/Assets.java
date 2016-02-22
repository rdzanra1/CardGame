package com.me.cardgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable, AssetErrorListener {

	public static final String TAG = Assets.class.getName();
	public static final Assets instance = new Assets();
       // public static  BitmapFont font = new BitmapFont();
	private AssetManager assetManager;

	public TextureAtlas atlas;


	private Assets() {
		init();
	}

	public void init() {

		
		
		this.assetManager = new AssetManager();
		// set asset manager error handler
		assetManager.setErrorListener(this);
		// load texture atlas
		assetManager.load("saboteur_cards.pack", TextureAtlas.class);
               // assetManager.load("blackFont.fnt", BitmapFont.class);
		// start loading assets and wait until finished
		assetManager.finishLoading();
//		Gdx.app.debug(TAG, "# of assets loaded: " + assetManager.getAssetNames().size);
//		for (String a : assetManager.getAssetNames())
//			Gdx.app.debug(TAG, "asset: " + a);
            
		atlas = assetManager.get("saboteur_cards.pack");
               // font = assetManager.get("blackFont.fnt");
                
                
		for (Texture t : atlas.getTextures()) {
			t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}

	}

	@Override
	public void dispose() {
		assetManager.dispose();

	}



	public TextureAtlas getAtlas() {
		return atlas;
	}

	@Override
	public void error(AssetDescriptor asset, Throwable throwable) {
		// TODO Auto-generated method stub

	}

}