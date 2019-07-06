package com.kapx.cleancode.refactoring.movie.solution;

public class InvalidMovieException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidMovieException(MovieType type) {
        super(type + " is not a valid movie type");
    }
}
