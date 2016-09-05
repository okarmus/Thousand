package org.okarmus.game.negotiation.model

import static org.okarmus.game.model.player.PlayerType.USER

import org.okarmus.game.model.card.Card
import org.okarmus.game.model.player.Player
import org.okarmus.game.model.player.PlayerType
import org.okarmus.game.negotiation.NegotiationDecider

import spock.lang.Specification

class NegotiationPlayerTest extends Specification {
	
	def name = "Johny"
	def type = USER
	Player player = new Player(name, type)
	def cards = [new Card(), new Card()]
	
	def points = 150
	
	def "player should stop negotiation"(decision, isNegotiating, point) {
		given:
			NegotiationDecider decider = Mock()
			Negotiation negotiation = new Negotiation(null, null)
			decider.decide(name, negotiation) >> decision
			
			NegotiationPlayer underTest = new NegotiationPlayer(player, cards)
		expect:
			underTest.decideOnNegotiation(negotiation, decider)
			underTest.isNegotiating() == isNegotiating
			underTest.getPoints() == point	
		where:
			decision 		 || isNegotiating | point
			Optional.empty() || false 		  | 0
			Optional.of(140) || true		  | 140
		}
	
	def "should create proper elements" () {
		when:
			NegotiationPlayer underTest = new NegotiationPlayer(player, cards)
		then:
			underTest.getPlayer() == player
			underTest.getCards() == cards
			underTest.isNegotiating()
			underTest.getPoints() == 0
			underTest.getPlayerName() == name	
	}
	
	def "should stop negotiation" () {
		given:
			NegotiationPlayer underTest = new NegotiationPlayer(player, cards)
		when:
			underTest.pass()
		then:
			!underTest.isNegotiating()
	}

	def "should raise points" () {
		given:
			NegotiationPlayer underTest = new NegotiationPlayer(player, cards)
		when:
			underTest.raise(points)
		then:
			underTest.getPoints() == points
	}
	
	def "should fill winning info in player"() {
		given:
			def points = 180
			NegotiationPlayer underTest = new NegotiationPlayer(player, cards)
			underTest.points = points
		when:
			underTest.fillWinningInfo()
		then:
			player.getRequiredPoints() == points
			player.isNegotiationWinner()	
	}
}
