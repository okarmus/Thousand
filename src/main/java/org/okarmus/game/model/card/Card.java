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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((figure == null) ? 0 : figure.hashCode());
		result = prime * result + value;
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
		if (value != other.value)
			return false;
		return true;
	}
}
