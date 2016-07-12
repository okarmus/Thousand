package org.okarmus.game.model.game;

import org.okarmus.game.model.distribution.Distribution;
import org.okarmus.game.model.player.Player;
import org.okarmus.game.model.player.PlayerCards;
import org.okarmus.game.model.player.PlayerType;

public class Game {

	private Player cpu1;		//TODO we should think about modifying int somehow
	private Player cpu2;
	private Player user;
	
	private Distribution currentDist;
	
	public Game() {}
	
	public Game(String playerName) {
		this.cpu1 = new Player("CPU1", PlayerType.CPU);
		this.cpu2 = new Player("CPU2", PlayerType.CPU);
		this.user = new Player(playerName, PlayerType.USER);
	}

	public Player getCpu1() {
		return cpu1;
	}

	public void setCpu1(Player cpu1) {
		this.cpu1 = cpu1;
	}

	public Player getCpu2() {
		return cpu2;
	}

	public void setCpu2(Player cpu2) {
		this.cpu2 = cpu2;
	}

	public Player getUser() {
		return user;
	}

	public void setUser(Player user) {
		this.user = user;
	}

	public Distribution getCurrentDist() {
		return currentDist;
	}

	public PlayerCards getPlayerCards() {
		String playerName = user.getName();
		return currentDist.getCardsForPlayer(playerName);
	}
	
	public void setCurrentDist(Distribution currentDist) {
		this.currentDist = currentDist;
	}
}
