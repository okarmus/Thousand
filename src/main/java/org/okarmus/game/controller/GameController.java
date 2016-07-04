package org.okarmus.game.controller;

import org.apache.log4j.Logger;
import org.okarmus.game.manager.game.GameManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {
	private static final Logger LOG = Logger.getLogger(GameController.class);
	
	@Autowired
	private GameManager gameManager;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public int createGame(@RequestBody String player) {
		LOG.info("New game is going to be created for player: " + player);
		return gameManager.createGame(player);
	}
}
