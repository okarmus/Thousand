package org.okarmus.game.controller;

import org.apache.log4j.Logger;
import org.okarmus.game.manager.GameManager;
import org.okarmus.game.model.PlayerCards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distribution")
public class DistributionController {
	private static final Logger LOG = Logger.getLogger(GameController.class);
	
	@Autowired
	GameManager manager;
	
	@RequestMapping("/{gameId}/create")
	public PlayerCards createNewDistribution(@PathVariable int gameId) {
		LOG.info("New distribution should be created");
		return manager.createDistribution(gameId);
	}
}
