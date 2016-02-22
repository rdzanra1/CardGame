package com.me.cardgame.XML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.me.cardgame.Enums.ActionCardType;
import com.me.cardgame.Enums.WallTypeEnum;
import com.me.cardgame.Enums.CardTypeEnum;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GameCardXML", propOrder = { "cardId", "cardType", "cardTexture", "isRotatted", "isMarked", "north",
		"south", "east", "west", "isPassable", "isPositive", "actionCardType" })
public class GameCardXML {

	// GAME CARD
	private Integer cardId;
	private CardTypeEnum cardType;
	private String cardTexture;
	private Boolean isMarked;

	// TUNNEL CARD
	private WallTypeEnum north;
	private WallTypeEnum south;
	private WallTypeEnum east;
	private WallTypeEnum west;
	private Boolean isPassable;
	private Boolean isRotatted;

	// ACTION CARD

	private Boolean isPositive;
	private ActionCardType actionCardType;

	public GameCardXML() {

	}

	public GameCardXML(Integer cardId, CardTypeEnum cardType, String cardTexture, Boolean isMarked, WallTypeEnum north,
			WallTypeEnum south, WallTypeEnum east, WallTypeEnum west, Boolean isPassable, Boolean isRotatted,
			Boolean isPositive, ActionCardType actionCardType) {
		this.cardId = cardId;
		this.cardType = cardType;
		this.cardTexture = cardTexture;
		this.isMarked = isMarked;
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
		this.isPassable = isPassable;
		this.isRotatted = isRotatted;
		this.isPositive = isPositive;
		this.actionCardType = actionCardType;
	}

	public Integer getCardId() {
		return cardId;
	}

	// @XmlElement
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public CardTypeEnum getCardType() {
		return cardType;
	}

	// @XmlElement
	public void setCardType(CardTypeEnum cardType) {
		this.cardType = cardType;
	}

	public String getCardTexture() {
		return cardTexture;
	}

	// @XmlElement
	public void setCardTexture(String cardTexture) {
		this.cardTexture = cardTexture;
	}

	public Boolean getIsMarked() {
		return isMarked;
	}

	// @XmlElement
	public void setIsMarked(Boolean isMarked) {
		this.isMarked = isMarked;
	}

	public WallTypeEnum getNorth() {
		return north;
	}

	// @XmlElement
	public void setNorth(WallTypeEnum north) {
		this.north = north;
	}

	public WallTypeEnum getSouth() {
		return south;
	}

	// @XmlElement
	public void setSouth(WallTypeEnum south) {
		this.south = south;
	}

	public WallTypeEnum getEast() {
		return east;
	}

	// @XmlElement
	public void setEast(WallTypeEnum east) {
		this.east = east;
	}

	public WallTypeEnum getWest() {
		return west;
	}

	// @XmlElement
	public void setWest(WallTypeEnum west) {
		this.west = west;
	}

	public Boolean getIsPassable() {
		return isPassable;
	}

	// @XmlElement
	public void setIsPassable(Boolean isPassable) {
		this.isPassable = isPassable;
	}

	public Boolean getIsRotatted() {
		return isRotatted;
	}

	// @XmlElement
	public void setIsRotatted(Boolean isRotatted) {
		this.isRotatted = isRotatted;
	}

	public boolean isPositive() {
		return isPositive;
	}

	// @XmlElement
	public void setPositive(boolean isPositive) {
		this.isPositive = isPositive;
	}

	public ActionCardType getActionCardType() {
		return actionCardType;
	}

	// @XmlElement
	public void setActionCardType(ActionCardType actionCardType) {
		this.actionCardType = actionCardType;
	}

	@Override
	public String toString() {
		return "GameCardXML [cardId=" + cardId + ", cardType=" + cardType + ", cardTexture=" + cardTexture
				+ ", isMarked=" + isMarked + ", north=" + north + ", south=" + south + ", east=" + east + ", west="
				+ west + ", isPassable=" + isPassable + ", isRotatted=" + isRotatted + ", isPositive=" + isPositive
				+ ", actionCardType=" + actionCardType + "]";
	}

}
