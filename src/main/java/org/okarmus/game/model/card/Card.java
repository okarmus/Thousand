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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((figure == null) ? 0 : figure.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (color != other.color)
			return false;
		if (figure != other.figure)
			return false;
		return true;
	}
}
