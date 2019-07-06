package com.kapx.cleancode.refactoring.movie.solution;

public interface Movie {
    String getTitle();
    double getRentelAmount(int daysRented);
    int getFrequentRenterPoints(int daysRented);
}
