package org.okarmus.game.negotiation;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.okarmus.game.negotiation.model.Negotiation;
import org.springframework.stereotype.Component;

@Component
public class NegotiationDecider {
	private static final Logger LOG = Logger.getLogger(NegotiationDecider.class);
	

	public Optional<Integer> decide(String playerName,Negotiation negotiation) {		//TODO this interface has to be changed
		Optional<Integer> decision = Optional.empty();
		
		if (!negotiation.checkFinished() && playerName.equals("CPU1")){
			decision = bumpsNrDecision(playerName, 140, negotiation); 
			
			
		}
		if (!negotiation.checkFinished() && playerName.equals("CPU2")) {
			decision = bumpsNrDecision(playerName, 160, negotiation);
		}
		
		if (!decision.isPresent()) {
			LOG.info("cos sie podzialo");
		}
		
		LOG.info(playerName + " decision " + decision.orElse(0));
		
		return decision;
	}
	
	private Optional<Integer> bumpsNrDecision(String playerName, int playerLimit, Negotiation negotiation) {
		int max = negotiation.findMax();
		
		if (playerLimit > max) {
			int points = max + 10;
			return Optional.of(points);
		}
		return Optional.empty();
	}
}
