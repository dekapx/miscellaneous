package com.kapx.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTransformationDemo {
    public static void main(String[] args) {
        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
//        example1(friends);
//        example2(friends);
        example3(friends);
    }

    private static void example1(final List<String> friends) {
        final List<String> uppercaseNames = new ArrayList<String>();
        for (String name : friends) {
            uppercaseNames.add(name.toUpperCase());
        }

        displayElements(uppercaseNames);
    }

    private static void example2(final List<String> friends) {
        final List<String> uppercaseNames = new ArrayList<String>();
        friends.forEach(name -> uppercaseNames.add(name.toUpperCase()));
        displayElements(uppercaseNames);
    }

    private static void displayElements(final List<String> elements) {
        elements.forEach(System.out::println);
    }

    private static void example3(final List<String> friends) {
        friends.stream()
                .map(name -> name.toUpperCase())
                .forEach(name -> System.out.print(name + " "));
    }
}
