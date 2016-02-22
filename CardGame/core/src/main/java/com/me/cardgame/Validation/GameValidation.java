/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.cardgame.Validation;

import com.me.cardgame.Model.Board;
import com.me.cardgame.Model.Coordinate;
import com.me.cardgame.Model.SelectedCards;


/**
 *
 * @author radoslaw.rdzanek
 */
public class GameValidation {
    
   
    
    
    
public Boolean canPut(SelectedCards selectedCards) {
    
    if (selectedCards.getSelectedCards().size() == 1)
    return true;
    return false;
}
//    
//public Boolean canPutOnBoard(SelectedCards selectedCards) {
//    
// if (selectedCards.getSelectedCards().get(0).)
//    
//} 


public Boolean revertEndCard(Board board) {
    
     for (Coordinate coord : Coordinate.allCoords()) {
         
         
     }
    
    
    return false;
}



}
