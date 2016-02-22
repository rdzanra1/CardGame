/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.cardgame.View;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.me.cardgame.Constans.GameConstans;
import com.me.cardgame.Model.Coordinate;

/**
 *
 * @author radoslaw.rdzanek
 */
public class PoolView {

    ShapeRenderer poolRenderer = new ShapeRenderer();
    public TextureAtlas atlas;
    public TextureAtlas.AtlasRegion atlasRegion;
    public Sprite cardSprite;

    public void drawPool() {

        poolRenderer.begin(ShapeRenderer.ShapeType.Line);
        poolRenderer.setColor(5, 2, 0, 0.5f);

        for (Coordinate coord : Coordinate.poolCoords()) {
            poolRenderer.rect(coord.drawPoolCoords().getXPos(), coord.drawPoolCoords().getYPos(),
                    GameConstans.POOL_CARD_SIZE_X, GameConstans.POOL_CARD_SIZE_Y);

        }

        poolRenderer.end();

    }

}
