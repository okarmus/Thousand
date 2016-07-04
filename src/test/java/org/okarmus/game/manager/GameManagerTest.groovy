package org.okarmus.game.manager

import java.util.concurrent.atomic.AtomicInteger
import org.okarmus.game.context.GameContext
import org.okarmus.game.manager.game.GameManager
import org.okarmus.game.manager.game.builder.GameBuilder
import org.okarmus.game.model.game.Game;

import spock.lang.Specification

class GameManagerTest extends Specification{

	GameManager gameManager;
	
	def setup() {
		GameBuilder builder = Mock()
		builder.build(_) >> new Game()
		gameManager = new GameManager(gameBuilder: builder,
									  context: new GameContext(gameSequence: new AtomicInteger(1))
									 );
	}
	
	def "should create sample game" () {
		given:
			def name = "Mateusz"
			def expected = 1
		when:
			def actual = gameManager.createGame()
		then:
			actual == expected
	}
}
