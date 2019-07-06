package com.kapx.cleancode.refactoring.movie.solution2;

public abstract class Movie {
    protected String title;
    protected int priceCode;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int priceCode) {
		this.priceCode = priceCode;
	}

	abstract double getRentalAmount(int daysRented);
}
