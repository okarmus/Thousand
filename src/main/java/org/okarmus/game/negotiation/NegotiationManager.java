package org.okarmus.game.negotiation;

import org.okarmus.game.context.GameContext;
import org.okarmus.game.context.NegotiationContext;
import org.okarmus.game.model.game.Game;
import org.okarmus.game.negotiation.builder.NegotiationBuilder;
import org.okarmus.game.negotiation.model.Negotiation;
import org.okarmus.game.utils.annotation.Manager;
import org.springframework.beans.factory.annotation.Autowired;

@Manager
public class NegotiationManager {
	
	@Autowired
	private GameContext gameCtx;

	@Autowired
	private NegotiationContext negotiationCtx;
	
	@Autowired
	private NegotiationBuilder negotiationBuilder;
	
	@Autowired
	private NegotiationDecider decider;
		
	public int createNegotiation(int gameId){
		Game game = gameCtx.findGame(gameId);
		return negotiationCtx.addNegotiation(negotiationBuilder.build(game));
	}
	
	public void handleUserRaise(int negotiationId, int score) {
		Negotiation negotiation = findNegotiation(negotiationId);
		negotiation.userRaise(score);
		negotiation.cpusNegotiations(decider);
	}
	
	public void performUserPass(int negotiationId) {
		Negotiation negotiation = findNegotiation(negotiationId);
		negotiation.userPass();

		while(!checkFinished(negotiationId)) {
			negotiation.cpusNegotiations(decider);
		}
	}
	
	public boolean checkFinished(int negotiationId) {
		Negotiation negotiation = findNegotiation(negotiationId);
		return negotiation.checkFinished();
	}
	
	private Negotiation findNegotiation(int id) {
		return negotiationCtx.findNegotiation(id);
	}
}
