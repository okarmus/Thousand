package org.okarmus.game.context;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.okarmus.game.model.game.Game;
import org.okarmus.game.utils.annotation.Context;
import org.springframework.beans.factory.annotation.Autowired;

@Context
public class GameContext {
	
	@Autowired
	private AtomicInteger gameSequence;

	private Map<Integer,Game> currentGames;
	
	public GameContext() {
		this.currentGames = new HashMap<>();
	}

	public int addGame(Game game) {
			int gameId = gameSequence.getAndIncrement();
			currentGames.put(gameId, game);
			return gameId;
	}
	
	public Optional<Game> retrieveGame(int gameId) {
		return Optional.ofNullable(currentGames.get(gameId));
	}
}
