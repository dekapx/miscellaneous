package com.kapx.cleancode.refactoring.movie.solution2;

public class RegularMovie extends Movie {
	private RentelCalculator rentelCalculator;
	
	public RentelCalculator getRentelCalculator() {
		return rentelCalculator;
	}

	public void setRentelCalculator(RentelCalculator rentelCalculator) {
		this.rentelCalculator = rentelCalculator;
	}

	@Override
	public double getRentalAmount(int daysRented) {
		return rentelCalculator.calculateRentalAmount(daysRented);
	}

	@Override
	public String toString() {
		return "Regular Movie";
	}
}
