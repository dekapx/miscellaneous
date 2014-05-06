package com.kapx.java7.console.io;

import java.util.Scanner;

public class ReadInput {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Printing the file passed in:");
		final String input = scanner.nextLine();

		System.out.println(input);
		scanner.close();
	}
}
