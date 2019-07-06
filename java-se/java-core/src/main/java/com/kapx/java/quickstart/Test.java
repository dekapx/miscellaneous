package com.kapx.java.quickstart;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // what to do
        final List<String> languages = List.of("Java", "Scala", "Python");
        languages.forEach(System.out::println);
    }

    // how to do
    private static void loopJava7() {
        List<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("Scala");
        languages.add("Python");

        for (String language: languages) {
            System.out.println(language);
        }
    }
}

