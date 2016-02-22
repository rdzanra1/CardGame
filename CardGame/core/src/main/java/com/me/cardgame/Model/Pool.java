package com.me.cardgame.Model;

import java.util.ArrayList;

public class Pool {

	private ArrayList<GameCard> pool = new ArrayList<GameCard>();

	public Pool() {

	}

	public void insertToPool(GameCard card) {
		pool.add(card);
	}

	public void removeFromPool(GameCard card) {
		pool.remove(card);
	}

	public boolean isEligibleToPlayCards() {
		return pool.isEmpty();
	}

}