package com.me.cardgame.Exception;

import com.me.cardgame.XML.GameCardXML;

public class CardValidationException extends Exception {

	public CardValidationException(String validationError, GameCardXML gameCardXML) {
		super(validationError + ". For card: " + gameCardXML);
	}

}
