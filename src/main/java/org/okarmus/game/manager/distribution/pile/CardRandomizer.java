package org.okarmus.game.manager.distribution.pile;

import java.util.Random;

public class CardRandomizer {
	
	private Random random;
	private int cardsNumber;
	
	public CardRandomizer(Random random, int cardsNumber) {
		this.random = random;
		this.cardsNumber = cardsNumber;
	}

	public int chooseRandomCard() {
		return random.nextInt(cardsNumber);
	}
}
