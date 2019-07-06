package com.kapx.java.functionalinterface;

@FunctionalInterface
interface Calc {
	double sum(double... operands);
}

public class CalcDemo {
	public static void main(String[] args) {
		final Calc calc = (double... operands) -> {
			double result = 0;

			for (double operand : operands) {
				result = (result + operand);
			}

			return result;
		};

		final double result = calc.sum(10.5, 15.7, 25.34);
		System.out.println("Result: " + result);
	}

}