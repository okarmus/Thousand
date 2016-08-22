package org.okarmus.game.controller;

import static org.hamcrest.Matchers.*
import static org.mockito.Mockito.mock
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

import org.okarmus.game.manager.distribution.DistributionManager
import org.okarmus.game.model.card.Card
import org.okarmus.game.model.card.Color
import org.okarmus.game.model.card.Figure
import org.okarmus.game.model.player.PlayerCards
import org.okarmus.game.utils.exception.GameNotFoundException
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.util.NestedServletException;

import spock.lang.Ignore
import spock.lang.Specification

class DistributionControllerTest  extends Specification{
	
	private static final CREATE_URL = "/distribution/{gameId}/create"
	
	MockMvc mockMvc
	DistributionController underTest
	
	DistributionManager mockManager = Mock()
	
	int sampleId = 32
	
	public void setup() {
		underTest = new DistributionController(manager: mockManager)
		mockMvc = MockMvcBuilders.standaloneSetup(underTest)
				  .defaultRequest(get("/")
				  .accept(MediaType.APPLICATION_JSON))
				  .build()				  
	}
	
	def "should create proper distibution"() {
		given:
			def PlayerCards expectedCards = playerCards()
			mockManager.createDistribution(sampleId) >> expectedCards 
		expect:
			mockMvc.perform(get(CREATE_URL, sampleId))
				.andExpect(status().isOk())
				.andExpect(jsonPath('$.cards',hasSize(1)))
				.andExpect(jsonPath('$.cards[0].color', is(Color.SPADES.toString())))
				.andExpect(jsonPath('$.cards[0].figure',is(Figure.ACE.toString())))
	}
	

	def "should return precondition failed response"() {
	given:
		mockManager.createDistribution(sampleId) >> {throw new GameNotFoundException("")}
	when:
		mockMvc.perform(get(CREATE_URL, sampleId))
	then:			
		thrown NestedServletException
	}
	
	def playerCards() {
		return new PlayerCards(cards: [new Card(color: Color.SPADES, figure: Figure.ACE)])
	}
}
