package com.kapx.java.optional;

import java.util.Optional;

public class OptionalNullCheckDemo {
	public static void main(String[] args) {
		optionalCheckNullAndPrint1(null);

		optionalCheckNullAndPrint2("Test Message");
	}

	private static void optionalCheckNullAndPrint1(final String message) {
		final Optional<String> optional = Optional.ofNullable(message);
		optional.ifPresent(System.out::println);
	}

	private static void optionalCheckNullAndPrint2(final String message) {
		final Optional<String> optional = Optional.ofNullable(message);
		if (optional.isPresent()) {
			System.out.println(optional.get());
		}
	}
}