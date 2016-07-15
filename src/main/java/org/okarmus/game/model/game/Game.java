package org.okarmus.game.model.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.okarmus.game.model.distribution.Distribution;
import org.okarmus.game.model.player.Player;
import org.okarmus.game.model.player.PlayerCards;
import org.okarmus.game.model.player.PlayerType;

public class Game {

	private List<Player> players;
	
	private Distribution currentDist;
	
	public Game() {}
	
	public Game(String userName) {
		this.players = new ArrayList<>();
		players.add(new Player("CPU1", PlayerType.CPU));
		players.add(new Player("CPU2", PlayerType.CPU));
		players.add(new Player(userName, PlayerType.USER));
	}
	
	public List<String> retrievePlayerNames() {
		return players.stream()
					  .map(Player::getName).
					  collect(Collectors.toList());
	}
	
	public PlayerCards retrieveUserCards() {
		return currentDist.getCardsForPlayer(retrieveUserName());
	}
	
	public String retrieveUserName() {
		return players
			.stream()
			.filter(player -> PlayerType.USER.equals(player.getType()))
			.findFirst()
			.get()
			.getName();
	}
	
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Distribution getCurrentDist() {
		return currentDist;
	}
	
	public void setCurrentDist(Distribution currentDist) {
		this.currentDist = currentDist;
	}
}
