package org.okarmus.game.manager.distribution.pile;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.okarmus.game.model.card.Card;
import org.springframework.beans.factory.annotation.Autowired;

public class CardsPile {
	
	@Autowired
	private CardRandomizer randomizer;
	
	private Map<Integer,Card> pile;
	
	public CardsPile(List<Card> cards) {
		this.pile = IntStream.range(0,cards.size())
			             .boxed()
			             .collect(Collectors.toMap (i -> i, i -> cards.get(i)));
		
	}
	
	public boolean hasNext() {
		return !pile.isEmpty();
	}
	
	public Card next() {
		return pile.remove(findNotSelectedCard());
	}
	
	private int findNotSelectedCard() {
		int random = randomizer.chooseRandomCard();
		while (!pile.containsKey(random)) {
			random = randomizer.chooseRandomCard();
		}
		return random;
	}
}
