package com.me.cardgame.Controller;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.oxo42.stateless4j.StateMachine;
import com.github.oxo42.stateless4j.StateMachineConfig;
import com.me.cardgame.RunXmlGenerator;
import com.me.cardgame.Constans.GameConstans;
import com.me.cardgame.Enums.CardTypeEnum;
import com.me.cardgame.Enums.Direction;
import com.me.cardgame.Enums.PlayerAllegianceEnum;
import com.me.cardgame.Enums.WallTypeEnum;
import com.me.cardgame.Enums.WorldPartEnum;
import com.me.cardgame.Model.Board;
import com.me.cardgame.Model.Coordinate;
import com.me.cardgame.Model.Deck;
import com.me.cardgame.Model.GameCard;
import com.me.cardgame.Model.Neighbors;
import com.me.cardgame.Model.PlacedTunnelCard;
import com.me.cardgame.Model.Player;
import com.me.cardgame.Model.SelectedCards;
import com.me.cardgame.Model.TunnelCard;
import com.me.cardgame.Validation.BoardValidation;
import com.me.cardgame.Validation.HandValidation;
import com.me.cardgame.View.BoardView;
import com.me.cardgame.View.CardView;
import com.me.cardgame.View.HandView;
import com.me.cardgame.View.PlayerView;
import com.me.cardgame.View.PoolView;
import javafx.scene.paint.Color;

public class GameConrtoller extends InputAdapter {

    public Sprite testSprite;
    public Sprite boardSprite;

    private Coordinate boardCord;

    public BoardView boardView;
    public HandView handView;
    public CardView cardView;
    public PoolView poolView;
    public PlayerView playerView;
    
    public GameCard zoomCard;

    public GameCard cardToBePlaced;

    public SelectedCards selectedCards = new SelectedCards();
    public ArrayList<Coordinate> possiblePlaces = new ArrayList<Coordinate>();

    public PlacedTunnelCard tmpCard;

    StateMachineConfig<State, Trigger> roundConfig = new StateMachineConfig<State, Trigger>();
    StateMachine<State, Trigger> roundStateMachine;

    public Board board;

    private BoardValidation boardValidation = new BoardValidation();
    private HandValidation handValidation = new HandValidation();

    private final Integer BOARD_SIZE_X = 16;
    private final Integer BOARD_SIZE_Y = 10;

    private final Integer MAX_CARD_SELECTED = 3;

    private Game game;

    private Deck deck;

    private ArrayList<Player> playerList = new ArrayList<Player>();
    public Player currentPlayer;
    public Player anotherPlayer; //opponent

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    private Integer playersNumber;
    private Integer handSize;

    public GameConrtoller() {

        
        
        
        initStateMachine();

        playersNumber = 2;
        handSize = 6;

        // INICJALIZACJA SWIATA GRY
        init();

        // INICJALIZACJA GRY
        initPlayers(playersNumber);
        playerList.get(0).setName("PLAYER 1");
        playerList.get(1).setName("PLAYER 2");

        // INICJALIZACJA RUNDY
        deck.shuffle();
        roundStateMachine = new StateMachine<>(State.SelectActionType, roundConfig);

        dealCardsToPlayers();

    }

