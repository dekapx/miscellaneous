package com.kapx.java.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        final List<String> cities = getCities();
        final Optional<String> optional = findCityByNameOptional(cities, "Delhi");
        System.out.println(optional.orElseThrow(() -> new IllegalStateException("City not found...")));
        //              -- OR --
        System.out.println(optional.orElseThrow(IllegalStateException::new));
    }

    private static Optional<String> findCityByNameOptional(final List<String> cities, final String city) {
        return cities.stream().filter(c -> c.equals(city)).findFirst();
    }

    private static List<String> getCities() {
        return Arrays.asList("Seoul", "Boston", "San Mateo", "Miami", "Santiago", "Vancouver", "Saint Louis");
    }
}
