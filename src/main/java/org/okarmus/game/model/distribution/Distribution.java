package org.okarmus.game.model.distribution;

import java.util.Map;

import org.okarmus.game.model.player.PlayerCards;

public class Distribution {
	
	private Map<String,PlayerCards> playersCards;
	/*private PlayerCards prikup;*/
		
	
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