    private void initStateMachine() {

        roundConfig.configure(State.SelectActionType)
                .onEntry(this::selectActionEntry)
                .permit(Trigger.PlayActionCard, State.PlayActionCard)
                .permit(Trigger.DiscardCards, State.SelectCardForDiscard)
                .permit(Trigger.PlayTunnelCard, State.SelectCardForBoard);
        //.permit(Trigger.ActionSelect, State.HasSelectedCard);
        // .permit(Trigger.DiscardCards, State.SelectCardForDiscard);

        roundConfig.configure(State.PlayActionCard)
                .onEntry(this::playActionEntry)
                .permit(Trigger.ActionSelect, State.SelectActionType);
        //.permit(Trigger.ActionConfirmed, State.)

        roundConfig.configure(State.SelectCardForBoard)
                .onEntry(this::selectCardForBoard)
                .permit(Trigger.ActionConfirmed, State.SelectCardPlace)
                .permit(Trigger.ActionSelect, State.SelectActionType);

        roundConfig.configure(State.SelectCardPlace)
                .onEntry(this::selectCardPlace)
                .permit(Trigger.ActionConfirmed, State.PlayTunnelCard);
        //.permit(Trigger.ActionSelect, State.SelectActionType);

        roundConfig.configure(State.PlayTunnelCard)
                .onEntry(this::processCard)
                .permit(Trigger.CardProcessed, State.DrawCard);

        roundConfig.configure(State.SelectCardForDiscard)
                .onEntry(this::DiscardEntry)
                .permit(Trigger.ActionConfirmed, State.DiscardCards)
                .permit(Trigger.ActionSelect, State.SelectActionType);

        roundConfig.configure(State.DiscardCards)
                .onEntry(this::discardCards)
                .permit(Trigger.CardProcessed, State.DrawCard);

        roundConfig.configure(State.HasSelectedCard)
                .permitReentry(Trigger.ActionSelect)
                //				.permit(Trigger.CardSelected, State.HasSelectedCard)
                .permit(Trigger.CardDestinationSelected, State.PlayCard);

//        roundConfig.configure(State.SelectCardForDiscard)
//                .permitReentry(Trigger.ActionSelect)
//                //				.permit(Trigger.CardSelected, State.SelectCardForDiscard)
//                .permit(Trigger.DiscardConfirmed, State.DiscardCards);
        roundConfig.configure(State.PlayCard)
                .onEntry(this::processCard)
                .permit(Trigger.CardProcessed, State.DrawCard);

        roundConfig.configure(State.DrawCard)
                .onEntry(this::drawingCards)
                .onExit(this::drawingCardsDone)
                .permit(Trigger.RoundFinished, State.SelectActionType);

    }

    public void initPlayers(Integer playersNumber) {

        for (int p = 0; p < playersNumber; p++) {

            Player player = new Player();
            playerList.add(player);
        }

        playerList.get(0).setPlayerType(PlayerAllegianceEnum.Sabotauer);
        playerList.get(1).setPlayerType(PlayerAllegianceEnum.Digger);
        
        
        currentPlayer = playerList.get(0);
        anotherPlayer = playerList.get(1);
    }

    public void dealCardsToPlayers() {

        for (int s = 0; s < handSize; s++) {
            for (int d = 0; d < playerList.size(); d++) {

                playerList.get(d).getPlayerHand().getHand().add(deck.dealCard());

            }
        }
    }

    public void selectPlaterType() {
        for (int d = 0; d < playerList.size(); d++) {
          // TO DO, losowy wybor typu gracza. 
    }
    }
    
    public void pickCard() {

        while (currentPlayer.getPlayerHand().getHand().size() < handSize) {

            currentPlayer.getPlayerHand().getHand().add(deck.dealCard());
        }

    }

    public void init() {

        Gdx.input.setInputProcessor(this);

        handView = new HandView();

        deck = RunXmlGenerator.readDeckFromConfiguration();

        board = new Board(BOARD_SIZE_X, BOARD_SIZE_Y);
        board.initializeBoard();

        boardView = new BoardView();
        boardView.drawBoard();
        cardView = new CardView();
        poolView = new PoolView();
        playerView = new PlayerView();
      
        
    }

