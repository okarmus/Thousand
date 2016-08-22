package org.okarmus.game.model.distribution

import spock.lang.Specification

class DistributionScoreTest extends Specification {

	DistributionScore underTest
	
	def negotiationWinner = true
	def requiredPoints = 140;
	def gainedPoints = 100;
	
	def "should create distribution score object"() {
		when:
			DistributionScore score = new DistributionScore()
			score.setNegotiationWinner(negotiationWinner)
			score.setRequiredPoints(requiredPoints)
			score.setGainedPoints(gainedPoints)
		then:
			score.isNegotiationWinner() == negotiationWinner
			score.getRequiredPoints() == requiredPoints
			score.getGainedPoints() == gainedPoints
	}
}
