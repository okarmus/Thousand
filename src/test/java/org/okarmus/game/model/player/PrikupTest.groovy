package org.okarmus.game.model.player

import org.okarmus.game.model.card.Card
import org.okarmus.game.model.card.Color
import org.okarmus.game.model.card.Figure;

import spock.lang.Specification

class PrikupTest extends Specification {
	
	Prikup underTest
	List<Card> cards

	def setup() {
		cards = Mock()
		underTest = new Prikup(cards: cards)
	}
	
	def "should add card to prikup"() {
		given:
			Card card = new Card(Color.CLUBS, Figure.ACE, 11)
		when:
			underTest.addCard(card)
		then:
			1 * cards.add(card)
	}
	
	def "should return true where there are enough cards"() {
		given:
			cards.size() >> 3
		expect:
			underTest.isComplete()
	}
	
	def "should return false where there are not enough cards"() {
		given:
			cards.size() >> 2
		expect:
			!underTest.isComplete()
	}
	
	def "should return cards" () {
		expect:
			underTest.getCards() == cards
	}
}
