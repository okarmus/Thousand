package org.okarmus.game.model.card

import spock.lang.Specification

class CardDeckTest extends Specification {
	
	def "should build card deck element" () {
		given:
			List<Card> cards = [new Card(Color.SPADES, Figure.ACE), new Card(Color.CLUBS, Figure.JACK), new Card(Color.HEARTS, Figure.NINE)]
		when:
			CardDeck deck = new CardDeck()
			deck.setCards(cards)
		then:
			deck.getCards() == cards
			deck.toString() == "CardDeck [cards=[Card [color=spades, figure=ace], Card [color=clubs, figure=jack], Card [color=hearts, figure=nine]]]"
	}
}

