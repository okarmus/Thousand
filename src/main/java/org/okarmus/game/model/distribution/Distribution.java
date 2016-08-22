package org.okarmus.game.model.distribution;

import java.util.Map;

import org.okarmus.game.model.player.PlayerCards;
import org.okarmus.game.model.player.Prikup;

public class Distribution {
	
	private Map<String,PlayerCards> playersCards;				//TODO maybe it should be merged to common player data
	//private Map<String,DistributionScore> distributionScores;
	
	private Prikup prikup;
	
	public Distribution(Map<String, PlayerCards> playersCards, Prikup prikup) {
		this.playersCards = playersCards;
		this.prikup = prikup;
	}

	public PlayerCards getCardsForPlayer(String playerName) {
		return playersCards.get(playerName);
	}

	public Prikup getPrikup() {
		return prikup;
	}
}
