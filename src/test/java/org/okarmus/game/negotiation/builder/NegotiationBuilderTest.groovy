package org.okarmus.game.negotiation.builder

import org.okarmus.game.model.card.Card
import org.okarmus.game.model.distribution.Distribution
import org.okarmus.game.model.game.Game
import org.okarmus.game.model.player.Player
import org.okarmus.game.model.player.PlayerCards
import org.okarmus.game.model.player.PlayerType;

import static org.okarmus.game.model.player.PlayerType.*;

import spock.lang.Ignore
import spock.lang.Specification

class NegotiationBuilderTest extends Specification {

	NegotiationBuilder underTest = new NegotiationBuilder()
	
	def userName = "Marian"
	List<Card> userCards = []
	
	def cpu1Name = "CPU1"
	List<Card> cpu1Cards = []
	
	def cpu2Name = "CPU2"
	List<Card> cpu2Cards = []
	

	def "should build negotiation" () {
		given:
			def negotiation = underTest.build(game())
		expect:
			negotiation.getUser().getCards() == userCards
			negotiation.getUser().isNegotiating()
			negotiation.getUser().getPlayerName() == userName
			negotiation.getUser().getPlayer().getType() == USER
			
			negotiation.getCpus().size() == 2
			
			negotiation.getCpus().get(0).getCards() == cpu1Cards
			negotiation.getCpus().get(0).isNegotiating()
			negotiation.getCpus().get(0).getPlayerName() == "CPU1"
			negotiation.getCpus().get(0).getPlayer().getType() == CPU
			
			negotiation.getCpus().get(1).getCards() == cpu2Cards
			negotiation.getCpus().get(1).isNegotiating()
			negotiation.getCpus().get(1).getPlayerName() == "CPU2"
			negotiation.getCpus().get(1).getPlayer().getType() == CPU
	}
	
	def game() {
		Game game = new Game(userName)
		game.setCurrentDist(distribution())
		return game
	}
	
	def distribution() {
		Distribution distribution = Mock()
		distribution.getCardsForPlayer(userName) >> new PlayerCards(cards: userCards)
		distribution.getCardsForPlayer(cpu1Name) >> new PlayerCards(cards: cpu1Cards)
		distribution.getCardsForPlayer(cpu2Name) >> new PlayerCards(cards: cpu2Cards)
		return distribution
	}
}
