package org.okarmus.game.manager.game;

import org.okarmus.game.context.GameContext;
import org.okarmus.game.manager.game.builder.GameBuilder;
import org.okarmus.game.model.game.Game;
import org.okarmus.game.utils.annotation.Manager;
import org.springframework.beans.factory.annotation.Autowired;

@Manager
public class GameManager {
	
	@Autowired
	private GameContext context;
	
	@Autowired
	private GameBuilder gameBuilder;
	
	public int createGame(String playerName) {
		Game game = buildGame(playerName);
		return context.addGame(game);
	}
	
	private Game buildGame(String playerName) {
		return gameBuilder.build(playerName);
	}
}
