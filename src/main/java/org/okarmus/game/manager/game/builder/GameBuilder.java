package org.okarmus.game.manager.game.builder;

import org.okarmus.game.model.game.Game;

public class GameBuilder {		//TODO this class is going to be expanded very soon

	public Game build(String player) {
		return new Game(player);
	}
}
