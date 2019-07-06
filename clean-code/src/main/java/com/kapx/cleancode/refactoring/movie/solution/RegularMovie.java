package com.kapx.cleancode.refactoring.movie.solution;

public class RegularMovie implements Movie {
    private static final int FREQUENT_RENTER_POINTS = 1;

    private String title;

    public RegularMovie(final String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public double getRentelAmount(final int daysRented) {
        double amount = 2;
        if (daysRented > 2) {
            amount += (daysRented - 2) * 1.5;
        }
        return amount;
    }

    @Override
    public int getFrequentRenterPoints(final int daysRented) {
        return FREQUENT_RENTER_POINTS;
    }
}
