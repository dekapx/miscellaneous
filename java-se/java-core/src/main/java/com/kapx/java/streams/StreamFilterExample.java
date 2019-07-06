package com.kapx.java.streams;

import java.util.Arrays;
import java.util.List;

public class StreamFilterExample {
    public static void main(String[] args) {
        final List<String> cities = Arrays.asList("Seoul", "Boston", "San Mateo", "Miami", "Santiago", "Vancouver", "Saint Louis");
        cities.stream().filter(city -> city.startsWith("S")).sorted().forEach(System.out::println);
    }
}
