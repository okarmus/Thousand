package org.okarmus.game.controller;

import org.okarmus.game.manager.GameManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distribution")
public class DistributionController {

	@Autowired
	GameManager manager;
	
	
	@RequestMapping("/{gameId}/create")
	public void createNewDistribution() {
		
	}
	
	
}
