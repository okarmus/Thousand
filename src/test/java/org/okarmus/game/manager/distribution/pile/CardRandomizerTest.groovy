package org.okarmus.game.manager.distribution.pile

import spock.lang.Specification

class CardRandomizerTest extends Specification {

	CardRandomizer underTest
	Random random
	
	def cardsNumber = 23
	
	def setup() {
		random = Mock()
		underTest = new CardRandomizer(random, cardsNumber)
	}
	
	def "should return expected number" () {
		given:
			def randomNumbers = randomNumbers()
			random.nextInt(cardsNumber) >>> randomNumbers
		expect:
			for (def number in randomNumbers) {
				assert underTest.chooseRandomCard() == number
			}
	}
	
	def randomNumbers() {
		return [12, 2, 3, 4, 5 ,6]
	}
}
