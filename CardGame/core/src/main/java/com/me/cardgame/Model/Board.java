package com.me.cardgame.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.me.cardgame.Enums.CardTypeEnum;
import com.me.cardgame.Enums.WallTypeEnum;



public class Board {


	private List<TunnelCard> endPos = new ArrayList<TunnelCard>();

	private BoardWrapper boardWrapper;

	public Random rand = new Random();

	private TunnelCard startCard = new TunnelCard(0, CardTypeEnum.start, "start", false, false, WallTypeEnum.OPEN,
			WallTypeEnum.OPEN, WallTypeEnum.OPEN, WallTypeEnum.OPEN, true);

	private EndCard goldCard = new EndCard(1, CardTypeEnum.end, "gold", false, false, WallTypeEnum.OPEN,
			WallTypeEnum.OPEN, WallTypeEnum.OPEN, WallTypeEnum.OPEN, true, false);
	private EndCard rockCard1 = new EndCard(2, CardTypeEnum.end, "rockA", false, false, WallTypeEnum.OPEN,
			WallTypeEnum.NOTHING, WallTypeEnum.OPEN, WallTypeEnum.NOTHING, true, false);
	private EndCard rockCard2 = new EndCard(3, CardTypeEnum.end, "rockB", false, false, WallTypeEnum.NOTHING,
			WallTypeEnum.OPEN, WallTypeEnum.OPEN, WallTypeEnum.NOTHING, true, false);

	private Integer cardXindex;
	private Integer cardYindex;

	/*
	 * standarowe wymiary sto³u: sizeX = 16 sizeY = 10 startX = 11 start Y = 5
	 * 
	 * 
	 */

	public Board(Integer sizeX, Integer sizeY /*
												 * , usztywniamy na razie Integer
												 * startX, Integer startY
												 */) {


	
		endPos.add(rockCard1);
		endPos.add(goldCard);
		endPos.add(rockCard2);

		boardWrapper = new BoardWrapper(sizeX, sizeY);
                
                
                //System.out.println("KARTA STARTU:" + startCard.getIsRotatted());

	}

	public Board() {

	}

	public int xIndex(String textureName) {


		for (Coordinate coord : Coordinate.allCoords()) {
			if (boardWrapper.get(coord) != null && boardWrapper.get(coord).getCardTexture() == textureName) {

				cardXindex = coord.getX();
			}

		}
		return cardXindex;

	}

	public int yIndex(String taxtureName) {
		for (Coordinate coord : Coordinate.allCoords()) {

			if (boardWrapper.get(coord) != null && boardWrapper.get(coord).getCardTexture() == taxtureName) {

				cardYindex = coord.getY();
			}
		}
		return cardYindex;

	}

	public BoardWrapper getBoard() {
		return boardWrapper;
	}



	public void putCard(Coordinate coord, TunnelCard card, Boolean isRotated) {
		boardWrapper.putCard(coord, card, isRotated);// [x][y] = new
														// PlacedTunnelCard(card,
														// true);

	}

	void removeCard(Coordinate coord) {

		boardWrapper.removeCard(coord);

	}



	public boolean checkRoad() {

		return true;
	}

	public void clearBoard() {
		for (Coordinate coord : Coordinate.allCoords()) {
			if (!coord.isStartCardCoordinate()) {
				boardWrapper.removeCard(coord);
			}
		}
	}

	public void initializeBoard() {

		Collections.shuffle(endPos);

		boardWrapper.putCard(Coordinate.getStartCoord(), startCard, false);

		for (Coordinate endCoordinate : Coordinate.allEndCoords()) {
			//boardWrapper.putCard(endCoordinate, endPos.remove(0), rand.nextBoolean());
                        boardWrapper.putCard(endCoordinate, endPos.remove(0), false);
		}

	}

}
