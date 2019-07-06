package com.kapx.java.streams;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamBuildersSimpleTypes {
    public static void main(String[] args) {
//        streamOf();
//        streamOfArrays();
//        streamWithList();
//        streamGenerate();
//        intStreamIterate();
//        streamTokenIterate();
//        streamWithFilterSortIerateExampleOne();
        streamWithFilterSortIerateExampleTwo();
//        streamWithFindFirstUsingArrays();
    }

    private static void streamOf() {
        final Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        stream.forEach(value -> System.out.println(value));
    }

    private static void streamOfArrays() {
        final Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        final Stream<Integer> stream = Stream.of(numbers);
        stream.forEach(value -> System.out.println(value));
    }

    private static void streamWithList() {
        final Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        final List<Integer> list = Arrays.asList(numbers);
        list.forEach(value -> System.out.println(value));
    }

    private static void streamGenerate() {
        final Stream<Date> stream = Stream.generate(() -> {
            return new Date();
        });
        stream.limit(5).forEach(p -> System.out.println(p));
    }

    private static void intStreamIterate() {
        final IntStream stream = "12345_abcdefg".chars();
        stream.forEach(p -> System.out.println(p));
    }

    private static void streamTokenIterate() {
        final Stream<String> stream = Stream.of("A$B$C".split("\\$"));
        stream.forEach(p -> System.out.println(p));
    }

    private static void streamWithFilterSortIerateExampleOne() {
        final String[] names = {"Nicole", "Aditi", "Cathey", "Steve", "Alex", "Bryan", "George", "Anya"};
        final List<String> list = Arrays.asList(names);
        list
                .stream()
                .filter(name -> name.startsWith("A"))
                .sorted()
                .forEach(System.out::println);
    }

    private static void streamWithFilterSortIerateExampleTwo() {
        final String[] names = {"Nicole", "Aditi", "Cathey", "Steve", "Alex", "Bryan", "George", "Anya"};
        final List<String> list = Arrays.asList(names);
        list
                .stream()
                .filter(name -> name.startsWith("A"))
                .sorted()
                .forEach(name -> System.out.println(name));
    }

    private static void streamWithFindFirstUsingArrays() {
        Arrays.asList("Nicole", "Aditi", "Cathey", "Steve", "Alex", "Bryan", "George", "Anya")
                .stream()
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
    }
}
