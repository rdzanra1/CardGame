package com.me.cardgame.Model;

import com.me.cardgame.Enums.CardTypeEnum;
import com.me.cardgame.Enums.Direction;




import com.me.cardgame.Enums.WallTypeEnum;

public class TunnelCard extends GameCard {

	private WallTypeEnum north;
	private WallTypeEnum south;
	private WallTypeEnum east;
	private WallTypeEnum west;
	private Boolean isPassable;
	private Boolean isRotatted;

	public TunnelCard(Integer cardId, CardTypeEnum cardType, String cardTexture, Boolean isRotatted, Boolean isMarked,
			WallTypeEnum north, WallTypeEnum south, WallTypeEnum east, WallTypeEnum west, Boolean isPassable) {
		super(cardId, cardType, cardTexture, isMarked);

		this.isRotatted = isRotatted;
		this.isPassable = isPassable;

		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;

	}

	public TunnelCard() {
		
	}
	
	
	public Boolean getIsRotatted() {
		return isRotatted;
	}

	public void setIsRotatted(Boolean isRotatted) {
		this.isRotatted = isRotatted;
	}
	
	
	public void setIsRotatted() {
		
		if (!this.isRotatted) {
			this.isRotatted = true;
		}
		else this.isRotatted = false;
		
		
	}

	/**
	 * @return the north
	 */
	// public WallTypeEnum getNorth() {
	// return north;
	// }
	//
	// /**
	// * @param north the north to set
	// */
	//
	// public void setNorth(WallTypeEnum north) {
	// this.north = north;
	// }
	//
	// /**
	// * @return the south
	// */
	//
	// public WallTypeEnum getSouth() {
	// return south;
	// }
	//
	// /**
	// * @param south the south to set
	// */
	//
	// public void setSouth(WallTypeEnum south) {
	// this.south = south;
	// }
	//
	// /**
	// * @return the east
	// */
	//
	// public WallTypeEnum getEast() {
	// return east;
	// }
	//
	// /**
	// * @param east the east to set
	// */
	//
	// public void setEast(WallTypeEnum east) {
	// this.east = east;
	// }
	//
	// /**
	// * @return the west
	// */
	//
	// public WallTypeEnum getWest() {
	// return west;
	// }
	//
	// /**
	// * @param west the west to set
	// */
	//
	// public void setWest(WallTypeEnum west) {
	// this.west = west;
	// }

	public WallTypeEnum getWall(Direction direct, Boolean isRotated) {
		switch (direct) {
		case NORTH:
			return isRotated ? this.south : this.north;
		case SOUTH:
			return isRotated ? this.north : this.south;
		case EAST:
			return isRotated ? this.west : this.east;
		case WEST:
			return isRotated ? this.east : this.west;
		default:
			throw new UnsupportedOperationException("pfff");
		}
	}

        
        
        
	/**
	 * @return the isPassable
	 */

	public Boolean getIsPassable() {
		return isPassable;
	}

	/**
	 * @param isPassable
	 *            the isPassable to set
	 */

	public void setIsPassable(Boolean isPassable) {
		this.isPassable = isPassable;
	}

	@Override
	public String toString() {
		return "TunnelCard [north=" + north + ", south=" + south + ", east=" + east + ", west=" + west + ", isPassable="
				+ isPassable + ", isRotatted=" + isRotatted + ", getCardId()=" + getCardId() + ", getCardType()="
				+ getCardType() + ", getCardTexture()=" + getCardTexture() + ", getIsMarked()=" + getIsMarked() + "]";
	}

}
