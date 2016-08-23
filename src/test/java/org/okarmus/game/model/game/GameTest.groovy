package org.okarmus.game.model.game

import org.okarmus.game.model.card.Card
import org.okarmus.game.model.card.Color
import org.okarmus.game.model.card.Figure;
import org.okarmus.game.model.distribution.Distribution;
import org.okarmus.game.model.player.Player;
import org.okarmus.game.model.player.PlayerCards
import org.okarmus.game.model.player.PlayerType;
import java.util.List
import java.util.stream.Collectors;
import java.util.stream.Stream;
import spock.lang.Specification

class GameTest extends Specification {
	
	def sampleName = "Antoni"
	def cpu1Name = "CPU1"
	def cpu2Name = "CPU2"
	
	def "should create game from constructor" () {
		when:
			Game game = new Game(sampleName)
		then:
			game.retrieveUserName() == sampleName
			game.getUser().name == sampleName
			game.getUser().type == PlayerType.USER		
	}
		
	def "should set current distribution"() {
		given:
			Game game = new Game()
			Distribution distribution = Mock()
		when:
			game.setCurrentDist(distribution)
		then:
			game.getCurrentDist() == distribution
	}
	
	def "should return cards for player" () {
		given:
			def sampleCards = sampleCards()
			Distribution distribution = Mock()
			distribution.getCardsForPlayer(sampleName) >> sampleCards
			
			Game game = new Game(sampleName)
			game.setCurrentDist(distribution)
			
		when:
			def returnedCards = game.retrieveUserCards()
		then:
			returnedCards == sampleCards
			game.getCurrentDist() == distribution
	}
	
	def "should return list containing names of players"() {
		given:
			Game game = new Game(sampleName)
		when:
			def playerNames = game.retrievePlayerNames()
		then:
			playerNames.size() == 3
			playerNames.contains(sampleName)
			playerNames.contains(cpu1Name)
			playerNames.contains(cpu2Name)
	}
	
	
	def sampleCards() {
		return new PlayerCards(cards: [new Card(color: Color.HEARTS, figure: Figure.KING), new Card(color: Color.DIAMONDS, figure: Figure.TEN)])
	}
	
	def samplePlayers() {
		return Stream.of(new Player("CPU1", PlayerType.CPU), new Player("CPU2", PlayerType.CPU),new Player(sampleName, PlayerType.USER)).collect(Collectors.toList())
	}
}
