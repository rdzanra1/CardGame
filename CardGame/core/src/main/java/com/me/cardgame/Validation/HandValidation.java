/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.cardgame.Validation;

import com.me.cardgame.Constans.GameConstans;
import com.me.cardgame.Controller.GameConrtoller;
import com.me.cardgame.Model.Hand;

/**
 *
 * @author radoslaw.rdzanek
 */
public class HandValidation {
    
    //private Integer s;
    
   public Boolean canMark(Hand hand) {
       
       Integer s = 0;
  
       for (int i=0; i < hand.getHandSieze(); i++) {
           if (hand.getCard(i).getIsMarked()) {
               s++;  
           }
       }
       
       if (s < GameConstans.MAX_CARD_SELECTED) {
           
           return true;
       } else {
            return false;
       
       }
    
   }
    
    
    
    
    
    
}
