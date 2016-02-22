package com.me.cardgame.Renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Disposable;
import com.me.cardgame.Controller.GameConrtoller;

public class GameRenderer implements Disposable {

	private SpriteBatch batch;
	private GameConrtoller gameController;
        private ShapeRenderer shapeRenderer = new ShapeRenderer();
        
	private BitmapFont font;

	public GameRenderer(GameConrtoller gameController) {

		this.gameController = gameController;
		init();

	}

	public void renderGame() {

		batch.begin();

		gameController.boardView.drawBoard();
		gameController.handView.drawHand();
                gameController.poolView.drawPool();
                

                if (!gameController.possiblePlaces.isEmpty()) {
                    gameController.boardView.ligthCell(gameController.possiblePlaces,shapeRenderer);
                }
                
                
		batch.end();

		try {
			Thread.sleep(15);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		batch.begin();

                // RYSOWANIE KART KRANOSLUDOW DO POPRAWY, MEMORY LEAK
                //gameController.playerView.playerTypeDraw(batch,gameController.currentPlayer.getPlayerType());
                 //gameController.playerView.playerBackDraw(batch);
		gameController.boardView.renderCards(gameController.board, batch);
		//gameController.handView.renderHandCards(gameController.getPlayerList.getPlayerHand(), batch);
		gameController.handView.renderHandCards(gameController.currentPlayer.getPlayerHand(), batch);
                
                
		if (gameController.zoomCard != null ) {
			if(gameController.tmpCard != null )  {
				gameController.cardView.zoomCard(gameController.tmpCard, batch);
			}
			else  gameController.cardView.zoomCard(gameController.zoomCard, batch);
		
		}
		//gameController.cardView.zoomCard(gameController.getPlayerList().get(0).getPlayerHand().getCard(gameController.c));
		
	
		
		batch.end();

               
                
		batch.begin();
                
                if (gameController.currentPlayer != null ) {
                    
                     font.draw(batch, gameController.currentPlayer.getName(), 300, 180);
                     font.draw(batch, gameController.anotherPlayer.getName(), 1000, 500);
                     
                } 
		font.draw(batch, "LEGENDA", 1000, 850);
		font.draw(batch, "1. A - Play action card", 1000, 800);
		font.draw(batch, "2. T - Play tunnel card", 1000, 775);
		font.draw(batch, "3. D - Discard card", 1000, 750);
                font.draw(batch, "4. ENTER - Confirm action", 1000, 725);
                font.draw(batch, "5. BACKSPACE - Cancel last action", 1000, 700);

		batch.end();
                
                
                //batch.begin();
       
               // batch.end();

	}

	private void init() {
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("blackFont.fnt"), false);
                 font.setScale(0.75f);
	}

	public void render() {
		renderGame();

		// System.out.println(Gdx.graphics.getHeight()); -

	}

	public void resize(int width, int height) {



	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
