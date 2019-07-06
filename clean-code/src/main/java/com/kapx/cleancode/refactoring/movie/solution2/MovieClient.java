package com.kapx.cleancode.refactoring.movie.solution2;

public class MovieClient {

	public static void main(String[] args) {
		final RegularMovie movie = MovieFactory.getMovie(RegularMovie.class);
		movie.setTitle("Ong Bak");
		movie.setPriceCode(4);
		movie.setRentelCalculator(new RegularMovieRentelCalculator());
		System.out.println(movie);
		System.out.println(movie.getRentalAmount(4));
	}
}
