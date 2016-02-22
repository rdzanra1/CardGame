package com.me.cardgame.Factory;

import com.me.cardgame.Exception.CardValidationException;
import com.me.cardgame.Model.ActionCard;
import com.me.cardgame.Model.GameCard;
import com.me.cardgame.Model.TunnelCard;
import com.me.cardgame.XML.GameCardXML;

public class CardFactory {

	public GameCard constructGameCard(GameCardXML gameCardXML) throws CardValidationException {

		switch (gameCardXML.getCardType()) {
		case action:
			// TODO - walidacja - g³êbsza
			if (gameCardXML.getActionCardType() == null)
				throw new CardValidationException("Action card Type must be defined for all Action Cards", gameCardXML);
			return new ActionCard(gameCardXML.getCardId(), gameCardXML.getCardType(), gameCardXML.getCardTexture(),
					gameCardXML.getIsMarked(), gameCardXML.isPositive(), gameCardXML.getActionCardType());
		case end:
			throw new UnsupportedOperationException("end cards should not be in deckConfig");
		case start:
			throw new UnsupportedOperationException("start card should not be in deckConfig");
		case tunnel:
			// TODO - walidacja
			return new TunnelCard(gameCardXML.getCardId(), gameCardXML.getCardType(), gameCardXML.getCardTexture(),
					gameCardXML.getIsMarked(), gameCardXML.getIsRotatted(), gameCardXML.getNorth(),
					gameCardXML.getSouth(), gameCardXML.getEast(), gameCardXML.getWest(), gameCardXML.getIsPassable());
		default:
			break;

		}

		return null;
	}

}
