package com.me.cardgame.Model;

import com.me.cardgame.Enums.CardTypeEnum;
import com.me.cardgame.Enums.WallTypeEnum;

public class EndCard extends TunnelCard {

	// private Boolean isReversed;
	private Boolean isGold;
	private static final String cardBackTexture = "end_back";

	public EndCard(Integer cardId, CardTypeEnum cardType, String cardTexture, Boolean isRotatted, Boolean isMarked,
			WallTypeEnum north, WallTypeEnum south, WallTypeEnum east, WallTypeEnum west, Boolean isPassable,
			Boolean isGold) {
		super(cardId, cardType, cardTexture, isRotatted, isMarked, north, south, east, west, isPassable);
		this.isGold = isGold;

	}

	public static String getCardBackTexture() {
		return cardBackTexture;
	}

	/**
	 * @return the isGold
	 */
	public Boolean getIsGold() {
		return isGold;
	}

	/**
	 * @param isGold
	 *            the isGold to set
	 */
	public void setIsGold(Boolean isGold) {
		this.isGold = isGold;
	}

}
