package org.okarmus.game.model.player

import org.okarmus.game.model.card.Card
import org.okarmus.game.model.card.Color
import org.okarmus.game.model.card.Figure;
import spock.lang.Specification

class PlayerCardsTest extends Specification {

	def sampleName = "Lamka"
	def kingCard = new Card(color: Color.HEARTS, figure: Figure.KING)
	def tenCard = new Card(color: Color.DIAMONDS, figure: Figure.TEN)
	
	def "should set player cards"() {
		when:
			PlayerCards playerCards = new PlayerCards()
			playerCards.setCards(sampleCards())
			playerCards.setPlayerName(sampleName)
		then:
			playerCards.getCards() == sampleCards()
			playerCards.getPlayerName() == sampleName
	}
	
	def sampleCards() {
		[kingCard, tenCard] as List<Card>
	}
	
	def "should create player cards for player and add new card" () {
		given:
			PlayerCards playerCards = new PlayerCards(sampleName)
		when:
			playerCards.addCard(kingCard)
			playerCards.addCard(tenCard)
		then:
			playerCards.getCards() == sampleCards()
			playerCards.getPlayerName() == sampleName
	}
	
}
