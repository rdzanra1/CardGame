package com.me.cardgame;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.me.cardgame.Enums.ActionCardType;
import com.me.cardgame.Enums.CardTypeEnum;
import com.me.cardgame.Enums.WallTypeEnum;
import com.me.cardgame.Exception.CardValidationException;
import com.me.cardgame.Factory.CardFactory;
import com.me.cardgame.Model.Deck;
import com.me.cardgame.Model.GameCard;
import com.me.cardgame.XML.DeckXML;
import com.me.cardgame.XML.GameCardXML;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RunXmlGenerator {
//	public static void main(String[] args) {
//
//		// printSample();
//		readDeckFromConfiguration();
//
//	}

	public static Deck readDeckFromConfiguration() {
		Deck resultDeck = null;
		DeckXML deck = null;
		try {
//                    TODO - ogarnac ASSETS
//			InputStream is = ClassLoader.getSystemResourceAsStream("C:\\GIT\\CardGameMVN\\CardGame\\assets\\deckConfig.xml");
                        InputStream is = null;
                    try {
                        is = new FileInputStream("C:\\GIT\\CardGame\\assets\\deckConfig.xml");
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(RunXmlGenerator.class.getName()).log(Level.SEVERE, null, ex);
                    }

			JAXBContext jc = JAXBContext.newInstance(DeckXML.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			deck = (DeckXML) unmarshaller.unmarshal(is);

			CardFactory cardFactory = new CardFactory();
			List<GameCard> deckList = new ArrayList<GameCard>();
			for (GameCardXML gameCard : deck.getDeck()) {
			
				deckList.add(cardFactory.constructGameCard(gameCard));
			}

			resultDeck = new Deck(deckList);

		} catch (JAXBException ex) {
			// whareva
		} catch (CardValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// resultDeck.printDeck();
		// resultDeck.shuffle();
		// resultDeck.printDeck();

		return resultDeck;
	}

	private static void printSample() {
		GameCardXML gcxmlTunnel = new GameCardXML(1, CardTypeEnum.tunnel, "cardTexture", true, WallTypeEnum.BLOCKED,
				WallTypeEnum.BLOCKED, WallTypeEnum.BLOCKED, WallTypeEnum.BLOCKED, true, true, null, null);
		GameCardXML gcxmlAction = new GameCardXML(1, CardTypeEnum.tunnel, "cardTexture", true, null, null, null, null,
				null, null, true, ActionCardType.CART);

		ArrayList<GameCardXML> deckList = new ArrayList<GameCardXML>();
		deckList.add(gcxmlTunnel);
		deckList.add(gcxmlAction);

		DeckXML deckXML = new DeckXML();
		deckXML.setDeck(deckList);

		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(DeckXML.class);

			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			// marshaller.marshal(deckXML, System.out); // tu wypisze na konsolê

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
