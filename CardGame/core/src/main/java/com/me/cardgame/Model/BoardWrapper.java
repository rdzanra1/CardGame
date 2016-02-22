package com.me.cardgame.Model;

public class BoardWrapper {
	private PlacedTunnelCard[][] board;

	public BoardWrapper(Integer sizeX, Integer sizeY) {
		board = new PlacedTunnelCard[sizeX][sizeY];
	}

	public PlacedTunnelCard get(Coordinate coord) {
		return board[coord.getX()][coord.getY()];
	}

	public void putCard(Coordinate coord, TunnelCard card, Boolean isRotated) {
		board[coord.getX()][coord.getY()] = new PlacedTunnelCard(card, isRotated);

	}

	void removeCard(Coordinate coord) {
		board[coord.getX()][coord.getY()] = null;
	}

}
