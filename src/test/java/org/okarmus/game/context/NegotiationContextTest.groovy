package org.okarmus.game.context

import java.util.concurrent.atomic.AtomicInteger

import org.okarmus.game.negotiation.model.Negotiation
import org.okarmus.game.utils.exception.NegotiationNotFoundException

import spock.lang.Specification

class NegotiationContextTest extends Specification {

	NegotiationContext underTest
	
	String exceptionMessage = "Negotiation can not be found"
	int expectedId = 0
	
	def setup() {
		underTest = new NegotiationContext(negotiationSequence: new AtomicInteger(), exceptionMessage: exceptionMessage)
	}
	
	def "should create negotiation" () {
		given:
			Negotiation expected = new Negotiation(null, null)
		when:
			underTest.addNegotiation(expected)
			def actual = underTest.negotiations.get(expectedId)
		then:
			actual == expected
	}
	
	def "should find negotiation with specified id"() {
		given:
			def expectedId = 13
			def expected =  new Negotiation(null, null)
			underTest.negotiations.put(13, expected)
		when:
			def actual = underTest.findNegotiation(expectedId)
		then:
			actual == expected
	}
	
	def "if negotiation is not found then exception should be thrown"() {
		given:
			def unknownId = 13
			def expected =  new Negotiation(null, null)
			underTest.negotiations.put(2, expected)
		when:
			def actual = underTest.findNegotiation(unknownId)
		then:
			thrown NegotiationNotFoundException
	}
	
}
