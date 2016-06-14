package org.okarmus.game.model.builder;

import org.okarmus.game.model.Game;

public class GameBuilder {

	public Game build(String player) {
		return new Game(player);
	}
}
