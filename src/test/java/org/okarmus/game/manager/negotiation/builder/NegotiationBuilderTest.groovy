package org.okarmus.game.manager.negotiation.builder

import org.okarmus.game.model.game.Game
import spock.lang.Specification

class NegotiationBuilderTest extends Specification {

	NegotiationBuilder underTest = new NegotiationBuilder()
	
	def "should build negotiation" () {
		given:
			def negotiation = underTest.build(new Game())
		expect:
			negotiation != null	
	}	
}
