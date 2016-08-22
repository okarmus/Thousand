package org.okarmus.game.context;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.okarmus.game.model.game.Game;
import org.okarmus.game.model.negotiation.Negotiation;
import org.okarmus.game.utils.annotation.Context;
import org.okarmus.game.utils.exception.NegotiationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Context
public class NegotiationContext {

	@Autowired
	private AtomicInteger negotiationSequence;
	
	@Value("${negotiation.not.found}")
	private String exceptionMessage;
	
	private Map<Integer,Negotiation> negotiations;
	
	public NegotiationContext() {
		this.negotiations = new HashMap<>();
	}
	
	public int addNegotiation(Negotiation negotiation) {
		int negotiationId = negotiationSequence.getAndIncrement();
		negotiations.put(negotiationId, negotiation);
		return negotiationId;
	}

	public Negotiation findNegotiation(int negotiationId) {
		return negotiations.computeIfAbsent(negotiationId, (id) -> {throw new NegotiationNotFoundException(exceptionMessage);});
	}
}
