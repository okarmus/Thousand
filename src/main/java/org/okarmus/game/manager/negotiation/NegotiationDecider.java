package org.okarmus.game.manager.negotiation;

import java.util.Optional;

import org.okarmus.game.model.negotiation.Negotiation;
import org.springframework.stereotype.Component;

@Component
public class NegotiationDecider {
	
	int cpu1Bumps;
	int cpu2Bumps;

	public Optional<Integer> decide(String playerName,Negotiation negotiation) {		//TODO this interface has to be changed
		if (playerName.equals("CPU1")){
			return bumpsNrDecision(playerName, ++cpu1Bumps, 2, negotiation);
			
		}
		return bumpsNrDecision(playerName, ++cpu2Bumps, 3, negotiation);
	}
	
	private Optional<Integer> bumpsNrDecision(String playerName, int bumpsSoFar, int maxBumps, Negotiation negotiation) {
		if (bumpsSoFar <= maxBumps) {
			int points = negotiation.findMax() + 10;
			return Optional.of(points);
		}
		return Optional.empty();
	}
}
