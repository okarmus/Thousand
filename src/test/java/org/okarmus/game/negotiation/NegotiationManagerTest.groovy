package org.okarmus.game.negotiation

import static java.util.Arrays.asList
import static org.okarmus.game.model.player.PlayerType.*

import org.okarmus.game.context.GameContext
import org.okarmus.game.context.NegotiationContext
import org.okarmus.game.model.game.Game
import org.okarmus.game.model.player.Player
import org.okarmus.game.negotiation.builder.NegotiationBuilder
import org.okarmus.game.negotiation.model.Negotiation
import org.okarmus.game.negotiation.model.NegotiationPlayer
import org.okarmus.game.negotiation.model.NegotiationResource

import spock.lang.Specification

class NegotiationManagerTest extends Specification{

	NegotiationManager underTest
	
	GameContext gameCtx = Mock()
	NegotiationContext negotiationCtx = Mock()
	NegotiationBuilder builder = Mock()
	NegotiationDecider decider = Mock()
	
	def negotiationId = 14
	def score = 120
	
	def setup() {
		underTest = new NegotiationManager(gameCtx: gameCtx, negotiationCtx: negotiationCtx, negotiationBuilder: builder, decider: decider)
	}
	
	def "should create negotiation element"() {
		given:
			def game = new Game()
			def negotiation = new Negotiation(null, null)
			def gameId = 12
			gameCtx.findGame(gameId) >> game
			builder.build(game) >> negotiation	
		when:
			underTest.createNegotiation(gameId)
		then:
			1* negotiationCtx.addNegotiation(negotiation)
	}
	
	def "user raise should be performed"() {
		given:
			NegotiationPlayer user = Mock()
			NegotiationPlayer cpu1 = Mock()
			NegotiationPlayer cpu2 = Mock()
		
			Negotiation negotiation = new Negotiation(user, asList(cpu1, cpu2))
					
			negotiationCtx.findNegotiation(negotiationId) >> negotiation
			cpu1.isNegotiating() >> true
			cpu2.isNegotiating() >> false
		when:
			underTest.handleUserRaise(negotiationId, score)
		then:
			1 * user.raise(score)
			1 * cpu1.decideOnNegotiation(negotiation, decider)
			0 * cpu2.decideOnNegotiation(negotiation, decider)
	}
	
	def "user pass should be performed"() {
		given:
			NegotiationPlayer user = Mock()
			NegotiationPlayer cpu1 = Mock()
			NegotiationPlayer cpu2 = Mock()
	
			Negotiation negotiation = new Negotiation(user, asList(cpu1, cpu2))
				
			negotiationCtx.findNegotiation(negotiationId) >> negotiation
			cpu1.isNegotiating() >>> [true, true, true, true, false, false]
			cpu2.isNegotiating() >>> [true, true, false, false, false, false]
		when:
			underTest.handleUserPass(negotiationId)
		then:
			1 * user.pass()
			1 * cpu1.decideOnNegotiation(negotiation, decider)
			1 * cpu2.decideOnNegotiation(negotiation, decider)
	}
	
	def "should retrieve negotiaton status"() {
		given:
			def finished = true
			
			def userPoints = 120
			NegotiationPlayer user = mockedNegotiationPlayerWithPoints(userPoints)
			
			def cpu1Points = 100
			NegotiationPlayer cpu1 = mockedNegotiationPlayerWithPoints(cpu1Points)
			
			def cpu2Points = 180
			NegotiationPlayer cpu2 = mockedNegotiationPlayerWithPoints(cpu2Points)
			
			Negotiation negotiation = Mock()
			negotiation.checkFinished() >> finished
			negotiation.getUser() >> user
			
			negotiation.getCpus() >> [cpu1, cpu2]
				
			negotiationCtx.findNegotiation(negotiationId) >> negotiation
		when:
			NegotiationResource status = underTest.retrieveStatus(negotiationId);
		then:	
			status.finished
			status.getUserBet() == userPoints
			status.getCpusBet().size() == 2
			status.getCpusBet().contains(cpu1Points)
			status.getCpusBet().contains(cpu2Points)
	}
	
	def "negotiation should be finished"() {
		given:
			Negotiation negotiation = Mock()
			negotiationCtx.findNegotiation(negotiationId) >> negotiation
		when:
			underTest.finish(negotiationId)
		then:
		 1 * negotiation.finish()
	}
	
	def negotiation() {
		return new Negotiation(negotiationPlayer("Andrzej", USER), Arrays.asList(negotiationPlayer("cpu1", CPU), negotiationPlayer("cpu2", CPU)))
	}
	
	def negotiationPlayer(name, type) {
		return new NegotiationPlayer(new Player(name, type), Collections.emptyList());
	}
	
	def mockedNegotiationPlayerWithPoints(points) {
		NegotiationPlayer player = Mock()
		player.getPoints() >> points
		return player;
	}
		
	
	
}
