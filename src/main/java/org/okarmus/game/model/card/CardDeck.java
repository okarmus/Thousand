package org.okarmus.game.model.card;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CardDeck {
	
	@Autowired
	private List<Card> cards;

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		return "CardDeck [cards=" + cards + "]";
	}
}
