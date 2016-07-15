package org.okarmus.game.model.player;

import java.util.ArrayList;
import java.util.List;

import org.okarmus.game.model.card.Card;

public class Prikup {
	private static final int CARDS_NUMBER = 3;
	
	private List<Card> cards;

	public Prikup() {
		this.cards = new ArrayList<>();
	}

	public void addCard(Card card) {
		this.cards.add(card);
	}
	
	public boolean isComplete() {
		return CARDS_NUMBER == cards.size();
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
}
