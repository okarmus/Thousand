package org.okarmus.game.manager.distribution.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.okarmus.game.manager.distribution.pile.CardsPile;
import org.okarmus.game.model.card.Card;
import org.okarmus.game.model.distribution.Distribution;
import org.okarmus.game.model.game.Game;
import org.okarmus.game.model.player.PlayerCards;
import org.okarmus.game.model.player.Prikup;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

@Service
public class DistributionBuilder {

	public Distribution build(Game game) {
		CardsPile cardsPile = createCardsPile();

		List<PlayerCards> distributedCards = emptyDistributedCards(game);
		Prikup prikup = new Prikup();

		int index = 0;
		while(cardsPile.hasNext()) {
			Card card = cardsPile.next(); 

			if (!prikup.isComplete()) {
				prikup.addCard(card);
			}else{
				distributedCards.get(index).addCard(card);
				index = (index+1) % 3;
			}
		}

		return new Distribution(distributedCards.stream().collect(Collectors.toMap(p -> p.getPlayerName(), p -> p)), prikup);
	}

	@Lookup
	protected CardsPile createCardsPile(){
		return null;
	}


	private List<PlayerCards> emptyDistributedCards(Game game) {
		return game.retrievePlayerNames()
				.stream()
				.map(name -> new PlayerCards(name))
				.collect(Collectors.toList());
	}
}
