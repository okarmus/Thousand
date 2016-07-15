package org.okarmus.game.manager.distribution.pile;

import java.util.Random;

public class CardRandomizer {
	
	private Random random;
	private int cardsNumber;		//TODO this is cards number -1
	
	public CardRandomizer(Random random, int cardsNumber) {
		this.random = random;
		this.cardsNumber = cardsNumber;
	}

	public int chooseRandomCard() {
		return random.nextInt(cardsNumber);
	}
}
