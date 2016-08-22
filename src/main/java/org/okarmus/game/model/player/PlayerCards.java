package org.okarmus.game.model.player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.okarmus.game.model.card.Card;
import org.okarmus.game.utils.comparator.CardComparator;

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

	public PlayerCards order() {
		PlayerCards playerCards = new PlayerCards();
		playerCards.setPlayerName(playerName);
		playerCards.setCards(sortCards());
		
		return playerCards;
	}

	private List<Card> sortCards() {
		return cards.stream()
			.sorted(new CardComparator())
			.collect(Collectors.toList());
	}
}
