package com.me.cardgame.Model;

import com.me.cardgame.Enums.ActionCardType;
import com.me.cardgame.Enums.CardTypeEnum;

public class ActionCard extends GameCard {

	private boolean isPositive;
	private ActionCardType actionCardType;

	public ActionCard(Integer cardId, CardTypeEnum cardType, String cardTexture, Boolean isMarked, boolean isPositive,
			ActionCardType actionCardType) {
		super(cardId, cardType, cardTexture, isMarked);
		this.isPositive = isPositive;
		this.actionCardType = actionCardType;

	}

	/**
	 * @return the isPositive
	 */
	public boolean isPositive() {
		return isPositive;
	}

	/**
	 * @param isPositive
	 *            the isPositive to set
	 */
	public void setPositive(boolean isPositive) {
		this.isPositive = isPositive;
	}

	/**
	 * @return the actionCardType
	 */
	public ActionCardType getActionCardType() {
		return actionCardType;
	}

	/**
	 * @param actionCardType
	 *            the actionCardType to set
	 */
	public void setActionCardType(ActionCardType actionCardType) {
		this.actionCardType = actionCardType;
	}

	@Override
	public String toString() {
		return "ActionCard [isPositive=" + isPositive + ", actionCardType=" + actionCardType + ", getCardId()="
				+ getCardId() + ", getCardType()=" + getCardType() + ", getCardTexture()=" + getCardTexture()
				+ ", getIsMarked()=" + getIsMarked() + "]";
	}

}
