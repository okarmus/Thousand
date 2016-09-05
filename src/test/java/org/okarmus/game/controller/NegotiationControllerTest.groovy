package org.okarmus.game.controller

import static org.hamcrest.Matchers.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

import org.okarmus.game.negotiation.NegotiationManager
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders

import spock.lang.Specification

class NegotiationControllerTest extends Specification{

	def url = "/negotiation/create/{gameId}"
	
	MockMvc mockMvc
	NegotiationController underTest
	
	
	NegotiationManager negotiationManager = Mock()
	
	def setup() {
		underTest = new NegotiationController(negotiationManager: negotiationManager)
		mockMvc = MockMvcBuilders.standaloneSetup(underTest)
				  .defaultRequest(get("/")
				  .accept(MediaType.APPLICATION_JSON))
				  .build()	
	}
	
	def "should create negotiation and return proper negotiation id"() {
		given:
			def gameId = 12
			def negotiationId = 23
			negotiationManager.createNegotiation(gameId) >> negotiationId
		expect:
			mockMvc.perform(get(url, gameId))
				.andExpect(status().isOk())
				.andExpect(jsonPath('$', equalTo(negotiationId)))
	}	
}
