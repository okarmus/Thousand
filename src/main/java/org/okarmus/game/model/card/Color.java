package org.okarmus.game.model.card;

public enum Color {

	DIAMONDS("diamonds", 2),HEARTS("hearts",3),SPADES("spades",0),CLUBS("clubs",1);
	
	private String color;
	private int priority;

	private Color(String color, int priority) {
		this.color = color;
		this.priority = priority;
	}

	public String getColor() {
		return color;
	}

	public int getPriority() {
		return priority;
	}
}
