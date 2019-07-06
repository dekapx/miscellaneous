package com.kapx.cleancode.refactoring.movie.solution;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String getStatement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        for (Rental rental : rentals) {
            final Movie movie = rental.getMovie();
            totalAmount = totalAmount + movie.getRentelAmount(rental.getDaysRented());
            frequentRenterPoints = frequentRenterPoints + movie.getFrequentRenterPoints(rental.getDaysRented());
        }

        final StringBuilder statementBuilder = new StringBuilder("Rental Record for " + getName() + "\n");
        statementBuilder.append("Amount owed is " + String.valueOf(totalAmount) + "\n");
        statementBuilder.append("You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points");
        return statementBuilder.toString();
    }

}

