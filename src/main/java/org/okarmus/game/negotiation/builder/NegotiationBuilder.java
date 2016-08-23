package org.okarmus.game.negotiation.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.okarmus.game.model.card.Card;
import org.okarmus.game.model.game.Game;
import org.okarmus.game.model.player.Player;
import org.okarmus.game.negotiation.model.Negotiation;
import org.okarmus.game.negotiation.model.NegotiationPlayer;
import org.springframework.stereotype.Service;

@Service
public class NegotiationBuilder {

	public Negotiation build(Game game) {
		NegotiationPlayer negotiationUser = buildNegotiationPlayer(game.getUser(), game);
		List<NegotiationPlayer> negotiationCpus = buildNegotiationCpus(game);
		
		return new Negotiation(negotiationUser, negotiationCpus);
	}

	private List<NegotiationPlayer> buildNegotiationCpus(Game game) {
		return game.getCpus().stream()
					.map(player -> buildNegotiationPlayer(player, game))
					.collect(Collectors.toList());
	}
	
	private NegotiationPlayer buildNegotiationPlayer(Player player, Game game) {
		String playerName = player.getName();
		List<Card> cards = game.getCurrentDist().getCardsForPlayer(playerName).getCards();
		
		return new NegotiationPlayer(player, cards);
	}
}
