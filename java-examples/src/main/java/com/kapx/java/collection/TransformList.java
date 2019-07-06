package com.kapx.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransformList {
    public static void main(String[] args) {
        final List<String> names = Arrays.asList("Steve", "Bryan", "Anna", "Maria", "Xin");
        final List<String> uppercaseNames = new ArrayList<String>();

//        for (String name : names) {
//            uppercaseNames.add(name.toUpperCase());
//        }

//        names.forEach(name -> uppercaseNames.add(name.toUpperCase()));

//        names.stream()
//                .map(name -> name.toUpperCase())
//                .forEach(name -> System.out.println(name));

//        names.stream()
//                .map(name -> name.toUpperCase())
//                .forEach(System.out::println);

        // print the length of the names
//        names.stream()
//                .map(name -> name.length())
//                .forEach(count -> System.out.print(count + " "));

        names.stream()
                .map(String::toUpperCase)
                .forEach(name -> System.out.println(name));

//        displayContents(uppercaseNames);
    }

    private static void displayContents(final List<String> names) {
        names.forEach((name) -> System.out.println(name));
    }
}
