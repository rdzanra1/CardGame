package com.me.cardgame.Model;

import java.util.HashSet;
import java.util.Set;

import com.badlogic.gdx.Gdx;
import com.me.cardgame.Constans.GameConstans;
import com.me.cardgame.Enums.Direction;
import com.me.cardgame.Enums.WorldPartEnum;

public class Coordinate {

	private static final Integer START_POSITION_OFFSET_X = 8;
	private static final Integer START_POSITION_OFFSET_Y = 2;
	private static final Integer START_X = 11;
	private static final Integer START_Y = 4;

	private static final Integer SCALE_X_OFFSET = 160;
	private static final Double SCALE_Y_OFFSET = 4.5;
	private static final Integer SCALE_CELL_SIZE_X = 32;
	private static final Integer SCALE_CELL_SIZE_Y = 12;

	private final int x;
	private final int y;

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Coordinate other = (Coordinate) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

    public Coordinate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Coordinate go(Direction direct) {
		return new Coordinate(x + direct.X_DIFF, y + direct.Y_DIFF);
	}

        
        public Boolean isBoardCoard(Coordinate coordinate) {
            
             for (Direction direct : Direction.values()) {
                 if (Coordinate.allCoords().contains(coordinate.go(direct))) {
                  return true;   
                 }
                 
             }
            
            return false;
            
        }
        
        
	public static Set<Coordinate> allCoords() {
		Set<Coordinate> resultSet = new HashSet<Coordinate>();
		for (int k = 0; k < 9; k++) {
			for (int i = 0; i < 16; i++) {

				resultSet.add(new Coordinate(i, k));
			}
		}
		return resultSet;
	}

	public static Set<Coordinate> handCoords() {
		Set<Coordinate> resultSet = new HashSet<Coordinate>();
		for (int k = 0; k < GameConstans.HAND_SIZE; k++) {
			resultSet.add(new Coordinate(k, GameConstans.HAND_SIZE_Y));

		}
		return resultSet;
	}

        
        
        
        
        public static Set<Coordinate> poolCoords() {
            Set<Coordinate> resultSet = new HashSet<Coordinate>();
		for (int k = 0; k < GameConstans.POOL_SIZE; k++) {
			resultSet.add(new Coordinate(k, GameConstans.HAND_SIZE_Y)); // HAND_SIZE_Y = POOL_SIZE_Y

		}            
            return resultSet;
        }
        
        
        
        
	public Boolean isStartCardCoordinate() {
		if (x == 11 && y == 5) {
			return true;
		}
		return false;
	}

	public static Coordinate getStartCoord() {
		return new Coordinate(START_X, START_Y);
	}

	public static Set<Coordinate> allEndCoords() {
		Set<Coordinate> resultSet = new HashSet<Coordinate>();
		resultSet.add(new Coordinate(START_X - START_POSITION_OFFSET_X, START_Y));
		resultSet.add(new Coordinate(START_X - START_POSITION_OFFSET_X, START_Y + START_POSITION_OFFSET_Y));
		resultSet.add(new Coordinate(START_X - START_POSITION_OFFSET_X, START_Y - START_POSITION_OFFSET_Y));

		return resultSet;
	}

	public static Coordinate getPixel(int xPixel, int yPixel) {

		return new Coordinate(
				(int) Math.floor((xPixel - Gdx.graphics.getWidth() / SCALE_X_OFFSET)
						/ (Gdx.graphics.getWidth() / SCALE_CELL_SIZE_X)),
				(int) Math.floor(((Gdx.graphics.getHeight() - yPixel - Gdx.graphics.getHeight() / SCALE_Y_OFFSET))
						/ (Gdx.graphics.getHeight() / SCALE_CELL_SIZE_Y)));

	}

	public static Coordinate getHandPixel(int xPixel, int yPixel) {

		return new Coordinate(
				(int) Math.floor((xPixel - Gdx.graphics.getWidth() / GameConstans.HAND_OFFSET_X_SCALE)
						/ (Gdx.graphics.getWidth() / GameConstans.HAND_CARD_X_SCALE)),
				(int) Math.floor(((Gdx.graphics.getHeight() - yPixel
						- Gdx.graphics.getHeight() / GameConstans.HAND_OFFSET_Y_SCALE))
						/ (Gdx.graphics.getHeight() / GameConstans.HAND_CARD_Y_SCALE)));

	}

