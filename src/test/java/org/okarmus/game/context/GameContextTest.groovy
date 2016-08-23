package org.okarmus.game.context

import java.util.concurrent.atomic.AtomicInteger
import org.junit.internal.Classes;
import org.junit.runner.RunWith
import org.okarmus.game.model.game.Game
import org.okarmus.game.model.player.Player
import org.okarmus.game.utils.exception.GameNotFoundException;
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.ContextConfiguration;

import spock.lang.Specification

class GameContextTest extends Specification{
	
	GameContext underTest
	
	String exceptionMessage = "Game can not be found"
	int expectedId = 0
	
	def setup() {
		underTest = new GameContext(gameSequence: new AtomicInteger(), exceptionMessage: exceptionMessage)
	}
	
	def "should add new game and return id"(){
		given:
			Game expectedGame = new Game(user: new Player(), cpus: [new Player(), new Player()])
		when:
			def actualId = underTest.addGame(expectedGame)
			def actualGame = underTest.findGame(actualId)
		then:
			actualId == expectedId
			actualGame == expectedGame
	}
	
	def "should find a game with specified id"() {
		given:
			def gameId = 12
			Game expectedGame = new Game(user: new Player(), cpus: [new Player(), new Player()])
			underTest.currentGames.put(12, expectedGame)
		when:
			def actualGame = underTest.findGame(gameId)
		then:
			actualGame == expectedGame
	}
	
	def "if game is found then exception should be thrown"() {
		given:
			def unknownId =13
			Game expectedGame = new Game(user: new Player(), cpus: [new Player(), new Player()])
			underTest.currentGames.put(12, expectedGame)
		when:
			def actualGame = underTest.findGame(unknownId)
		then:
			thrown GameNotFoundException
	}
}
