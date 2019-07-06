package com.kapx.java.streams;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class OptionalWithStream {
    public static void main(String[] args) {
        var elements = List.of("Java", "Scala", "Kotlin", "Haskall");
        Optional<String> optionalElement = find(elements);
        System.out.println(optionalElement.orElseGet(supplier));
    }

    private static Optional<String> find(final List<String> elements) {
        return elements
                .stream()
                .filter(startsWithPredicate("X"))
                .findFirst();
    }

    private static Predicate<String> startsWithPredicate(final String startWith) {
        return (i) -> i.startsWith(startWith);
    }

    private static Supplier<String> supplier = () -> "no-value";
}
