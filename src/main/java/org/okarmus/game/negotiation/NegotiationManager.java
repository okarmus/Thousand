package org.okarmus.game.negotiation;

import java.util.List;
import java.util.stream.Collectors;

import org.okarmus.game.context.GameContext;
import org.okarmus.game.context.NegotiationContext;
import org.okarmus.game.model.game.Game;
import org.okarmus.game.negotiation.builder.NegotiationBuilder;
import org.okarmus.game.negotiation.model.Negotiation;
import org.okarmus.game.negotiation.model.NegotiationPlayer;
import org.okarmus.game.negotiation.model.NegotiationResource;
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
	
	public void handleUserPass(int negotiationId) {
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
	
	public Negotiation findNegotiation(int id) {
		return negotiationCtx.findNegotiation(id);
	}
	
	public NegotiationResource retrieveStatus(int negotiationId) {
		Negotiation negotiation = findNegotiation(negotiationId);
		boolean finished = negotiation.checkFinished();
		int userBet = negotiation.getUser().getPoints();
		List<Integer> cpusBet = negotiation.getCpus().stream().map(NegotiationPlayer::getPoints).collect(Collectors.toList());
		
		return new NegotiationResource(userBet, cpusBet, finished);
	}
}
