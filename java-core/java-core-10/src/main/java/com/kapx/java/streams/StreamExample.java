package com.kapx.java.streams;

import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        // positive scenario...
        System.out.println("City: " + findCityByName("Miami"));

        // negative scenario...
        System.out.println("City: " + findCityByName("UnknownCity"));
    }

    private static String findCityByName(final String city) {
        final List<String> cities = getCities();
        return cities.stream()
                .filter(c -> c.equals(city))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Exception ! unable to find " + city));
    }

    private static List<String> getCities() {
        return Arrays.asList("Seoul", "Boston", "San Mateo", "Miami", "Santiago", "Vancouver", "Saint Louis");
    }
}
