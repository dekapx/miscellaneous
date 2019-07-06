package com.kapx.java.functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionAndThanDemo2 {
    public static void main(String[] args) {
        final String arg = "Java, Scala, Java, Kotlin, Scala, Haskal, Java Script";

        final List<String> languages = split.andThen(toList).andThen(sortAndFilter).apply(arg);
        print.accept(languages);
    }

    private static Function<String, String[]> split = (arg) -> arg.split(",");

    private static Function<String[], List<String>> toList = (elements) -> {
        return Arrays.stream(elements)
                .map(i -> i.trim())
                .collect(Collectors.toList());
    };

    private static Function<List<String>, List<String>> sortAndFilter = (elements) -> {
        return elements.stream()
                .filter(isScriptingLanguage())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    };

    private static Predicate<String> isScriptingLanguage() {
        return i -> !(i.equals("Java Script"));
    }

    private static Consumer<List<String>> print = (elements) -> {
        elements.forEach(System.out::println);
    };
}
