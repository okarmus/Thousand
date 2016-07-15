package org.okarmus.game.manager.game.builder

import org.okarmus.game.model.game.Game
import spock.lang.Specification

class GameBuilderTest extends Specification{

	GameBuilder underTest = new GameBuilder()
	
	def playerName = "Jedrej"
	
	def "should create game element"() {
		when:
			Game game = underTest.build(playerName)
		then:
			game.retrieveUserName() == playerName
	}
}
