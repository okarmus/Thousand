package org.okarmus.game.manager.distribution;

import org.okarmus.game.context.GameContext;
import org.okarmus.game.manager.distribution.builder.DistributionBuilder;
import org.okarmus.game.model.distribution.Distribution;
import org.okarmus.game.model.game.Game;
import org.okarmus.game.model.player.PlayerCards;
import org.okarmus.game.utils.annotation.Manager;
import org.okarmus.game.utils.exception.GameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

@Manager
public class DistributionManager {
	
	@Autowired
	private GameContext context;
	
	@Autowired 
	private DistributionBuilder distributionBuilder;
	
	public PlayerCards createDistribution(int gameId) throws GameNotFoundException {
		Game game = context.findGame(gameId);
		Distribution dist = createDistribution(game);
		
		game.setCurrentDist(dist);
		return game.retrieveUserCards();
	}
	
	private Distribution createDistribution(Game game) {
		return distributionBuilder.build(game);
	}
}
