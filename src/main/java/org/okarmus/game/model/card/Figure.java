package org.okarmus.game.model.card;

public enum Figure {
	NINE("nine"), TEN("ten"), JACK("jack"), KING("king"), QUEEN("queen"), ACE("ace");
	
	private String figure;

	private Figure(String figure) {
		this.figure = figure;
	}

	public String getFigure() {
		return figure;
	}
}
