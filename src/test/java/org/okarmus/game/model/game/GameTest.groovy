package org.okarmus.game.model.game

import org.okarmus.game.model.card.Card
import org.okarmus.game.model.card.Color
import org.okarmus.game.model.card.Figure;
import org.okarmus.game.model.distribution.Distribution;
import org.okarmus.game.model.player.Player;
import org.okarmus.game.model.player.PlayerCards
import org.okarmus.game.model.player.PlayerType;
import spock.lang.Specification

class GameTest extends Specification {
	
	def sampleName = "Antoni"
	def cpu1Name = "CPU1"
	def cpu2Name = "CPU2"
	
	def "should create game from constructor" () {
		when:
			Game game = new Game(sampleName)
		then:
			game.getCpu1().name == cpu1Name
			game.getCpu2().type == PlayerType.CPU
			game.getCpu2().name == cpu2Name
			game.getCpu2().type == PlayerType.CPU
			game.getUser().name == sampleName
			game.getUser().type == PlayerType.USER
	}
	
	def "should create game from setters" () {
		when:
		Game game = new Game()
		game.setCpu1(new Player("CPU1", PlayerType.CPU))
		game.setCpu2(new Player("CPU2", PlayerType.CPU))
		game.setUser(new Player(sampleName, PlayerType.USER))
	then:
		game.getCpu1().name == cpu1Name
		game.getCpu2().type == PlayerType.CPU
		game.getCpu2().name == cpu2Name
		game.getCpu2().type == PlayerType.CPU
		game.getUser().name == sampleName
		game.getUser().type == PlayerType.USER
	}
	
	def "should return cards for player" () {
		given:
			Distribution distribution = Mock()
			distribution.getCardsForPlayer(sampleName) >> sampleCards()
			
			Game game = new Game(sampleName)
			game.setCurrentDist(distribution)
			
		when:
			def returnedCards = game.getPlayerCards()
		then:
			returnedCards == sampleCards()
	}
	
	def sampleCards() {
		return new PlayerCards(playerCards: [new Card(color: Color.HEARTS, figure: Figure.KING), new Card(color: Color.DIAMONDS, figure: Figure.TEN)])
	}
}
