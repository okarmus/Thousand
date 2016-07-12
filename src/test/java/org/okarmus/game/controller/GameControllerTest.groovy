package org.okarmus.game.controller

import org.okarmus.game.manager.game.GameManager;
import org.springframework.test.web.servlet.MockMvc
import org.springframework.http.MediaType
import spock.lang.Specification

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import static org.hamcrest.Matchers.*

class GameControllerTest extends Specification{
	
	private static final String URL = "/game/create"
	
	MockMvc mockMvc
	GameController underTest
	
	GameManager gameManager = Mock()
	
	def sampleId = 12
	def samplePlayer = "Andrzej"
	
	def setup() {
		underTest = new GameController(gameManager: gameManager)
		mockMvc = standaloneSetup(underTest)
			.defaultRequest(get("/")
				  .accept(MediaType.APPLICATION_JSON))
				  .build()		
	}
	
	def "should create game and return proper game id"() {
		given:
			gameManager.createGame(samplePlayer) >>  sampleId
		expect:
			mockMvc.perform(post(URL).content(samplePlayer))
				.andExpect(status().isOk())
				.andExpect(jsonPath('$', is(sampleId)))
	}
}
