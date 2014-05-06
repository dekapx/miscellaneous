package com.kapx.java7.conditions;

public class DoWhileDemo {
	public static void main(String[] args) {
		int i = 0;

		do {
			System.out.print(" " + i);
			i++;
		} while (i < 10);

		System.out.println("\n---------------------");

		int j = 0;
		while (j < 10) {
			System.out.print(" " + j);
			j++;
		}
	}
}
