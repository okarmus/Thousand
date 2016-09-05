package org.okarmus.game.negotiation.model

import java.util.stream.Collectors;
import java.util.stream.Stream

import org.apache.catalina.realm.JNDIRealm.User
import org.okarmus.game.negotiation.NegotiationDecider;

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
	
	def "should perform user raise"() {
		given:
			NegotiationPlayer user = Mock()
			List<NegotiationPlayer> cpus = Mock()
		
			Negotiation negotiation = new Negotiation(user, cpus)
			def score = 120
		when:
			negotiation.userRaise(score)
		then:
			1 * user.raise(score)
	}
	
	def "should perform user pass"() {
		given:
			NegotiationPlayer user = Mock()
			List<NegotiationPlayer> cpus = Mock()
		
			Negotiation negotiation = new Negotiation(user, cpus)
		when:
			negotiation.userPass()
		then:
			1 * user.pass()
	}
	
	def "should perform negotiation for cpus"() {
		given:
			NegotiationPlayer user = Mock()
			def negotiating = createPlayer(true)
			def notNegotiating = createPlayer(false)
			List<NegotiationPlayer> cpus = [negotiating, notNegotiating]
			
			Negotiation negotiation = new Negotiation(user, cpus)
			NegotiationDecider decider = Mock()
		when:
			def negotiatingCpus = negotiation.cpusNegotiations(decider)
		then:
			1 * negotiating.decideOnNegotiation(negotiation, decider)
			0 * notNegotiating.decideOnNegotiation(negotiation, decider)
	}
	
	def "should check if negotiation is finished"(Negotiation negotiation, result) { 	
		expect:
			negotiation.checkFinished() == result
		where:
			negotiation 																				 || result
			new Negotiation(createPlayer(true), Arrays.asList(createPlayer(false), createPlayer(true)))	 || false
			new Negotiation(createPlayer(false), Arrays.asList(createPlayer(false), createPlayer(true))) || true
			new Negotiation(createPlayer(false), Arrays.asList(createPlayer(false), createPlayer(false)))|| true		
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
	
	def "should finish negotiation and designate winner"() {
		given:
			def userPoints = 180
			NegotiationPlayer user = Mock() 
			user.getPoints() >> userPoints
			
			def cpu1Points = 120
			NegotiationPlayer cpu1 = Mock()
			cpu1.getPoints() >> cpu1Points
			
			def cpu2Points = 140
			NegotiationPlayer cpu2 = Mock()
			cpu2.getPoints() >> cpu2Points
			
			Negotiation underTest = new Negotiation(user, Arrays.asList(cpu1, cpu2))
		when:
			underTest.finish()
		then:
			1 * user.fillWinningInfo()
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
