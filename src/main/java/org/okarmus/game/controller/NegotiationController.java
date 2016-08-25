package org.okarmus.game.controller;

import org.okarmus.game.negotiation.NegotiationManager;
import org.okarmus.game.negotiation.model.Negotiation;
import org.okarmus.game.negotiation.model.NegotiationResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/negotiation")
public class NegotiationController {
	
	@Autowired
	private NegotiationManager negotiationManager;
	
	@RequestMapping("/create/{gameId}")
	public HttpEntity<Integer> createNewNegotiaion(@PathVariable int gameId) {	
		int negotiationId = negotiationManager.createNegotiation(gameId);
		return new ResponseEntity<>(negotiationId, HttpStatus.OK);
	}
	
	@RequestMapping("/raise/{negotiationId}/{score}")
	public HttpEntity<NegotiationResource> userRaise(@PathVariable int negotiationId, @PathVariable int score) {
		negotiationManager.handleUserRaise(negotiationId, score);
		NegotiationResource negotiationStatus = negotiationManager.retrieveStatus(negotiationId);
		return new ResponseEntity<>(negotiationStatus, HttpStatus.OK);
	}
	
	@RequestMapping("/pass/{negotiationId}")
	public HttpEntity<NegotiationResource> userPass(@PathVariable int negotiationId) {
		negotiationManager.handleUserPass(negotiationId);
		NegotiationResource negotiationStatus = negotiationManager.retrieveStatus(negotiationId);
		return new ResponseEntity<>(negotiationStatus, HttpStatus.OK);
	}
	
	@RequestMapping("/status/{negotiationId}")
	public HttpEntity<Negotiation> displayStatus(@PathVariable int negotiationId) {
		return new ResponseEntity<>(negotiationManager.findNegotiation(negotiationId), HttpStatus.OK);
	}
}
