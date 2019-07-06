package com.kapx.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamFilterExampleWithPredicate {
    public static void main(String[] args) {
        final Predicate<String> predicate = getPredicateByFirstLetter("S");
        final List<String> allCities = getCities();
        final List<String> cities = getCitiesByFirstLetter(allCities, predicate);
        displayCities(cities);
    }

    private static Predicate<String> getPredicateByFirstLetter(final String firstLetter) {
        return (city -> city.startsWith(firstLetter));
    }
    private static List<String> getCitiesByFirstLetter(final List<String> cities, final Predicate<String> predicate) {
        return cities.stream().filter(predicate).sorted().collect(Collectors.toList());
    }

    private static void displayCities(final List<String> cities) {
        cities.stream().forEach(System.out::println);
    }

    private static List<String> getCities() {
        return Arrays.asList("Seoul", "Manhattan", "Boston", "San Mateo", "Miami", "Santiago", "Vancouver", "Saint Louis", "Tokyo", "Manchester");
    }
}
