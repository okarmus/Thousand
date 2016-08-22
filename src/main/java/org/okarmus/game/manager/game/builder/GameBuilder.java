package org.okarmus.game.manager.game.builder;

import org.okarmus.game.model.game.Game;

public class GameBuilder {

	public Game build(String player) {
		return new Game(player);
	}
}
