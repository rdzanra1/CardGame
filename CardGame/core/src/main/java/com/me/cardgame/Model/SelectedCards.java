/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.cardgame.Model;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author radoslaw.rdzanek
 */
public class SelectedCards {
    
    private ArrayList<GameCard> selectedCards =  new ArrayList<>();
    
    
    
    
        
    
	public ArrayList<GameCard> getSelectedCards() {
		return selectedCards;
	}

	public void setSelectedCards(ArrayList<GameCard> selectedCards) {
		this.selectedCards = selectedCards;
	}
    
        public void removeCard(GameCard gameCard) {
            
       
            
            for ( int i =0; i< selectedCards.size(); i++ )
            
                if (gameCard.getCardId() == selectedCards.get(i).getCardId())  {
                    selectedCards.remove(i);
            
                }

        }
        

        
        
        
    
    	public void printSelectedCards() {
		System.out.println("!!! DECK PRINT !!!");
		Integer cardPosition = 0;
		for (GameCard gc : selectedCards) {
			cardPosition++;
			System.out.println("CARD IN POSITION [" + cardPosition + "] = " + gc);
		}
	}
    
        
        
}




