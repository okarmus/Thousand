package org.okarmus.game.manager

import org.okarmus.game.model.Game
import org.okarmus.game.model.builder.GameBuilder;

import spock.lang.Specification

class GameManagerTest extends Specification{

	GameManager gameManager;
	
	def setup() {
		GameBuilder builder = Mock()
		builder.build(_) >> new Game()
		gameManager = new GameManager(gameBuilder: builder)
	}
	
	def "should create sample game" () {
		given:
			def name = "Mateusz"
			def expected = 0
		when:
			def actual = gameManager.createGame()
		then:
			actual == expected
	}
}
