package org.okarmus.game.model.distribution

import org.okarmus.game.model.card.Card
import org.okarmus.game.model.card.Color
import org.okarmus.game.model.card.Figure;
import org.okarmus.game.model.player.PlayerCards
import org.okarmus.game.model.player.Prikup
import spock.lang.Specification

class DistributionTest extends Specification {
	
	def "should return cards for player" () {
		when:
			def expectedCards = janekCards()
			def expectedPrikup = prikup()
			Distribution underTest = new Distribution(cardsMap(expectedCards), expectedPrikup)
		then:
			underTest.getCardsForPlayer('Janek') == expectedCards
			underTest.getPrikup() == expectedPrikup
	}
	
	def cardsMap(expectedCards) {
		return [ Janek: expectedCards, Pawel: pawelCards(), maciek: maciekCards()]
	}
	
	def prikup() {
		return new Prikup()
	}
	
	def janekCards() {
		return new PlayerCards(playerName:"Janek", cards: [new Card(color: Color.CLUBS, figure: Figure.KING, value:5), new Card(color: Color.HEARTS, figure: Figure.QUEEN, value: 4)])
	}
	
	def pawelCards() {
		return new PlayerCards(cards: [new Card(color: Color.CLUBS, figure: Figure.QUEEN, value: 4), new Card(color: Color.HEARTS, figure: Figure.ACE, value: 11)])
	}
	
	def maciekCards() {
		return new PlayerCards(cards: [new Card(color: Color.SPADES, figure: Figure.QUEEN, value: 4), new Card(color: Color.SPADES, figure: Figure.QUEEN, value: 4)])
	}
}
