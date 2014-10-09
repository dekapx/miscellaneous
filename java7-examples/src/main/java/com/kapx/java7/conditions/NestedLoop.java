package com.kapx.java7.conditions;

public class NestedLoop {
	public static void main(String[] args) {

		int[][] doubleDimArray = { { 0, 0, 0, 0, 0 }, { 0, 1, 2, 3, 4 }, { 0, 2, 4, 6, 8 }, { 0, 3, 6, 9, 12 }, { 0, 4, 8, 12, 16 } };

		for (int i = 0; i < doubleDimArray.length; i++) {
			System.out.print("{");
			for (int j = 0; j < doubleDimArray.length; j++) {
				System.out.print(doubleDimArray[i][j]);
				if (j < doubleDimArray.length - 1) {
					System.out.print(", ");
				}
			}
			System.out.print("}");
			System.out.println("");
		}
	}
}
