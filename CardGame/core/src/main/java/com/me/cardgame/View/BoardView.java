package com.me.cardgame.View;

import com.badlogic.gdx.Gdx;
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
import com.me.cardgame.Model.SelectedCards;
import java.util.ArrayList;
import java.util.List;

//STWORZYC METODE DO RYSOWANIA KART NA STOLE, CZYLI ODSWIEZANIA STOLU JEZELI NA STOLE POJAWI SIE KARTA 
public class BoardView {

    ShapeRenderer tableRenderer = new ShapeRenderer();
    ShapeRenderer testLine = new ShapeRenderer();
    ShapeRenderer startCardsRenderer = new ShapeRenderer();

    // BoardMap boardMap = new BoardMap();
    // public int BoardXpixels[] = boardMap.getBoardXpixels();
    // public int BoardYpixels[] = boardMap.getBoardYpixels();
    // public int cardSizeX = Gdx.graphics.getWidth()/32;
    // public int cardSizeY= Gdx.graphics.getHeight()/12;
    public TextureAtlas atlas;
    public AtlasRegion atlasRegion;
    public Sprite cardSprite;

    public void drawBoard() {

        tableRenderer.begin(ShapeType.Line);
        tableRenderer.setColor(1, 2, 0, 0.5f);

        for (Coordinate coord : Coordinate.allCoords()) {

            tableRenderer.rect(coord.drawCoords().getXPos(), coord.drawCoords().getYPos(), GameConstans.CARD_SIZE_X,
                    GameConstans.CARD_SIZE_Y);

        }

        tableRenderer.end();

    }

    public void renderBoardCards(Board board) {

    }

    public void renderCards(Board board, SpriteBatch batch) {

        if (atlas == null) {

            atlas = Assets.instance.getAtlas();
        }

        // for (int k = 0; k < 10; k++) {
        // for (int i = 0; i < 16; i++) {
        for (Coordinate coord : Coordinate.allCoords()) {
            if (board.getBoard().get(coord) != null) {
                if (board.getBoard().get(coord).getIsReversed()
                        && board.getBoard().get(coord).getCardType() == CardTypeEnum.end) {
                    atlasRegion = atlas.findRegion(EndCard.getCardBackTexture());

                } else {

                    atlasRegion = atlas.findRegion(board.getBoard().get(coord).getCardTexture());
                }

                cardSprite = new Sprite(atlasRegion);

                cardSprite.setPosition(coord.drawCoords().getXPos(), coord.drawCoords().getYPos());

                //
                // cardSprite.setPosition(BoardXpixels[board.xIndex(board.getBoard().get(coord).getCardTexture())],
                // BoardYpixels[board.yIndex(board.getBoard().get(coord).getCardTexture())]);
                cardSprite.setSize(GameConstans.CARD_SIZE_X, GameConstans.CARD_SIZE_Y);

                if (board.getBoard().get(coord).getIsRotated()) {

                    cardSprite.flip(false, true);
                    cardSprite.draw(batch);
                } else {

                    cardSprite.draw(batch);
                }

            }
        }

    }

    public void ligthCell(ArrayList<Coordinate> list, ShapeRenderer cellRenderer) {

         //ShapeRenderer cellRenderer = new ShapeRenderer();
         cellRenderer.begin(ShapeType.Filled);
         cellRenderer.setColor(Color.YELLOW);
         
        for (int i = 0; i < list.size(); i++) {
           //cellRenderer.
           cellRenderer.rect(list.get(i).drawCoords().getXPos(), list.get(i).drawCoords().getYPos(), GameConstans.CARD_SIZE_X,
                    GameConstans.CARD_SIZE_Y);
        }
        cellRenderer.end();
    }

    
}
