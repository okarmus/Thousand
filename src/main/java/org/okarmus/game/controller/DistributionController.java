package org.okarmus.game.controller;

import org.apache.log4j.Logger;
import org.okarmus.game.manager.distribution.DistributionManager;
import org.okarmus.game.model.player.PlayerCards;
import org.okarmus.game.utils.exception.GameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distribution")
public class DistributionController {
	private static final Logger LOG = Logger.getLogger(GameController.class);
	
	@Autowired
	DistributionManager manager;
	
	@RequestMapping("/{gameId}/create")
	public PlayerCards createNewDistribution(@PathVariable int gameId) {
		LOG.info("New distribution should be created");
		
		try {
			return manager.createDistribution(gameId);
		} catch (GameNotFoundException e) {
			LOG.info("Requested game can not be found", e);
			return new PlayerCards();
		}
	}
}
