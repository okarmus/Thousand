package org.okarmus.game.negotiation.model

import java.util.stream.Collectors;
import java.util.stream.Stream

import org.apache.catalina.realm.JNDIRealm.User;

import spock.lang.Specification

class NegotiationTest extends Specification {
	
	def "should create negotiation instance"() {
		given:
			NegotiationPlayer user = Mock()
			List<NegotiationPlayer> cpus = Mock()
		when:
			Negotiation negotiation = new Negotiation(user, cpus)
		then:
			negotiation.getUser() == user
			negotiation.getCpus() == cpus
	}
	
	def "should find negotiating cpus"() {
		given:
			NegotiationPlayer user = Mock()
			def negotiating = createPlayer(true)
			def notNegotiating = createPlayer(false)
			List<NegotiationPlayer> cpus = [negotiating, notNegotiating]
		when:
			Negotiation negotiation = new Negotiation(user, cpus)
		then:
			def negotiatingCpus = negotiation.findNegotiatingCpus()
			negotiatingCpus.size() == 1
			negotiatingCpus.get(0) == negotiating
	}
	
	def "should return player stream"() {
		given:
			NegotiationPlayer user = Mock()
			NegotiationPlayer cpu1 = Mock()
			NegotiationPlayer cpu2 = Mock()
			Negotiation underTest = new Negotiation(user, Arrays.asList(cpu1, cpu2))
		when:
			List<NegotiationPlayer> players = underTest.playersStream().collect(Collectors.toList());
		then:
			players.size() == 3
			players.contains(user)
			players.contains(cpu1)
			players.contains(cpu2)
	}
	
	def "should find maximum value"() {
		given:
			def expectedValue = 180
			def user = negotiationPlayer(100)
			def cpu1 = negotiationPlayer(expectedValue)
			def cpu2 = negotiationPlayer(120)
			Negotiation underTest = new Negotiation(user, Arrays.asList(cpu1, cpu2))
		when:
			def actualValue = underTest.findMax()
		then:
			actualValue == expectedValue
	}

	def negotiationPlayer(points) {
		def player = new NegotiationPlayer(null, null)
		player.points = points
		return player
	}
	
	private NegotiationPlayer createPlayer(negotiating) {
		NegotiationPlayer player = Mock()
		player.isNegotiating() >> negotiating
		return player
	}
}
