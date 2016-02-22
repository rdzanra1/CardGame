package com.me.cardgame.Model;

import java.util.ArrayList;


import com.me.cardgame.Enums.CardTypeEnum;
import java.util.Collection;

public class Hand {

	private ArrayList<GameCard> hand = new ArrayList<GameCard>();
        private PlacedTunnelCard placedTunnelCard;


        
        
	public Hand() {

	}

	public GameCard playCard() {
		return hand.remove(0);
	}

        public void clearRotation() {
            
            	for (GameCard gc : hand) {
		 gc.setIsMarked(Boolean.FALSE);
		}
            
        }
        
        
        
        public void discard(SelectedCards selectedCards) {

             hand.removeAll((Collection<?>) selectedCards.getSelectedCards());
                
                
        }


	public GameCard getCard(int i) {

		// if (hand.get(coord.getX()) != null) {

		return hand.get(i);
		// }

	}

        
        public GameCard getCard(Coordinate coord){
            
            return hand.remove(coord.getX());
            
        } 
        
        public void putCardOnBoard(SelectedCards selectedCards, Board board, Coordinate coordinate) {
            board.getBoard().putCard(coordinate, (TunnelCard) selectedCards.getSelectedCards().get(0), 
                                    ((TunnelCard) selectedCards.getSelectedCards().get(0)).getIsRotatted());
            hand.removeAll(selectedCards.getSelectedCards());
            
        }
        
        
        
	public void putCard(Board board, Coordinate coord) {

		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).getIsMarked()) {
				if (hand.get(i).getCardType() == CardTypeEnum.tunnel) {
					board.getBoard().putCard(coord, (TunnelCard) hand.remove(i), true);

				}
			}

		}

	}
        
        
//        public void putCard(SelectedCards selectedCards, Board board, Coordinate coordinate) {
//            
//            ///placedTunnelCard = new PlacedTunnelCard((TunnelCard) selectedCards.getSelectedCards().get(0), true);
//            board.getBoard().putCard(coordinate, selectedCards, Boolean.TRUE);
//            
//            
//        }
        
        
        
        
        public void removeCard(SelectedCards selectedCards) {
            for (int i = 0; i < hand.size(); i++) {
                if (Integer.compare(hand.get(i).getCardId(), selectedCards.getSelectedCards().get(0).getCardId()) == 0) {
                    hand.remove(i);
                }
                
                
            }
      
            
        }
        
        
        

	public ArrayList<GameCard> getHand() {
		return hand;
	}

	public void setHand(ArrayList<GameCard> hand) {
		this.hand = hand;
	}
        
        public Integer getHandSieze() {
            
            return hand.size();
            
        }
        
        public PlacedTunnelCard getPlacedTunnelCard() {
        return placedTunnelCard;
    }

    public void setPlacedTunnelCard(PlacedTunnelCard placedTunnelCard) {
        this.placedTunnelCard = placedTunnelCard;
    }    
}