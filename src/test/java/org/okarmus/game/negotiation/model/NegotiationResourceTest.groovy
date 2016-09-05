package org.okarmus.game.negotiation.model

import java.util.List;
import spock.lang.Specification

class NegotiationResourceTest extends Specification {
	
	def userBet = 140;
	def cpusBet = [120, 110];
	def finished = true;
	
	def "should create under test using constructor"() {
		when:
			NegotiationResource underTest = new NegotiationResource(userBet, cpusBet, finished)
		then:
			underTest.getUserBet() == userBet
			underTest.getCpusBet() == cpusBet
			underTest.isFinished() == finished
	}
	
	def "should create under test using getters and setters"() {
		when:
			NegotiationResource underTest = new NegotiationResource()
			underTest.setUserBet(userBet)
			underTest.setCpusBet(cpusBet)
			underTest.setFinished(finished)
		then:
			underTest.getUserBet() == userBet
			underTest.getCpusBet() == cpusBet
			underTest.isFinished() == finished
	}
	
}
