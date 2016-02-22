package com.me.cardgame.View;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.me.cardgame.Assets;
import com.me.cardgame.Constans.GameConstans;
import com.me.cardgame.Enums.CardTypeEnum;
import com.me.cardgame.Model.Board;
import com.me.cardgame.Model.Coordinate;
import com.me.cardgame.Model.EndCard;
import com.me.cardgame.Model.Hand;

//STWORZYC METODE DO RYSOWANIA KART NA STOLE, CZYLI ODSWIEZANIA STOLU JEZELI NA STOLE POJAWI SIE KARTA 

public class HandView {

	ShapeRenderer handRenderer = new ShapeRenderer();
	public TextureAtlas atlas;
	public AtlasRegion atlasRegion;
	public Sprite cardSprite;

	public void drawHand() {

		handRenderer.begin(ShapeType.Line);
		handRenderer.setColor(1, 2, 0, 0.5f);

		for (Coordinate coord : Coordinate.handCoords()) {
			handRenderer.rect(coord.drawHandCoords().getXPos(), coord.drawHandCoords().getYPos(),
					GameConstans.HAND_CARD_SIZE_X, GameConstans.HAND_CARD_SIZE_Y);

		}

		handRenderer.end();

	}

	// STWORZYC HAND WRAPPER i DOKONCZYC WYSTWIETLANIE KART

	public void renderHandCards(Hand hand, SpriteBatch batch) {

		if (atlas == null) {

			atlas = Assets.instance.getAtlas();
		}
		//
		for (int i = 0; i < hand.getHand().size(); i++) {
			if (!hand.getHand().isEmpty()) {
				//

				atlasRegion = atlas.findRegion(hand.getCard(i).getCardTexture());

                                                                
				cardSprite = new Sprite(atlasRegion);
				cardSprite.setPosition((int) (GameConstans.HAND_X_OFFSET + (GameConstans.HAND_CARD_SIZE_X * i)),
                                                       (int) (GameConstans.HAND_Y_OFFSET));

				cardSprite.setSize(GameConstans.HAND_CARD_SIZE_X, GameConstans.HAND_CARD_SIZE_Y);
				
                                if (hand.getCard(i).getIsMarked()) {
                                    cardSprite.setPosition((int) (GameConstans.HAND_X_OFFSET + (GameConstans.HAND_CARD_SIZE_X * i)),
						(int) (GameConstans.HAND_Y_SELECTED_OFFSET));
                                    cardSprite.draw(batch);
                                } else {
                                    cardSprite.draw(batch);
                                }
				

			}
		}
	}

}
