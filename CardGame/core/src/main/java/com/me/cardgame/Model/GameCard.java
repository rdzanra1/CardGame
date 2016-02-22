package com.me.cardgame.Model;

import javax.xml.bind.annotation.XmlElement;


import com.me.cardgame.Enums.CardTypeEnum;
import java.util.Objects;

public abstract class GameCard {

	private Integer cardId;
	private CardTypeEnum cardType;
	private String cardTexture;
	private Boolean isMarked;

	public GameCard() {

	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.cardId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GameCard other = (GameCard) obj;
        if (!Objects.equals(this.cardId, other.cardId)) {
            return false;
        }
        return true;
    }

	public GameCard(Integer cardId, CardTypeEnum cardType, String cardTexture, Boolean isMarked) {
		this.cardId = cardId;
		this.cardType = cardType;
		this.cardTexture = cardTexture;
		this.isMarked = isMarked;
	}

	// zaznaczanie karty
	public void markCard() {
//
//		if (this.getIsMarked())
//
//			this.setIsMarked(false);
//		else {
//
//			this.setIsMarked(true);
//
//		}
            this.setIsMarked(true);
    
	}

        
        public void unMarkCard() {
            
            this.setIsMarked(false);
      
        }
        
        
        
	/**
	 * @return the cardId
	 */
	public Integer getCardId() {
		return cardId;
	}

	/**
	 * @param cardId
	 *            the cardId to set
	 */
	@XmlElement
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	/**
	 * @return the cardType
	 */
	public CardTypeEnum getCardType() {
		return cardType;
	}

	/**
	 * @param cardType
	 *            the cardType to set
	 */
	@XmlElement
	public void setCardType(CardTypeEnum cardType) {
		this.cardType = cardType;
	}

	/**
	 * @return the cardTexture
	 */
	public String getCardTexture() {
		return cardTexture;
	}

	/**
	 * @param cardTexture
	 *            the cardTexture to set
	 */
	@XmlElement
	public void setCardTexture(String cardTexture) {
		this.cardTexture = cardTexture;
	}

	/**
	 * @return the isMarked
	 */
	public Boolean getIsMarked() {
		return isMarked;
	}

	/**
	 * @param isMarked
	 *            the isMarked to set
	 */
	@XmlElement
	public void setIsMarked(Boolean isMarked) {
		this.isMarked = isMarked;
	}

	@Override
	public String toString() {
		return "GameCard [cardId=" + cardId + ", cardType=" + cardType + ", cardTexture=" + cardTexture + ", isMarked="
				+ isMarked + "]";
	}

}