	public BoardPixels drawCoords() {

		// WIELKOSC KART I OFFSET WPISANE NA STALE DLA RYSOWANIA, ZMIANA MA
		// DOTYCZYC JEDYNIE PRZELICZANIA WSPOLRZEDNYCH NA PIXSELE

		// return new BoardPixels((int)(Gdx.graphics.getWidth()/SCALE_X_OFFSET +
		// ((Gdx.graphics.getWidth()/SCALE_CELL_SIZE_X) *this.getX())),
		// (int)(Gdx.graphics.getHeight()/SCALE_Y_OFFSET +
		// (Gdx.graphics.getHeight()/SCALE_CELL_SIZE_Y *this.getY())));

		return new BoardPixels((int) (GameConstans.BOARD_X_OFFSET + (GameConstans.CARD_SIZE_X * this.getX())),
				(int) (GameConstans.BOARD_Y_OFFSET + (GameConstans.CARD_SIZE_Y * this.getY())));

	}

	public BoardPixels drawHandCoords() {

		return new BoardPixels((int) (GameConstans.HAND_X_OFFSET + (GameConstans.HAND_CARD_SIZE_X * this.getX())),
				(int) (GameConstans.HAND_Y_OFFSET + (GameConstans.HAND_CARD_SIZE_Y * this.getY())));

	}

	
        public BoardPixels drawPoolCoords() {

		return new BoardPixels((int) (GameConstans.POOL_X_OFFSET + (GameConstans.POOL_CARD_SIZE_X * this.getX())),
				(int) (GameConstans.POOL_Y_OFFSET + (GameConstans.POOL_CARD_SIZE_Y * this.getY())));

	}
        
        
        
        
        
        
	public static WorldPartEnum worldPart(int screenX, int screenY) {
		
		if (screenX > Gdx.graphics.getWidth() / GameConstans.HAND_OFFSET_X_SCALE
				&& screenX < Gdx.graphics.getWidth() / GameConstans.HAND_OFFSET_X_SCALE
						+ GameConstans.HAND_SIZE * Gdx.graphics.getWidth() / GameConstans.HAND_CARD_X_SCALE
				&& screenY < Gdx.graphics.getHeight() * (1 - 1 / GameConstans.HAND_OFFSET_Y_SCALE)
				&& screenY > Gdx.graphics.getHeight() * (1 - 1 / GameConstans.HAND_CARD_Y_SCALE + 1 / GameConstans.HAND_OFFSET_Y_SCALE)) 
		{
			return WorldPartEnum.HAND;
		}
			
		else if (screenX > Gdx.graphics.getWidth() / GameConstans.BOARD_OFFSET_X_SCALE
				&& screenX < Gdx.graphics.getWidth() / GameConstans.BOARD_OFFSET_X_SCALE
						+ GameConstans.BOARD_SIZE_X * Gdx.graphics.getWidth() / GameConstans.BOARD_CARD_X_SCALE
				&& screenY < Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / GameConstans.BOARD_OFFSET_Y_SCALE
				&& screenY > Gdx.graphics.getHeight()
						- (Gdx.graphics.getHeight() / GameConstans.BOARD_CARD_Y_SCALE * GameConstans.BOARD_SIZE_Y
								+ Gdx.graphics.getHeight() / GameConstans.BOARD_OFFSET_Y_SCALE)) {
					

			return WorldPartEnum.BOARD;
		
                           
                        
				}
//                   else if  (screenX > Gdx.graphics.getWidth() / 1.6 && screenX < Gdx.graphics.getWidth() / 1.6 +    )  {
//                       
//                       return WorldPartEnum.OPPONENT;
//                   }
                
                
		return null;
	}
	
	
	
	
	
	// public Entry<Integer, Integer> getPixelsForCoord()
	// albo zrobiæ klasê PixelCoord
	// która te¿ bêdzie mia³a x i y
	// tam du¿o ju¿ fajnych rozwi¹zañ jest w tej gierce
	// ma to ogólnie sens :)

}
