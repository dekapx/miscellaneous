package com.kapx.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamArrayToListDemo {
    public static <T> List<T> toList(final T... elements) {
        final List<T> list = new ArrayList<>(elements.length);
        Arrays.stream(elements).forEach(list::add);
        return list;
    }

    public static <T> void printElements(final List<T> elements) {
        elements.forEach(System.out::println);
    }

    public static void main(String[] args) {
        final String[] langArray = {"Java", "Scala", "Closure"};
        printElements(toList(langArray));

        final Integer[] numArray = {1, 2, 3};
        printElements(toList(numArray));
    }
}
