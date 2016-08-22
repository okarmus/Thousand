package org.okarmus.game.manager.negotiation

import org.okarmus.game.context.GameContext
import org.okarmus.game.context.NegotiationContext
import org.okarmus.game.manager.negotiation.builder.NegotiationBuilder;
import org.okarmus.game.model.game.Game
import org.okarmus.game.model.negotiation.Negotiation
import org.okarmus.game.model.negotiation.NegotiationPlayer;
import org.okarmus.game.model.player.Player

import static org.okarmus.game.model.player.PlayerType.*
import static java.util.Arrays.asList

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
			underTest.performUserRaise(negotiationId, score)
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
			underTest.performUserPass(negotiationId)
		then:
			1 * user.pass()
			1 * cpu1.decideOnNegotiation(negotiation, decider)
			1 * cpu2.decideOnNegotiation(negotiation, decider)
	}
	
	
	def negotiation() {
		return new Negotiation(negotiationPlayer("Andrzej", USER), Arrays.asList(negotiationPlayer("cpu1", CPU), negotiationPlayer("cpu2", CPU)))
	}
	
	def negotiationPlayer(name, type) {
		return new NegotiationPlayer(new Player(name, type), Collections.emptyList());
	}
}
