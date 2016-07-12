package org.okarmus.game.model.card

import spock.lang.Specification

class CardTest extends Specification {

	def sampleColor = Color.SPADES
	def sampleFigure = Figure.ACE
	
	def "should create model from setters"() {
		when:
			Card card = new Card()
			card.setColor(sampleColor)
			card.setFigure(sampleFigure)
		then:
			card.getColor() == sampleColor
			card.getFigure() == sampleFigure
	}
	
	def "should crate model from setters" () {
		when:
			Card card = new Card(sampleColor, sampleFigure)
		then:
			card.getColor() == sampleColor
			card.getFigure() == sampleFigure
			card.toString() == "Card [color=spades, figure=ace]"
	}
}
