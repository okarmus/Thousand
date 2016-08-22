package org.okarmus.game.utils.comparator;

import java.util.Comparator;

import org.okarmus.game.model.card.Card;

public class CardComparator implements Comparator<Card>{

	@Override
	public int compare(Card c1, Card c2) {
		int colorCompare = c1.getColor().getPriority() - c2.getColor().getPriority();
		if (colorCompare != 0) {return colorCompare;}
		
		return c1.getValue() - c2.getValue();
	}
}
