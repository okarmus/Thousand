package org.okarmus.game.model.player

import org.okarmus.game.model.card.Card
import org.okarmus.game.model.card.Color
import org.okarmus.game.model.card.Figure;
import spock.lang.Specification

class PlayerCardsTest extends Specification {

	def "should set player cards"() {
		when:
			PlayerCards playerCards = new PlayerCards()
			playerCards.setPlayerCards(sampleCards())
		then:
			playerCards.getPlayerCards() == sampleCards()
	}
	
	def sampleCards() {
		[new Card(color: Color.HEARTS, figure: Figure.KING), new Card(color: Color.DIAMONDS, figure: Figure.TEN)] as List<Card>
	}
}
