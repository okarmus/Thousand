package org.okarmus.game.model.card

import spock.lang.Specification

class CardTest extends Specification {

	def sampleColor = Color.SPADES
	def sampleFigure = Figure.ACE
	def sampleValue = 11
	
	def "should create model from setters"() {
		when:
			Card card = new Card()
			card.setColor(sampleColor)
			card.setFigure(sampleFigure)
			card.setValue(sampleValue)
		then:
			card.getColor() == sampleColor
			card.getFigure() == sampleFigure
			card.getValue() == sampleValue
	}
	
	def "should crate model from setters" () {
		when:
			Card card = new Card(sampleColor, sampleFigure, sampleValue)
		then:
			card.getColor() == sampleColor
			card.getFigure() == sampleFigure
			card.toString() == "Card [color=SPADES, figure=ACE, value=11]"
	}
}
