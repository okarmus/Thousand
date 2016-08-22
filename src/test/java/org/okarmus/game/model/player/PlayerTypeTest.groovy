package org.okarmus.game.model.player

import spock.lang.Specification

class PlayerTypeTest extends Specification {
		
	def "enum should have proper values"() {
		expect:
			PlayerType.values().length == 2
			PlayerType.valueOf("CPU") == PlayerType.CPU
			PlayerType.valueOf("USER") == PlayerType.USER
	}
}
