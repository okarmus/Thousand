package org.okarmus.game.model;

public class Game {

	private Player cpu1;
	private Player cpu2;
	private Player user;
	
	public Game() {}
	
	public Game(String playerName) {
		this.cpu1 = new Player("CPU1", PlayerType.CPU);
		this.cpu2 = new Player("CPU2", PlayerType.CPU);
		this.user = new Player(playerName, PlayerType.USER);
	}
}
