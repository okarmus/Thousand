package org.okarmus.game.context;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.okarmus.game.model.game.Game;
import org.okarmus.game.utils.annotation.Context;
import org.okarmus.game.utils.exception.GameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Context
public class GameContext {
	
	@Value("${game.not.found}")
	private String exceptionMessage;
	
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
	
	public Game findGame(int gameId) throws GameNotFoundException {
		return currentGames.computeIfAbsent(gameId, (id) -> {throw new GameNotFoundException(() -> String.format(exceptionMessage, id));});
	}
}
