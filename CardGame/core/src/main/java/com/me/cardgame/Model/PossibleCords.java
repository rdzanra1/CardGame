/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.cardgame.Model;

import java.util.ArrayList;

/**
 *
 * @author radoslaw.rdzanek
 */
public class PossibleCords {
    
    private ArrayList<Coordinate> possibleCords = new ArrayList<Coordinate>();

    public ArrayList<Coordinate> getPossibleCords() {
        return possibleCords;
    }

    public void setPossibleCords(ArrayList<Coordinate> possibleCords) {
        this.possibleCords = possibleCords;
    }
    
    
}
