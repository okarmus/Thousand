package org.okarmus.game.model;

public class Player {
	
	private String name;
	private PlayerType type;
	private int score;
	
	public Player() {}

	public Player(String name, PlayerType type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayerType getType() {
		return type;
	}

	public void setType(PlayerType type) {
		this.type = type;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
