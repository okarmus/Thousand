package org.okarmus.game.manager.negotiation;

import org.okarmus.game.context.GameContext;
import org.okarmus.game.context.NegotiationContext;
import org.okarmus.game.manager.negotiation.builder.NegotiationBuilder;
import org.okarmus.game.model.game.Game;
import org.okarmus.game.model.negotiation.Negotiation;
import org.okarmus.game.model.negotiation.NegotiationPlayer;
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
	
	public void performUserRaise(int negotiationId, int score) {
		Negotiation negotiation = findNegotiation(negotiationId);
		negotiation.getUser().raise(score);			//TODO to moze tez powinno zostac przeniesione do obiektu negotiation
		
		performCpuNegotiations(negotiation);
	}
	
	public void performUserPass(int negotiationId) {
		Negotiation negotiation = findNegotiation(negotiationId);
		negotiation.getUser().pass();
		
		while(!checkFinished(negotiationId)) {
			performCpuNegotiations(negotiation);
		}
	}
	
	public boolean checkFinished(int negotiationId) {
		Negotiation negotiation = findNegotiation(negotiationId);
		
		long negotiatorsNumber = negotiation.playersStream()
									.filter(NegotiationPlayer::isNegotiating)
									.count();
		return negotiatorsNumber < 2;
	}
	
	private void performCpuNegotiations(Negotiation negotiation) {
		negotiation.findNegotiatingCpus()
			.stream()
			.forEach((player) -> player.decideOnNegotiation(negotiation, decider));
	}
	
	private Negotiation findNegotiation(int id) {
		return negotiationCtx.findNegotiation(id);
	}
}
