package com.kapx.java.functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionDemo {

    public static void main(String[] args) {
        final String[] languages = {"Java", "Scala", "Kotlin", "Haskall", "Closure"};
        final List<String> elements = arrayToList.apply(languages);
        elements.forEach(System.out::println);
    }

    private static Function<String[], List<String>> arrayToList = (elements) ->
        Arrays.stream(elements).collect(Collectors.toList());
}
