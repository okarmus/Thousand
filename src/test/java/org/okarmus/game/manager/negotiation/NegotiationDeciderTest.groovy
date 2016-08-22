package org.okarmus.game.manager.negotiation

import org.okarmus.game.model.negotiation.Negotiation
import spock.lang.Specification

class NegotiationDeciderTest extends Specification {
	
	NegotiationDecider underTest = new NegotiationDecider()
	
	
	def "should negotiate in proper way"() {
		given:
			def cpu1 = "CPU1"
			def cpu2 = "CPU2"
		
			Negotiation negotiation = Mock()
			negotiation.findMax() >>> [100, 110, 120, 130, 140, 150, 160]
				
		expect:
			assertDecisionPresent(underTest.decide(cpu1, negotiation), 110)			
			assertDecisionPresent(underTest.decide(cpu2, negotiation), 120)
			assertDecisionPresent(underTest.decide(cpu1, negotiation), 130)
			assertDecisionPresent(underTest.decide(cpu2, negotiation), 140)
			assertDecisionAbsent(underTest.decide(cpu1, negotiation))
			assertDecisionPresent(underTest.decide(cpu2, negotiation), 150)
			assertDecisionAbsent(underTest.decide(cpu2, negotiation))
	}
	
	
	def assertDecisionPresent(Optional<Integer> decision, score) {
		decision.isPresent()
		decision.get() == score
	}
	
	def assertDecisionAbsent(Optional<Integer> decision) {
		!decision.isPresent()
	}
	

}
