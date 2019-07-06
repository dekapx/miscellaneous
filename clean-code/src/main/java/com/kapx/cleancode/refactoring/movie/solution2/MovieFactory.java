package com.kapx.cleancode.refactoring.movie.solution2;

public class MovieFactory {
	public static <T extends Movie> T getMovie(final Class<T> clazz) {
		return ServiceManager.INSTANCE.getService(clazz);
	}
}
