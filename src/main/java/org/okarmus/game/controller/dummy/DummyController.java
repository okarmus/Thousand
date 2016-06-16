package org.okarmus.game.controller.dummy;

import org.okarmus.game.model.card.CardDeck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dummy")
public class DummyController {
	
	@Autowired
	private CardDeck cardDeck;
	
	@RequestMapping("/deck")
	public CardDeck getAvailableCardDeck() {
		return cardDeck;
	}

}
