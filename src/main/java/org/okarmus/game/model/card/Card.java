package org.okarmus.game.model.card;

public class Card {
	private Color color;
	private Figure figure;
	private int value;

	public Card() {
	}
	
	public Card(Color color, Figure figure, int value) {
		this.color = color;
		this.figure = figure;
		this.value = value;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Figure getFigure() {
		return figure;
	}
	public void setFigure(Figure figure) {
		this.figure = figure;
	}
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Card [color=" + color + ", figure=" + figure + ", value=" + value + "]";
	}
}
