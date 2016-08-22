package org.okarmus.game.model.card

import spock.lang.Specification

class ColorTest extends Specification {
	Color underTest
	
	def "should contains proper values"() {
		expect:
			Color.DIAMONDS.getColor() == "diamonds"
			Color.DIAMONDS.getPriority() == 2
			
			Color.HEARTS.getColor() == "hearts"
			Color.HEARTS.getPriority() == 3
			
			Color.CLUBS.getColor() == "clubs"
			Color.CLUBS.getPriority() == 1
			
			Color.SPADES.getColor() == "spades"
			Color.SPADES.getPriority() == 0
	}
}
