package com.kapx.java8.basics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaComparatorDemo {
    public static void main(String[] args) {
        final List<String> languages = Arrays.asList("Java", "Scala", "Closure", "Haskall", "Python", "Objective C");
//        sortNonLambda(languages);
        sortLambda(languages);
    }

    private static void sortNonLambda(final List<String> languages) {
        languages.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        print(languages);
    }

    private static void sortLambda(final List<String> languages) {
        languages.sort((o1, o2) -> o1.compareTo(o2));
        print(languages);
    }

    private static void print(final List<String> languages) {
        languages.forEach(System.out::println);
    }
}
