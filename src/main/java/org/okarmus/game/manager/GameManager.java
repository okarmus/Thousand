package org.okarmus.game.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.okarmus.game.model.Distribution;
import org.okarmus.game.model.Game;
import org.okarmus.game.model.PlayerCards;
import org.okarmus.game.model.builder.DistributionBuilder;
import org.okarmus.game.model.builder.GameBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameManager {
	
	private Map<Integer,Game> availableGames;
	private AtomicInteger gameSequence;
	
	@Autowired
	private GameBuilder gameBuilder;
	
	@Autowired 
	private DistributionBuilder distributionBuilder;
	
	public GameManager() {
		this.availableGames = new HashMap<>();
		this.gameSequence = new AtomicInteger();		//TODO maybe this value should be generated in different way
	}
	
	public int createGame(String playerName) {
		int gameId = retrieveId();
		Game game = buildGame(playerName);
		this.availableGames.put(gameId, game);
		return gameId;
	}
	
	public PlayerCards createDistribution(int gameId) {
		Game game = availableGames.get(gameId);
		Distribution dist = distributionBuilder.build(game);
		game.setCurrentDist(dist);
		return game.getPlayerCards();
	}

	private int retrieveId() {
		return gameSequence.getAndIncrement();
	}
	
	private Game buildGame(String playerName) {
		return gameBuilder.build(playerName);
	}
}
