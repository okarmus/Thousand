package org.okarmus.game.utils.comparator

import org.okarmus.game.model.card.Card
import org.okarmus.game.model.card.Color
import org.okarmus.game.model.card.Figure;;
import spock.lang.Specification

class CardComparatorTest extends Specification{

	CardComparator underTest = new CardComparator()
	
	def "should return proper value"(c1, c2, result) {
		expect:
			underTest.compare(c1, c2) == result
		where:
			c1 		   | c2         || result
			new Card(Color.CLUBS, Figure.ACE, 11)   | new Card(Color.CLUBS, Figure.ACE, 11) 	|| 0	//The same cards
			new Card(Color.HEARTS, Figure.ACE, 11)  | new Card(Color.DIAMONDS, Figure.ACE, 11)	|| 1	//Color difference
			new Card(Color.HEARTS, Figure.QUEEN, 4) | new Card(Color.HEARTS, Figure.ACE, 11)	|| -7   //Card difference
	}
}
