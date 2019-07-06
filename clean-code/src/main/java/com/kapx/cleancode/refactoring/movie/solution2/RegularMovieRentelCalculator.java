package com.kapx.cleancode.refactoring.movie.solution2;

public class RegularMovieRentelCalculator implements RentelCalculator {

	@Override
	public double calculateRentalAmount(final int daysRented) {
		double amount = 2;
        if (daysRented > 2) {
            amount += (daysRented - 2) * 1.5;
        }
        return amount;
	}

}
