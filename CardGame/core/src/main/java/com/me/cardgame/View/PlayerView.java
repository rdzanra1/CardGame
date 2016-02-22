/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.cardgame.View;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.cardgame.Constans.GameConstans;
import com.me.cardgame.Enums.PlayerAllegianceEnum;

/**
 *
 * @author radoslaw.rdzanek
 */
public class PlayerView {
    
    
    private Sprite playerSprite;
    private Texture playerTexture;
    //private SpriteBatch batch = new SpriteBatch();
    
    
    public void playerTypeDraw(SpriteBatch batch) {
        
        playerTexture = new Texture("digger.jpg");
        playerSprite = new Sprite(playerTexture);
        playerSprite.setPosition(10, 10);
        playerSprite.setSize( GameConstans.PLAYER_SIZE_X , GameConstans.PLAYER_SIZE_Y);
        
        playerSprite.draw(batch);
        
        //System.out.println("TEKSTURA = " + playerSprite );
        
        //playerSprite = new Sprite("digger.jpg");
        
    }
    
       public void playerTypeDraw(SpriteBatch batch, PlayerAllegianceEnum playerType) {
        
        if (playerType == PlayerAllegianceEnum.Digger ) {
            playerTexture = new Texture("digger.jpg");
        }   
        else 
           playerTexture = new Texture("saboteur.jpg");
            
            
      
        playerSprite = new Sprite(playerTexture);
        playerSprite.setPosition(10, 10);
        playerSprite.setSize( GameConstans.PLAYER_SIZE_X , GameConstans.PLAYER_SIZE_Y);
        
        playerSprite.draw(batch);
        
        //System.out.println("TEKSTURA = " + playerSprite );
        
        //playerSprite = new Sprite("digger.jpg");
        
    } 
    
    public void playerBackDraw(SpriteBatch batch) {
        
      
        
        playerTexture = new Texture("player_back.png");
        playerSprite = new Sprite(playerTexture);
       
        playerSprite.setPosition(GameConstans.OPPONET_POS_X, GameConstans.OPPONET_POS_Y);
        playerSprite.setSize( GameConstans.PLAYER_SIZE_X , GameConstans.PLAYER_SIZE_Y);
        
        playerSprite.draw(batch);
        
        
    }
    
    
    
}
