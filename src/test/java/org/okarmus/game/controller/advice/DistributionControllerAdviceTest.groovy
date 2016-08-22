package org.okarmus.game.controller.advice

import javax.servlet.http.HttpServletRequest

import org.okarmus.game.utils.exception.GameNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

import spock.lang.Specification

class DistributionControllerAdviceTest  extends Specification {
	
	DistributionControllerAdvice underTest = new DistributionControllerAdvice()
	
	HttpServletRequest request = Mock()
	def exceptionMsg = "This is sample exception message"
	def ex = new GameNotFoundException(exceptionMsg)

	def "exception message should be handled"() {
		when:
			ResponseEntity result = underTest.handleGameNotFoundException(request, ex)
		then:
			result.getStatusCode() == HttpStatus.BAD_REQUEST
			result.getBody() == exceptionMsg
	}
}
