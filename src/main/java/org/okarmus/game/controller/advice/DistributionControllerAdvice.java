package org.okarmus.game.controller.advice;

import javax.servlet.http.HttpServletRequest;

import org.okarmus.game.controller.DistributionController;
import org.okarmus.game.utils.exception.GameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(basePackageClasses = DistributionController.class)
public class DistributionControllerAdvice {

	@ExceptionHandler(GameNotFoundException.class)
	@ResponseBody
	public ResponseEntity<?> handleGameNotFoundException(HttpServletRequest request, GameNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
