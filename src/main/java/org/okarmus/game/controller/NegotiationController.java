package org.okarmus.game.controller;

import org.okarmus.game.negotiation.NegotiationManager;
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
	
	@RequestMapping("/{gameId}/create")
	public HttpEntity<Integer> createNewNegotiaion(@PathVariable int gameId) {	
		int negotiationId = negotiationManager.createNegotiation(gameId);
		return new ResponseEntity<>(negotiationId, HttpStatus.OK);
	}
}
