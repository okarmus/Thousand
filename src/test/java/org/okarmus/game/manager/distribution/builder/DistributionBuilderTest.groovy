package org.okarmus.game.manager.distribution.builder

import org.okarmus.ThousandApplication

import org.okarmus.game.configuration.DeckConfiguration
import org.okarmus.game.configuration.ThousandConfiguration;
import org.okarmus.game.manager.distribution.pile.CardsPile
import org.okarmus.game.model.card.Card
import org.okarmus.game.model.card.CardDeck
import org.okarmus.game.model.game.Game
import org.okarmus.game.model.player.Player;
import org.okarmus.game.model.player.PlayerType;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.web.WebAppConfiguration;

import spock.lang.Ignore
import spock.lang.Specification

@ContextConfiguration(classes = ThousandApplication.class)
@TestPropertySource("classpath:application.properties")
class DistributionBuilderTest extends Specification {

	@Autowired
	DistributionBuilder underTest
	
	@Autowired
	List<Card> cards
	
	@Autowired
	CardsPile cardsPile
	
	CardDeck deck = Mock()
	def sampleUser = "Jedrzej"
	
	def setup() {
		deck.getCards() >> cards
	}
	
	def "should build distribution for game"() {
		given:
			def game = game()
		when:
			def distribution = underTest.build(game)
		then:
			distribution.playersCards.containsKey(sampleUser)
			def playerCards = distribution.playersCards.get(sampleUser)
			playerCards.cards.size() == 7
			distribution.prikup.cards.size() == 3			
	}
	
	def "proper cards pile should be returned"() {
		expect: 
			underTest.createCardsPile() != null
			underTest.createCardsPile() != underTest.createCardsPile()
	}
	
	def game() {
		return new Game(user: new Player(sampleUser, PlayerType.USER), cpus: [new Player("cpu1", PlayerType.CPU), new Player("cpu2", PlayerType.CPU)])
	}	
}
