package org.okarmus.game.manager.distribution

import org.okarmus.game.context.GameContext
import org.okarmus.game.manager.distribution.builder.DistributionBuilder
import org.okarmus.game.model.distribution.Distribution
import org.okarmus.game.model.game.Game
import org.okarmus.game.model.player.PlayerCards
import org.okarmus.game.utils.exception.GameNotFoundException
import spock.lang.Specification

class DistributionManagerTest extends Specification{
	
	DistributionManager underTest
	
	GameContext context = Mock()
	DistributionBuilder distributionBuilder = Mock()
	
	def sampleId = 32
	
	def setup() {
		underTest = new DistributionManager(context: context, distributionBuilder: distributionBuilder)
	}
	
	def "should return error when there is no game with specified id"() {
		given:
			context.retrieveGame(sampleId) >> Optional.empty()
		when:
			underTest.createDistribution(sampleId)
		then:
			thrown(GameNotFoundException)
	}
	
	def "should build distribution"() {
		given:
			Game game = game()
			PlayerCards expectedCards = playerCards()
			game.retrieveUserCards() >> expectedCards
			Distribution distribution = distribution()
			context.retrieveGame(sampleId) >> Optional.of(game)
			distributionBuilder.build(game) >> distribution
		when: 
			PlayerCards actualCards = underTest.createDistribution(sampleId)
		then:
			1*game.setCurrentDist(distribution)
			actualCards == expectedCards
	}
	
	def game() {
		Game game = Mock()
		
		return game
	}
	
	def distribution() {
		return new Distribution()
	}
	
	def playerCards() {
		return new PlayerCards()
	}
}
