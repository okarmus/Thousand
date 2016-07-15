package org.okarmus.game.context

import java.util.concurrent.atomic.AtomicInteger
import org.junit.internal.Classes;
import org.junit.runner.RunWith
import org.okarmus.game.model.game.Game
import org.okarmus.game.model.player.Player
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.ContextConfiguration;

import spock.lang.Specification

class GameContextTest extends Specification{
	
	GameContext underTest
	AtomicInteger gameSequence
	
	int expectedId = 0
	
	def setup() {
		underTest = new GameContext(gameSequence: new AtomicInteger())
	}
	
	def "should add new game and return id"(){
		given:
			Game expectedGame = new Game(players: [new Player(), new Player(), new Player()])
		when:
			def actualId = underTest.addGame(expectedGame)
			def actualGame = underTest.retrieveGame(actualId).get()
		then:
			actualId == expectedId
			actualGame == expectedGame
	}
}
