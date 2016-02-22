package com.me.cardgame.XML;

import java.util.ArrayList;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DeckXML {

	private ArrayList<GameCardXML> deck = new ArrayList<GameCardXML>();

	public DeckXML() {
	}

	public ArrayList<GameCardXML> getDeck() {
		return deck;
	}

	@XmlElementWrapper(name = "deck")
	@XmlElement(name = "gameCardXml")
	public void setDeck(ArrayList<GameCardXML> deck) {
		this.deck = deck;
	}

}
