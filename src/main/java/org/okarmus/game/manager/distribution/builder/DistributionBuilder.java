package org.okarmus.game.manager.distribution.builder;

import java.util.List;
import java.util.Map;
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
		return distributeCards(game);
	}
	
	@Lookup
	protected CardsPile createCardsPile(){
		//Spring will override this method
		return null;
	}

	private Distribution distributeCards(Game game) {	// part of the logic should be moved to distriburtion
		CardsPile cardsPile = createCardsPile();
		
		List<PlayerCards> distributedCards = emptyDistributedCards(game);
		Prikup prikup = new Prikup();
		
		int index = 0;
		
		while(cardsPile.hasNext()) {
			Card card = cardsPile.next(); 
			
			if (!prikup.isComplete()) {					//this logic could be moved to distriburion
				prikup.addCard(card);
			}else{
				distributedCards.get(index).addCard(card);
				index++;
				index %= 3;
			}
		}
		
		Distribution distribution = new Distribution();
		distribution.setPlayersCards(distributedCards.stream().collect(Collectors.toMap(p -> p.getPlayerName(), p -> p)));
		
		return distribution;
	}

	private List<PlayerCards> emptyDistributedCards(Game game) {
		return game.retrievePlayerNames()
				.stream()
				.map(name -> new PlayerCards(name))
				.collect(Collectors.toList());
	}
}
