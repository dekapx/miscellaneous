package com.kapx.java8.basics;

import java.util.Arrays;
import java.util.List;

public class ListForEachExample {
    public static void main(String[] args) {
        final List<String> languages = Arrays.asList("Java", "Scala", "Closure");

        // for each with data type and variable name
        languages.forEach((String language) -> System.out.println(language));

        // for each with variable name
        languages.forEach(language -> System.out.println(language));

        // for each with method reference
        languages.forEach(System.out::println);
    }
}
