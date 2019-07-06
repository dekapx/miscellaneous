package com.kapx.cleancode.refactoring.movie.solution;

public class NewReleaseMovie implements Movie {
    private static final int FREQUENT_RENTER_POINTS = 1;

    private String title;

    public NewReleaseMovie(final String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public double getRentelAmount(final int daysRented) {
    	return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(final int daysRented) {
        if (daysRented > 1) {
            return FREQUENT_RENTER_POINTS + 1;
        }
        return FREQUENT_RENTER_POINTS;
    }
}
