package com.me.cardgame.Model;

import java.util.ArrayList;

import com.me.cardgame.Enums.PlayerAllegianceEnum;

public class Player {

	private String name;
	private Integer playerId;
	private Boolean buildStatus; // TODO - do wywalenia -> kazdorazowo
									// ewaluowane w modelu przy nadejsciu tury
									// gracza - ciezko utrzymac spojny model jak
									// zapisujesz to zmiennych
	private Integer gold;
	private Hand playerHand;
	private Pool playerPool = new Pool();
	private PlayerAllegianceEnum playerType; // TODO enum PlayerAllegianceEnum

	private static Integer num = 1;

	private ArrayList<GameCard> playerSpace = new ArrayList<GameCard>();

	public Player() {

		playerHand = new Hand();
		playerId = num;
		num++;
		buildStatus = true;// TODO remove

		gold = 0;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the playerId
	 */
	public Integer getPlayerId() {
		return playerId;
	}

	/**
	 * @param playerId
	 *            the playerId to set
	 */
	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	/**
	 * @return the buildStatus
	 */
	public boolean isBuildStatus() {
		return buildStatus;
	}

	/**
	 * @param buildStatus
	 *            the buildStatus to set
	 */
	public void setBuildStatus(boolean buildStatus) {
		this.buildStatus = buildStatus;
	}

	/**
	 * @return the gold
	 */
	public Integer getGold() {
		return gold;
	}

	/**
	 * @param gold
	 *            the gold to set
	 */
	public void setGold(Integer gold) {
		this.gold = gold;
	}

	/**
	 * @return the playerHand
	 */
	public Hand getPlayerHand() {
		return playerHand;
	}

	/**
	 * @param playerHand
	 *            the playerHand to set
	 */
	public void setPlayerHand(Hand playerHand) {
		this.playerHand = playerHand;
	}

	/**
	 * @return the buildStatus
	 */
	public Boolean getBuildStatus() {
		return buildStatus;
	}

	/**
	 * @param buildStatus
	 *            the buildStatus to set
	 */
	public void setBuildStatus(Boolean buildStatus) {
		this.buildStatus = buildStatus;
	}

	/**
	 * @return the playerType
	 */
	public PlayerAllegianceEnum getPlayerType() {
		return playerType;
	}

	/**
	 * @param playerType
	 *            the playerType to set
	 */
	public void setPlayerType(PlayerAllegianceEnum playerType) {
		this.playerType = playerType;
	}

	/**
	 * @return the playerSpace
	 */
	public ArrayList<GameCard> getPlayerSpace() {
		return playerSpace;
	}

	/**
	 * @param playerSpace
	 *            the playerSpace to set
	 */
	public void setPlayerSpace(ArrayList<GameCard> playerSpace) {
		this.playerSpace = playerSpace;
	}
}
