package org.okarmus.game.manager.distribution.builder

import org.okarmus.ThousandApplication
import org.okarmus.game.configuration.DeckConfiguration;
import org.okarmus.game.model.card.Card
import org.okarmus.game.model.card.CardDeck
import org.okarmus.game.model.game.Game
import org.okarmus.game.model.player.Player;
import org.okarmus.game.model.player.PlayerType;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = DeckConfiguration.class)
class DistributionBuilderTest extends Specification {

	DistributionBuilder underTest
	
	@Autowired
	List<Card> cards
	
	CardDeck deck = Mock()
	def sampleUser = "Jedrzej"
	
	def setup() {
		deck.getCards() >> cards
		underTest = new DistributionBuilder(cardDeck: deck)
	}
	
	def "should build distribution for game"() {
		given:
			def game = game()
		when:
			def distribution = underTest.build(game)
		then:
			distribution.playersCards.containsKey(sampleUser)
			def playerCards = distribution.playersCards.get(sampleUser)
			playerCards.playerCards.size() == 7			
	}
	
	def game() {
		return new Game(user: new Player(sampleUser, PlayerType.USER))
	}
	
}
