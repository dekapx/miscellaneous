package com.kapx.cleancode.refactoring.movie.solution;

public class ChildrensMovie implements Movie {
    private static final int FREQUENT_RENTER_POINTS = 1;

    private String title;

    public ChildrensMovie(final String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public double getRentelAmount(final int daysRented) {
    	double amount = 1.5;
        if (daysRented > 3) {
            amount += (daysRented - 2) * 1.5;
        }
        return amount;
    }

    @Override
    public int getFrequentRenterPoints(final int daysRented) {
        return FREQUENT_RENTER_POINTS;
    }
}
