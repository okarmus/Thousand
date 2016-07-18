package org.okarmus.game.model.distribution;

import java.util.Map;

import org.okarmus.game.model.player.PlayerCards;
import org.okarmus.game.model.player.Prikup;

public class Distribution {
	
	private Map<String,PlayerCards> playersCards;
	private Prikup prikup;
	
	public Distribution(Map<String, PlayerCards> playersCards, Prikup prikup) {
		this.playersCards = playersCards;
		this.prikup = prikup;
	}

	public PlayerCards getCardsForPlayer(String playerName) {
		return playersCards.get(playerName);
	}

	public Map<String, PlayerCards> getPlayersCards() {
		return playersCards;
	}

	public void setPlayersCards(Map<String, PlayerCards> playersCards) {
		this.playersCards = playersCards;
	}

	public Prikup getPrikup() {
		return prikup;
	}

	public void setPrikup(Prikup prikup) {
		this.prikup = prikup;
	}
}
