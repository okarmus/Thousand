package org.okarmus.game.manager.distribution.pile

import java.util.stream.Collectors;

import org.okarmus.game.configuration.DeckConfiguration
import org.okarmus.game.model.card.Card
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = DeckConfiguration.class)
class CardsPileTest extends Specification {

	CardsPile underTest
	
	@Autowired
	List<Card> cards;
	CardRandomizer randomizer
	
	def setup()  {
		randomizer = Mock()
		underTest = new CardsPile(cards)
		underTest.randomizer = randomizer
	}
	
	def "should retrieve proper elements" () {
		given:
			def randomizerReturns = randomizerReturns()
			List<Integer> uniqueReturns = unique(randomizerReturns)
		
			randomizer.chooseRandomCard() >>> randomizerReturns
		expect:
			uniqueReturns.stream()
				.forEach {i -> assert underTest.next() == cards.get(i)}
	}
	
	def "should return proper has next value"(pile, result) {
		given:
			underTest.pile = pile
		expect:
			underTest.hasNext() == result
		where:
			pile 			|| result
			[] as Map		|| false
			[12: new Card()]|| true		
	}
	
	def randomizerReturns() {
		return [1, 2, 2, 3, 1, 3, 4, 5, 7, 7, 8, 7, 1]
	}
	
	def unique(List<Integer> list) {
		return list.stream().distinct().collect(Collectors.toList());
	}
}
