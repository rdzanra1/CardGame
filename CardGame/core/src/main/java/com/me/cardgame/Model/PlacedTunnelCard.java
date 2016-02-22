package com.me.cardgame.Model;

import com.me.cardgame.Enums.CardTypeEnum;
import com.me.cardgame.Enums.Direction;
import com.me.cardgame.Enums.WallTypeEnum;

public class PlacedTunnelCard {
	private TunnelCard tunnelCard;
	private Boolean isRotated;
	private Boolean isReversed; // for end cards only but should be possible for
								// every tunnel card

	public PlacedTunnelCard(TunnelCard tunnelCard, Boolean isRotated) {
		this.tunnelCard = tunnelCard;
		this.isRotated = isRotated;
		isReversed = true;
	}

	public PlacedTunnelCard(EndCard endCard, Boolean isRotated) {
		this.tunnelCard = endCard;
		this.isRotated = isRotated;
		isReversed = false;
	}


	
	// public TunnelCard getTunnelCard() {
	// return tunnelCard;
	// }
	public void setTunnelCard(TunnelCard tunnelCard) {
		this.tunnelCard = tunnelCard;
	}

	public Boolean getIsRotated() {
		return isRotated;
	}

	public void setIsRotated(Boolean isRotated) {
		this.isRotated = isRotated;
	}

	
	public void setIsRotatted() {
		
		if (!this.isRotated) {
			this.isRotated = true;
		}
		else this.isRotated = false;
		
		
	}
	
	
	
	public String getCardTexture() {
		return tunnelCard.getCardTexture();
	}

	public Boolean getIsReversed() {
		return isReversed;
	}

	public void setIsReversed(Boolean isReversed) {
		this.isReversed = isReversed;
	}

	public WallTypeEnum getRelativeWall(Direction direct) {
		return tunnelCard.getWall(direct, isRotated);
	}

	public CardTypeEnum getCardType() {

		return tunnelCard.getCardType();

	}

}
