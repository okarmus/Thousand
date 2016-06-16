package org.okarmus.game.model.builder;

import java.util.HashMap;
import java.util.Map;

import org.okarmus.game.model.Distribution;
import org.okarmus.game.model.Game;
import org.okarmus.game.model.PlayerCards;
import org.okarmus.game.model.card.CardDeck;
import org.springframework.beans.factory.annotation.Autowired;

public class DistributionBuilder {
	
	@Autowired
	private CardDeck cardDeck;
	
	public Distribution build(Game game) {
		Distribution distribution = new Distribution();
		distribution.setPlayersCards(distributeCards(game));
		return distribution;
	}

	private Map<String, PlayerCards> distributeCards(Game game) {
		Map<String, PlayerCards> cards = new HashMap<>();
		PlayerCards playerCards = new PlayerCards();
		playerCards.setPlayerCards(cardDeck.getCards().subList(0, 7)); //firts seven cards - should be moved randomizedc
		cards.put(game.getUser().getName(), playerCards);
		return cards;
	}

}
