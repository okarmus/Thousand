package org.okarmus.game.model;

import java.util.Map;

public class Distribution {
	
	private Map<String,PlayerCards> playersCards;
	
	
	public PlayerCards getCardsForPlayer(String playerName) {
		return playersCards.get(playerName);
	}

	public Map<String, PlayerCards> getPlayersCards() {
		return playersCards;
	}

	public void setPlayersCards(Map<String, PlayerCards> playersCards) {
		this.playersCards = playersCards;
	}
}
