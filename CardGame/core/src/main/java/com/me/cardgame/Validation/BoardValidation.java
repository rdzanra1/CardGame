package com.me.cardgame.Validation;
import com.me.cardgame.Enums.CardTypeEnum;
import com.me.cardgame.Enums.Direction;
import com.me.cardgame.Enums.WallTypeEnum;
import com.me.cardgame.Model.Board;
import com.me.cardgame.Model.Coordinate;
import com.me.cardgame.Model.Neighbors;
import com.me.cardgame.Model.PlacedTunnelCard;
import com.me.cardgame.Model.PossibleCords;
import com.me.cardgame.Model.TunnelCard;
import java.util.ArrayList;

public class BoardValidation {

    private Neighbors neighbors = new Neighbors();
    private PossibleCords possibleCords = new PossibleCords();
    private ArrayList<Coordinate> tmpCords = new ArrayList<Coordinate>();

    public PossibleCords getPossibleCords() {
        return possibleCords;
    }

    public void setPossibleCords(PossibleCords possibleCords) {
        this.possibleCords = possibleCords;
    }

    public Neighbors getNeighbors() {
        return neighbors;
    }

    public void generatePossibleCords(Board board, TunnelCard tunnelCard) {

        possibleCords.getPossibleCords().clear();
        tmpCords.clear();
        neighbors.clearNeighborMap();

        for (Coordinate coord : Coordinate.allCoords()) {
            if (globalHasAnyNeighbors(board, coord)) {
                findNeighbors(board, coord, tunnelCard);
                if (neighbors.checkIfNoConflicts(tunnelCard, tunnelCard.getIsRotatted())) {
                    tmpCords.add(coord);
                }
                neighbors.clearNeighborMap();
            }

        }

        possibleCords.getPossibleCords().addAll(tmpCords);

    }

    public void findNeighbors(Board board, Coordinate coord, TunnelCard tunnelCard) {

        // dodac obsluge wyjatku IndexOutOfBound
        PlacedTunnelCard tmpNeighborCard;
        for (Direction direct : Direction.values()) {
            tmpNeighborCard = board.getBoard().get(coord.go(direct));

            if (tmpNeighborCard != null) {
                neighbors.setNeighbor(tmpNeighborCard.getRelativeWall(direct.opposite()), direct);
            }
//            else {
//                neighbors.setNeighbor(WallTypeEnum.NOTHING, direct);
//            }

        }
        // System.out.println("PRZED " + neighbors.getNeighborMap().size());
    }

    public void findNeighbors(Board board, Coordinate coord, Direction direct) {

        Coordinate coordinate = new Coordinate(10, 4);

        System.out.println("NOWE COORDY: " + coordinate.go(Direction.EAST).getX() + " " + coordinate.go(Direction.EAST).getY());
        PlacedTunnelCard testNeighborCard = board.getBoard().get(coordinate.go(Direction.EAST));

        System.out.println("testNeighborCard " + testNeighborCard.getRelativeWall(Direction.WEST.opposite()));

        // dodac obsluge wyjatku IndexOutOfBound
        PlacedTunnelCard tmpNeighborCard;

        //tmpNeighborCard = board.getBoard().get(coord.go(direct));
        tmpNeighborCard = board.getBoard().get(coord.go(direct));

        System.out.println("KIERUNEK: " + direct);
        System.out.println("tmpNeighborCard: " + tmpNeighborCard);
        // System.out.println("SASIAD  " +board.getBoard().get(coord2).getRelativeWall(Direction.EAST));
        //tmpNeighborCard = new PlacedTunnelCard(tunnelCard, tunnelCard.getIsRotatted());
        if (tmpNeighborCard != null) {
            //neighbors.setNeighbor(tmpNeighborCard.getRelativeWall(direct), direct);
            neighbors.setNeighbor(tmpNeighborCard.getRelativeWall(direct), direct);                                                                         // zwraca sciane karty ktora chce polozyc
        } else {
            neighbors.setNeighbor(WallTypeEnum.NOTHING, direct.opposite());
        }
        System.out.println("Sciany: " + neighbors.getNeighborMap().toString());
    }

    public Boolean possiblePlacesValidation() {

        return false;
    }

    public Boolean putCardValidation(Board board, TunnelCard card, Coordinate coord) {

        // sprawdzam czy pole w ktore chce wstawic karte jest puste
        if (board.getBoard().get(coord) != null) {

            System.out.println("POLE JEST ZAJETE");
            return false;
        } else {

            findNeighbors(board, coord, card);
        }
        // sprawdzam czy pole do ktorego chce wstawic karte ma sasiadow

        if (!neighbors.doesAnyExist()) {
            System.out.println("NIE ISTNIEJE ZODYN SASIAD");
            return false;
        }

        if (neighbors.checkIfNoConflicts(card, card.getIsRotatted())) {
            System.out.println("POLOZ KARTE, JEST OK");
            return true;
        } else {
            System.out.println("NIEPRAWIDLOWY SASIAD");
            return false;
        }

    }
/////// DO POPRAWY FUNCKJA, MA WALIDOWAC ROWNIEZ DLA KART TYPU END

    public Boolean hasAnyNeighbors(Board board, Coordinate coordinate) {

        // System.out.println("TESTOWANIE FUNKCJI OKRESLAJACEJ SASIADA");
        for (Direction direct : Direction.values()) {

            if (Coordinate.allCoords().contains(coordinate.go(direct))) {

                if (board.getBoard().get(coordinate.go(direct)) != null) {
                    if (board.getBoard().get(coordinate.go(direct)).getCardType() != CardTypeEnum.end) {
                        return true;
                    }

                }

            }

        }
        return false;

    }

    public Boolean endCardHasAnyNeibghors(Board board, Coordinate coord) {

        for (Direction direct : Direction.values()) {
            if (board.getBoard().get(coord.go(direct)) != null) {
                return true;
            }
        }
        return false;

    }

    public Boolean globalHasAnyNeighbors(Board board, Coordinate coord) {

        if (board.getBoard().get(coord) == null) {
            return hasAnyNeighbors(board, coord);

        }
        return false;
    }

    public void reverseEndCarad(Board board) {

        for (Coordinate coord : Coordinate.allEndCoords()) {
            if (endCardHasAnyNeibghors(board, coord)) {
                board.getBoard().get(coord).setIsReversed(Boolean.FALSE);
            }
        }

//
//                for (Coordinate coord : Coordinate.allEndCoords()) {
//            if (hasAnyNeighbors(board, coord)) {
//                System.out.println("KARTA Z POLA " + coord);
//                System.out.println("WARTOSC IsREVERSED PRZED " + board.getBoard().get(coord).getIsReversed());
//                board.getBoard().get(coord).setIsReversed(Boolean.FALSE);
//                System.out.println("WARTOSC IsREVERSED PO " + board.getBoard().get(coord).getIsReversed());
//            }
//            
//        }
//    }
    }
    
}