package com.kapx.cleancode.refactoring.movie.solution2;

public class ChildrensMovie extends Movie {
	private RentelCalculator rentelCalculator;
	
	@Override
	public double getRentalAmount(int daysRented) {
		return rentelCalculator.calculateRentalAmount(daysRented);
	}
	
	@Override
	public String toString() {
		return "Childrens Movie";
	}
}
