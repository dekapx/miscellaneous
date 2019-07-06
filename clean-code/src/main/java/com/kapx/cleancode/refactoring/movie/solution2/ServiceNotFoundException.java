package com.kapx.cleancode.refactoring.movie.solution2;

public class ServiceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ServiceNotFoundException(String message, Exception exception) {
		super(message, exception);
	}

	public ServiceNotFoundException(String message) {
		super(message);
	}
}
