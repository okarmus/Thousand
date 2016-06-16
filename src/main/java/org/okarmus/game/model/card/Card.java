package org.okarmus.game.model.card;


public class Card {
	private Color color;
	private Figure figure;

	public Card() {
	}
	
	public Card(Color color, Figure figure) {
		this.color = color;
		this.figure = figure;
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
	@Override
	public String toString() {
		return "Card [color=" + color.getColor() + ", figure=" + figure.getFigure() + "]";
	}
}
