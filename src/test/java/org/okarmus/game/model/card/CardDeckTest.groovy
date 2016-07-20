package org.okarmus.game.model.card

import spock.lang.Specification

class CardDeckTest extends Specification {
	
	def "should build card deck element" () {
		given:
			List<Card> cards = [new Card(Color.SPADES, Figure.ACE, 11), new Card(Color.CLUBS, Figure.JACK, 2), new Card(Color.HEARTS, Figure.NINE, 0)]
		when:
			CardDeck deck = new CardDeck()
			deck.setCards(cards)
		then:
			deck.getCards() == cards
			deck.toString() == "CardDeck [cards=[Card [color=SPADES, figure=ACE, value=11], Card [color=CLUBS, figure=JACK, value=2], Card [color=HEARTS, figure=NINE, value=0]]]"
	}
}

