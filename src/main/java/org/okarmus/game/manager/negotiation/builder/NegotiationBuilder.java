package org.okarmus.game.manager.negotiation.builder;

import org.okarmus.game.model.game.Game;
import org.okarmus.game.model.negotiation.Negotiation;
import org.springframework.stereotype.Service;

@Service
public class NegotiationBuilder {

	public Negotiation build(Game game){
		return new Negotiation(null, null); //TODO this is not working!!
	}
}
