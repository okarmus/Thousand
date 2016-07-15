package org.okarmus.game.model.player;

import java.util.ArrayList;
import java.util.List;

import org.okarmus.game.model.card.Card;

public class PlayerCards {
	
	private String playerName;
	private List<Card> cards;

	public PlayerCards() { }
	
	public PlayerCards(String playerName) {
		this.playerName = playerName;
		this.cards = new ArrayList<>();
	}
	
	public void addCard(Card card) {
		this.cards.add(card);
	}
	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> playerCards) {
		this.cards = playerCards;
	}

	@Override
	public String toString() {
		return "PlayerCards [playerName=" + playerName + ", cards=" + cards + "]";
	}
}
