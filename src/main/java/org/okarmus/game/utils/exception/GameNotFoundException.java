package org.okarmus.game.utils.exception;

import java.util.function.Supplier;

public class GameNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 8549557496877479737L;

	public GameNotFoundException(String message) {
        super(message);
    }
	
	public GameNotFoundException(Supplier<String> messageSupplier) {
		super(messageSupplier.get());
	}
}
