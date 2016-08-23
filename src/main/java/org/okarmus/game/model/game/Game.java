package org.okarmus.game.model.game;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.okarmus.game.model.distribution.Distribution;
import org.okarmus.game.model.player.Player;
import org.okarmus.game.model.player.PlayerCards;
import org.okarmus.game.model.player.PlayerType;

public class Game {

	private Player user;
	private List<Player> cpus;
	
	private Distribution currentDist;
	
	public Game() {}
	
	public Game(String userName) {
		this.user = new Player(userName, PlayerType.USER);
		this.cpus = Arrays.asList(new Player("CPU1", PlayerType.CPU), new Player("CPU2", PlayerType.CPU));
	}
	
	public List<String> retrievePlayerNames() {
		List<String> names = cpus.stream().map(Player::getName).collect(Collectors.toList());
		names.add(user.getName());
		return names;
	}
	
	public PlayerCards retrieveUserCards() {
		return currentDist.getCardsForPlayer(retrieveUserName());
	}
	
	public String retrieveUserName() {
		return getUser().getName();
	}
	
	public Player getUser() {
		return user;
	}

	
	public List<Player> getCpus() {
		return cpus;
	}

	public Distribution getCurrentDist() {
		return currentDist;
	}
	
	public void setCurrentDist(Distribution currentDist) {
		this.currentDist = currentDist;
	}
}
