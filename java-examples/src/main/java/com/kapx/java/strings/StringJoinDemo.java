package com.kapx.java.strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringJoinDemo {
	public static void main(String[] args) {
		final String[] tokens = { "Java", "8", "string", "join", "demo" };
		String result = String.join(" ", tokens);
		display(result);

		result = String.join(" ", "Java", "8", "string", "join", "demo");
		display(result);

		final List<String> list = Arrays.asList(tokens);
		result = String.join(" ", list);
		display(result);

		final List<String> stringsToJoin = Arrays.asList("216", "58", "216", "206");
		result = stringsToJoin.stream().map(piece -> piece.toString()).collect(Collectors.joining(".", "[", "]"));
		display(result);
	}

	private static void display(final String result) {
		System.out.println(result);
	}
}
