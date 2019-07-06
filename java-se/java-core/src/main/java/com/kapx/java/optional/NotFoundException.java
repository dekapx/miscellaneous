package com.kapx.java.optional;

@SuppressWarnings("serial")
public class NotFoundException extends RuntimeException {
	private static final String errorMessage = "Argument must not be null of empty.";


	public NotFoundException() {
		super(new IllegalArgumentException(errorMessage));
	}

	public NotFoundException(String message) {
		super(message);
	}
}
