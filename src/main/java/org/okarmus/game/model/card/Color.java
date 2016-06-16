package org.okarmus.game.model.card;

public enum Color {

	DIAMONDS("diamonds"),HEARTS("hearts"),SPADES("spades"),CLUBS("clubs");
	
	private String color;

	private Color(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}
}
