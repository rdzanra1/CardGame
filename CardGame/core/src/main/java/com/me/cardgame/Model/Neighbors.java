package com.me.cardgame.Model;


////////////////////TO DO///////////////
//POLOZENIE KART PRZY KARTACH KONCA




import java.util.HashMap;

import com.me.cardgame.Enums.Direction;
import com.me.cardgame.Enums.WallTypeEnum;
import java.util.ArrayList;

public class Neighbors {

    // private WallTypeEnum northNeibhor;
    // private WallTypeEnum southNeibhor;
    // private WallTypeEnum eastNeibhor;
    // private WallTypeEnum westNeibhor;
    private HashMap<Direction, WallTypeEnum> neighborMap = new HashMap<Direction, WallTypeEnum>();

    public void clearNeighborMap() {
        neighborMap.clear();

    }

    public Boolean doesAnyExist() {
        for (Direction direct : Direction.values()) {
            if (neighborMap.get(direct) != null) {
                return true;
            }
        }
        return false;

    }

    public WallTypeEnum getNeighbor(Direction direct) {
        return neighborMap.get(direct);
    }

    public HashMap<Direction, WallTypeEnum> getNeighborMap() {
        return neighborMap;
    }

    public void setNeighborMap(HashMap<Direction, WallTypeEnum> neighborMap) {
        this.neighborMap = neighborMap;
    }

    public void setNeighbor(WallTypeEnum wte, Direction direct) {
//        if (wte == null) {
//            neighborMap.put(direct, WallTypeEnum.NOTHING);
//        }
        neighborMap.put(direct, wte);
    }

    
    //DOPISAC WARUNEK NA END CARD, TAK ZEBY MOZNA BYLO POLOZYC KARTE OBOK KARTY END 
    public Boolean checkIfNoConflicts(TunnelCard card, Boolean isRotated) {

        for (Direction direct : Direction.values()) {

            if (!checkWalls(card.getWall(direct, isRotated), neighborMap.get(direct))) {

                return false;
            }

        }

        return true;

    }

    public Boolean checkWalls(WallTypeEnum mainCardWall, WallTypeEnum neighbourCardWall) {

        if (neighbourCardWall == null) {

            return true;

        } else if (mainCardWall == neighbourCardWall
                || (mainCardWall == WallTypeEnum.BLOCKED && neighbourCardWall == WallTypeEnum.OPEN)
                || (mainCardWall == WallTypeEnum.OPEN && neighbourCardWall == WallTypeEnum.BLOCKED)) {

            return true;
        }

        return false;
    }

}
