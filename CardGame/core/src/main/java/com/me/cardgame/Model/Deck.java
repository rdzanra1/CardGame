package com.me.cardgame.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Deck {

	public List<GameCard> deck;

	public Deck(List<GameCard> deckList) {
		this.deck = deckList;

	}

	public void setCardDeck(ArrayList<GameCard> deck) {
		this.deck = deck;
	}

	public List<GameCard> getCardDeck() {
		return deck;
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	// public int cardsLeft() {
	// return deck.size() - cardsUsed;
	// }

	public GameCard dealCard() {
		// if (cardsUsed == deck.size())
		// throw new IllegalStateException("No cards are left in the deck.");
		// cardsUsed++;
		try {
			return deck.remove(0);
		} catch (Exception e) {
			// TODO - znajdz exception jakie tutaj lata i z³ap siê na nie i
			// wyslij event do engine ze gra sie skonczyla - niech gracze
			// dograja to co maja na rece
			return null;
		}
		// return deck.get(cardsUsed - 1);

	}

	// public Integer getCard(int i) {
	// return deck.get(i).getCardId();
	// }

	// public DEPRECATEDCard getCard2(int i) {
	// return deck.get(0);
	// }

	public void printDeck() {
		System.out.println("!!! S PRINT !!!");
		Integer cardPositionInDeck = 0;
		for (GameCard gc : deck) {
			cardPositionInDeck++;
			System.out.println("CARD IN POSITION [" + cardPositionInDeck + "] = " + gc);
		}
	}

}
