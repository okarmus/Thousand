package org.okarmus.game.negotiation.model;

import java.util.List;
import java.util.Optional;

import org.okarmus.game.model.card.Card;
import org.okarmus.game.model.player.Player;
import org.okarmus.game.negotiation.NegotiationDecider;

public class NegotiationPlayer {

	private Player player;
	private List<Card> cards;
	private boolean negotiating;
	private int points;
	
	public NegotiationPlayer(Player player, List<Card> cards) {
		this.player = player;
		this.cards = cards;
		this.negotiating = true;
		this.points = 0;
	}
	
	public void decideOnNegotiation(Negotiation negotiation, NegotiationDecider decider) {
		Optional<Integer> optionalRaise = decider.decide(getPlayerName(), negotiation);
		
		if (optionalRaise.isPresent()){
			raise(optionalRaise.get());
		} else {
			pass();
		}
	}
	
	public void fillWinningInfo() {
		player.setNegotiationWinner(true);
		player.setRequiredPoints(points);
	}
	
	public void raise(int points) {
		this.points = points;
	}
	
	public void pass() {
		this.negotiating = false;
	}

	public Player getPlayer() {
		return player;
	}
	
	public List<Card> getCards() {
		return cards;
	}

	public boolean isNegotiating() {
		return negotiating;
	}

	public int getPoints() {
		return points;
	}

	public String getPlayerName() {
		return player.getName();
	}	
}
