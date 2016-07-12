package org.okarmus.game.model.distribution

import org.okarmus.game.model.card.Card
import org.okarmus.game.model.card.Color
import org.okarmus.game.model.card.Figure;
import org.okarmus.game.model.player.PlayerCards
import spock.lang.Specification

class DistributionTest extends Specification {
	
	def "should return cards for player" () {
		when:
			Distribution underTest = new Distribution()
			underTest.setPlayersCards(cardsMap())
		then:
			underTest.getCardsForPlayer('Janek') == janekCards()		
	}
	
	def cardsMap() {
		return [ Janek: janekCards(), Pawel: pawelCards(), maciek: maciekCards()]
	}
	
	def janekCards() {
		return new PlayerCards(playerCards: [new Card(color: Color.CLUBS, figure: Figure.KING), new Card(color: Color.HEARTS, figure: Figure.QUEEN)])
	}
	
	def pawelCards() {
		return new PlayerCards(playerCards: [new Card(color: Color.CLUBS, figure: Figure.QUEEN), new Card(color: Color.HEARTS, figure: Figure.ACE)])
	}
	
	def maciekCards() {
		return new PlayerCards(playerCards: [new Card(color: Color.SPADES, figure: Figure.QUEEN), new Card(color: Color.SPADES, figure: Figure.QUEEN)])
	}
}
