package org.okarmus.game.model.player

import spock.lang.Specification

class PlayerTest extends Specification {
	
	def sampleName = "Pawel"
	def sampleType = PlayerType.USER
	def sampleScore = 1000
	
	def "should create player from constructor" () {
		when:
			Player player = new Player(sampleName, sampleType)
		then:
			player.getName() == sampleName
			player.getType() == sampleType	
	}
	
	def "should create player from setters" () {	
		when:
			Player player = new Player()
			player.setName(sampleName)
			player.setType(sampleType)
			player.setScore(sampleScore)
		then:
			player.getName() == sampleName
			player.getType() == sampleType
			player.getScore() == sampleScore
	}
}
