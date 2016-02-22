package com.me.cardgame.View;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.me.cardgame.Assets;
import com.me.cardgame.Constans.GameConstans;
import com.me.cardgame.Model.GameCard;
import com.me.cardgame.Model.PlacedTunnelCard;
import com.me.cardgame.Model.TunnelCard;

public class CardView {

	private SpriteBatch batch = new SpriteBatch();
	private TextureAtlas atlas;
	private AtlasRegion atlasRegion;
	private Sprite cardSprite;

	public CardView() {
		
	}
	
	
	
	public void zoomCard(PlacedTunnelCard placedTunnelCard, SpriteBatch batch) {
		if (atlas == null) {

			atlas = Assets.instance.getAtlas();
		}
		
		atlasRegion = atlas.findRegion(placedTunnelCard.getCardTexture());
		
		cardSprite = new Sprite(atlasRegion);
		cardSprite.setPosition(1000, 100);
		cardSprite.setSize(GameConstans.HAND_CARD_SIZE_X * 2, GameConstans.HAND_CARD_SIZE_Y * 2);
		
		if (placedTunnelCard.getIsRotated()) {
			cardSprite.flip(true, true);
		}
			
		cardSprite.draw(batch);
	}
		
		

	
	

	public void zoomCard(GameCard gameCard,  SpriteBatch batch) {


		if (atlas == null) {

			atlas = Assets.instance.getAtlas();
		}
			
		atlasRegion = atlas.findRegion(gameCard.getCardTexture());
		
		
		
		cardSprite = new Sprite(atlasRegion);
		cardSprite.setPosition(1000, 100);
		cardSprite.setSize(GameConstans.HAND_CARD_SIZE_X * 2, GameConstans.HAND_CARD_SIZE_Y * 2);
		cardSprite.draw(batch);
	}

	

	
	
	
	
	public void flipCard(GameCard gameCard, SpriteBatch batch) {
		
		
		cardSprite.flip(true, true);
		cardSprite.draw(batch);
	}
	
	
}
