package com.kapx.java.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalNullCheckIsPresent {
	public static void main(String[] args) {
		final List<String> cities = getCities();
		final Optional<String> optional = Optional.ofNullable(findCityByName(cities, "Miami"));
		final String city = optional.isPresent() ? optional.get() : optional.orElseThrow(() -> new NotFoundException("City not found"));
		System.out.println(city);
	}

	private static String findCityByName(final List<String> cities, final String city) {
		return cities.stream().filter(c -> c.equals(city)).findFirst().get();
	}

	private static List<String> getCities() {
		return Arrays.asList("Seoul", "Boston", "San Mateo", "Miami", "Santiago", "Vancouver", "Saint Louis");
	}
}