    public void update(float deltaTime) {
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        if (Coordinate.worldPart(screenX, screenY) == WorldPartEnum.BOARD) {
            // board.putCard(coord, card, isRotated);
            if (roundStateMachine.isInState(State.SelectCardForBoard)) {
                //Ignore
                System.out.println("Nie klikaj na boarda jak masz wybrac karte!");
                return false;
            }

            if (roundStateMachine.isInState(State.SelectCardPlace)) {
                boardCord = new Coordinate(Coordinate.getPixel(screenX, screenY).getX(),
                                Coordinate.getPixel(screenX, screenY).getY());
            }

            
            
            
        } else if (Coordinate.worldPart(screenX, screenY) == WorldPartEnum.HAND) {

            
            if (roundStateMachine.isInState(State.SelectCardForBoard) || roundStateMachine.isInState(State.SelectCardForDiscard)) {
            
            Coordinate cord = new Coordinate(Coordinate.getHandPixel(screenX, screenY).getX(),
                    Coordinate.getHandPixel(screenX, screenY).getY());

            if (cord.getX() < currentPlayer.getPlayerHand().getHand().size()
                    && handValidation.canMark(currentPlayer.getPlayerHand())
                    && !currentPlayer.getPlayerHand().getHand().get(cord.getX()).getIsMarked()) {

                currentPlayer.getPlayerHand().getHand().get(cord.getX()).markCard();

                selectedCards.getSelectedCards().add(currentPlayer.getPlayerHand().getHand().get(cord.getX()));

            } else if (cord.getX() < currentPlayer.getPlayerHand().getHand().size()
                    && currentPlayer.getPlayerHand().getHand().get(cord.getX()).getIsMarked()) {

                currentPlayer.getPlayerHand().getHand().get(cord.getX()).unMarkCard();
                //System.out.println( "ROZMIAR PRZED: " + selectedCards.getSelectedCards().size());
                selectedCards.removeCard(currentPlayer.getPlayerHand().getHand().get(cord.getX()));
                //   System.out.println( "ROZMIAR PO: " + selectedCards.getSelectedCards().size());

            }
            }
            else {return false;}
            if (roundStateMachine.isInState(State.SelectActionType)) {
                // System.out.println("Karta wybrana!");
                roundStateMachine.fire(Trigger.ActionSelect);
            }
        }

        // else System.out.println("NOTHING");
        return super.touchDown(screenX, screenY, pointer, button);

        // TESTOWANIE FUKCJI SPRWADZAJACEJ SASIADA
        // System.out.println("!!!SASIAD!!!");
        // boardValidation.findNeighbors(board, boardCord);
        // for (Direction direct : Direction.values()) {
        // System.out.println(direct.name() + ": " +
        // boardValidation.getNeighbors().getNeighbor(direct));
        // }
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {

        if (Coordinate.worldPart(screenX, screenY) == WorldPartEnum.BOARD) {
            possiblePlaces.clear();
        } else if (Coordinate.worldPart(screenX, screenY) == WorldPartEnum.HAND) {

            Coordinate cord = new Coordinate(Coordinate.getHandPixel(screenX, screenY).getX(),
                    Coordinate.getHandPixel(screenX, screenY).getY());

            if (cord.getX() < currentPlayer.getPlayerHand().getHand().size()) {

                zoomCard = currentPlayer.getPlayerHand().getCard(cord.getX());

            } else {
                zoomCard = null;
            }

            if (zoomCard instanceof TunnelCard && (roundStateMachine.isInState(State.SelectCardPlace) || roundStateMachine.isInState(State.SelectCardForBoard))) {
                tmpCard = new PlacedTunnelCard((TunnelCard) zoomCard, ((TunnelCard) zoomCard).getIsRotatted());

                possiblePlaces.clear();
                generatePossiblePlaces();

                //System.out.println("ILOSC DOSTEPNYCH POL " + possiblePlaces.size());
            } else {
                tmpCard = null;
                possiblePlaces.clear();
            }

        } else {

            zoomCard = null;
            possiblePlaces.clear();
        }

        return false;
    }

    public boolean keyUp(int keycode) {

        if (keycode == Input.Keys.ENTER && !roundStateMachine.isInState(State.SelectActionType)) {

            roundStateMachine.fire(Trigger.ActionConfirmed);

        }

        if (keycode == Input.Keys.A) {

            roundStateMachine.fire(Trigger.PlayActionCard);

        }

        if (keycode == Input.Keys.D) {

            roundStateMachine.fire(Trigger.DiscardCards);

        }

        if (keycode == Input.Keys.T) {

            roundStateMachine.fire(Trigger.PlayTunnelCard);

        }

        if ((roundStateMachine.isInState(State.PlayActionCard)
                || roundStateMachine.isInState(State.DiscardCards)
                || roundStateMachine.isInState(State.PlayTunnelCard)) && keycode == Input.Keys.BACKSPACE) {

            roundStateMachine.fire(Trigger.ActionSelect);

            if (selectedCards.getSelectedCards().size() != 0) {
                selectedCards.getSelectedCards().clear();
            }
        }

//        if (keycode == Input.Keys.A) {
//
//            //currentPlayer.getPlayerHand().discard();
//            
//           // System.out.println(selectedCards.getSelectedCards().size());
//            
//            currentPlayer.getPlayerHand().discard(selectedCards);
//             while (currentPlayer.getPlayerHand().getHandSieze() < 6) {
//                 pickCard();
//             }
//            
//            roundStateMachine.fire(Trigger.CardDestinationSelected);
//        }
        if (keycode == Input.Keys.Q && boardCord != null) {
            //System.out.println("STAN" + roundStateMachine.getState() );

            if (!roundStateMachine.isInState(State.HasSelectedCard)) {
                // System.out.println("Nie mozesz zagrac karty jak nie masz wybranej karty!");
                //ignore
                return false;
            }
            roundStateMachine.fire(Trigger.CardDestinationSelected);

        }

        if (keycode == Input.Keys.Z) {
            while (currentPlayer.getPlayerHand().getHandSieze() < 6) {
                pickCard();
            }
        }

        if (keycode == Input.Keys.R) {

            if (tmpCard != null) {
                tmpCard.setIsRotatted();
            }

            if (zoomCard != null) {
                ((TunnelCard) zoomCard).setIsRotatted();
                possiblePlaces.clear();
                generatePossiblePlaces();
            }

            if (selectedCards.getSelectedCards().size() != 0) {
                ((TunnelCard) selectedCards.getSelectedCards().get(0)).setIsRotatted();

            }
        }

        if (keycode == Input.Keys.V) {
            //System.out.println(selectedCards.getSelectedCards().size());
        }

        if (keycode == Input.Keys.T) {

//            System.out.println("!!TESTY!!");
//
//            System.out.println("BOARDCORD = " + boardCord.getX() + " " + boardCord.getY());
//              boardValidation.putCardValidation(board, (TunnelCard) zoomCard, boardCord);
//               for (Coordinate coord : Coordinate.allCoords()) {
//                   //System.out.println("CORDY " + coord.getX() + " " + coord.getY());
//                   
//                   if (boardValidation.globalHasAnyNeighbors(board, coord )){
//                        System.out.println(boardValidation.globalHasAnyNeighbors(board, coord ));
//                   }
//                   
//                  
//                   
//                   
//               }
//
//                Coordinate cord2 = new Coordinate(10, 4);
//                 boardValidation.findNeighbors(board, cord2, (TunnelCard)zoomCard);
//                System.out.println(boardValidation.getNeighbors().getNeighborMap().toString());
//              for (Direction direct : Direction.values()) {
//                  System.out.println("DLA " + direct);
//                  System.out.println( "WARTOSC DLA KIERUNKU "+ direct + " " +((TunnelCard)zoomCard).getWall(direct, Boolean.FALSE));
//                  System.out.println("POROWNYWANA SCIANA SASIADA " + boardValidation.getNeighbors().getNeighbor(direct));
//                  System.out.println("SCIANA ROZPATRYWANEJ KARTY " + ((TunnelCard)zoomCard).getWall(direct, Boolean.FALSE));
//                 // System.out.println(boardValidation.getNeighbors().checkIfNoConflicts((TunnelCard)zoomCard, Boolean.FALSE));
//                 // System.out.println(boardValidation.getNeighbors().checkWalls(((TunnelCard)zoomCard).getWall(direct, Boolean.FALSE), boardValidation.getNeighbors().getNeighbor(direct)));
//              }
//              
//               System.out.println(boardValidation.getNeighbors().checkIfNoConflicts((TunnelCard)zoomCard, Boolean.FALSE));
//              System.out.println(((TunnelCard)zoomCard).getWall(Direction.NORTH, Boolean.FALSE));
//              System.out.println(((TunnelCard)zoomCard).getWall(Direction.EAST, Boolean.FALSE));
//              System.out.println(((TunnelCard)zoomCard).getWall(Direction.SOUTH, Boolean.FALSE));
//              System.out.println(((TunnelCard)zoomCard).getWall(Direction.WEST, Boolean.FALSE));
            //System.out.println(boardValidation.getNeighbors().checkWalls(((TunnelCard)zoomCard).getWall(Direction.EAST, Boolean.TRUE), boardValidation.getNeighbors().getNeighbor(Direction.EAST)));
            // System.out.println("CZY ZAWIERA =" + Coordinate.allCoords().contains(cord2));
            //System.out.println(boardValidation.globalHasAnyNeighbors(board, cord2 ));
        }

        return false;
    }

    public void generatePossiblePlaces() {

        boardValidation.generatePossibleCords(board, (TunnelCard) zoomCard);
        possiblePlaces.addAll(boardValidation.getPossibleCords().getPossibleCords());

    }

    public void selectCardEntry() {
        System.out.println("selectCardEntry");
    }

    public void selectActionEntry() {
        System.out.println("SELECT ACTION STATE");

    }

    public void playActionEntry() {
        System.out.println("PLAY ACTION STATE");

    }

    public void selectCardForBoard() {
        System.out.println("WYBIERZ KARTE TUNNELU");

    }

    public void selectCardPlace() {
        System.out.println("Wybierz miejsce na tablicy");

    }
    
    public void playTunnelEntry() {
        System.out.println("Zagraj Karte");

    }
    
    
    
    
    
    public void DiscardEntry() {
        System.out.println("DISCARD STATE");

    }

    public void processCard() {

        //cardToBePlaced = currentPlayer.getPlayerHand().getCard(cord);
        //currentPlayer.getPlayerHand().putCard(board, boardCord);
        if (boardValidation.putCardValidation(board, (TunnelCard) selectedCards.getSelectedCards().get(0), boardCord)) {

            currentPlayer.getPlayerHand().putCardOnBoard(selectedCards, board, boardCord);
            selectedCards.getSelectedCards().clear();
            boardCord = null;
            currentPlayer.getPlayerHand().clearRotation(); // brak powoduje iz po przejsciu z rundy na runde jedna karta zostaje zaznaczona 
            // trzeba czyscic cord karty, ktora byla wczesniej zaznaczona
            roundStateMachine.fire(Trigger.CardProcessed);
        } else {
            // TO DO POWROT DO WYBORU CORDA
        }

    }

    public void discardCards() {

        currentPlayer.getPlayerHand().discard(selectedCards);
        selectedCards.getSelectedCards().clear();
        //System.out.println("ILE JEST WYBRANYCH KART " + selectedCards.getSelectedCards().size());
        roundStateMachine.fire(Trigger.CardProcessed);
    }

    public void drawingCards() {
        System.out.println("!!!!!!!!!!drawing cards!!!!!!!!!!");
        boardValidation.reverseEndCarad(board); // funckja odwracajaca karte
        pickCard();
        roundStateMachine.fire(Trigger.RoundFinished);
    }

    public void drawingCardsDone() {

       // boardValidation.reverseEndCarad(board);
        
        int currentPlayerIndex = playerList.indexOf(currentPlayer);
        //System.out.println("drawing cards done. Ending player turn: " + currentPlayer + ", current playerIndex " + currentPlayerIndex + ", size " + playerList.size());
        if (++currentPlayerIndex < playerList.size()) {
            currentPlayer = playerList.get(currentPlayerIndex);
            anotherPlayer = playerList.get(0);
        } else {
            currentPlayer = playerList.get(0);
            
            anotherPlayer = playerList.get(--currentPlayerIndex);
        }

        
        
        // System.out.println("drawing cards done. Next player: " + currentPlayer);
    }

    public Player playerChange() {

        int currentPlayerIndex = playerList.indexOf(currentPlayer);

        if (++currentPlayerIndex < playerList.size()) {
            currentPlayer = playerList.get(currentPlayerIndex);
        } else {
            currentPlayer = playerList.get(0);
        }
        return currentPlayer;
    }

}
