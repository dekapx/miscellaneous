package com.kapx.java8.quickstart;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class StringJoinDemo {
    public static void main(String[] args) {
        final List<String> languages = Arrays.asList("Java", "Scala", "Haskall", "Kotlin");
//        joinAndPrintInUpperCase(languages);
        joinAndPrintInUpperCaseJava8(languages);
    }

    private static void joinAndPrintInUpperCaseJava8(final List<String> languages) {
        System.out.println(
                languages.stream().map(String::toUpperCase)
                .collect(joining(", "))
        );
    }


    private static void joinAndPrintInUpperCaseJava7(final List<String> languages) {
        int index = 0;
        final StringBuilder builder = new StringBuilder();
        for (String language : languages) {
            builder.append(language.toUpperCase());
            if (index < languages.size() - 1) {
                builder.append(", ");
            }
            index ++;
        }

        System.out.println(builder.toString());
    }
}
