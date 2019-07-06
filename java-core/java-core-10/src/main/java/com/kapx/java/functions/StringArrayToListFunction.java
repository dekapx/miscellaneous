package com.kapx.java.functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class StringArrayToListFunction {
    public static void main(String[] args) {
        final String[] elements = {"Java", "Scala", "Kotlin"};
        var list = toList.apply(elements);
        list.forEach(System.out::println);
    }

    public static Function<String[], List<String>> toList = (elements) -> {
        final List<String> list = new ArrayList<>();
        Arrays.stream(elements).forEach(list::add);
        return list;
    };
}
