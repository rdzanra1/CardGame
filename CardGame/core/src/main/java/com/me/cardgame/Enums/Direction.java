package com.me.cardgame.Enums;

public enum Direction {

	// use magic numbers to set the ordinal (used for rotation),
	// and the dx and dy of each direction.
	NORTH(0, 1), EAST(1, 0), SOUTH(0, -1), WEST(-1, 0);

	public int X_DIFF;
	public int Y_DIFF;

	private Direction(int xDiff, int yDiff) {
		X_DIFF = xDiff;
		Y_DIFF = yDiff;
	}

	public Direction opposite() {
		if (NORTH.equals(this)) {
			return SOUTH;
		} else if (SOUTH.equals(this)) {
			return Direction.NORTH;
		} else if (WEST.equals(this)) {
			return Direction.EAST;
		} else if (EAST.equals(this)) {
			return Direction.WEST;
		}
		throw new UnsupportedOperationException("Whoooa");
	}

}
