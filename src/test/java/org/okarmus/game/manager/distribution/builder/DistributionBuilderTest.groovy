package org.okarmus.game.manager.distribution.builder

import org.okarmus.ThousandApplication
import org.okarmus.game.configuration.DeckConfiguration
import org.okarmus.game.configuration.ThousandConfiguration;
import org.okarmus.game.model.card.Card
import org.okarmus.game.model.card.CardDeck
import org.okarmus.game.model.game.Game
import org.okarmus.game.model.player.Player;
import org.okarmus.game.model.player.PlayerType;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration;

import spock.lang.Ignore
import spock.lang.Specification

@ContextConfiguration(classes = [ThousandConfiguration.class, DeckConfiguration.class])
class DistributionBuilderTest extends Specification {

	DistributionBuilder underTest
	
	@Autowired
	List<Card> cards
	
	CardDeck deck = Mock()
	def sampleUser = "Jedrzej"
	
	def setup() {
		deck.getCards() >> cards
		underTest = new DistributionBuilder()
	}
	
	@Ignore
	def "should build distribution for game"() {
		given:
			def game = game()
		when:
			def distribution = underTest.build(game)
		then:
			distribution.playersCards.containsKey(sampleUser)
			def playerCards = distribution.playersCards.get(sampleUser)
			playerCards.cards.size() == 7			
	}
	
	def game() {
		return new Game(players: [new Player(sampleUser, PlayerType.USER)])
	}
	
}
