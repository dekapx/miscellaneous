package com.kapx.testdriven.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class HamcrestExample {
    public String sayHello(final String arg) {
        return "Hello ! " + arg;
    }

    public double sum(final double... nums) {
        return Arrays.stream(nums).sum();
    }

    public List<String> concat(final String... args) {
        final List<String> elements = new ArrayList<>(args.length);
        Arrays.stream(args).forEach(elements::add);
        return elements;
    }

    public List<String> sort(final List<String> elements) {
        return elements.stream().sorted().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        HamcrestExample example = new HamcrestExample();
//        System.out.println(example.sum(1.3, 2.7, 3.0));
        final List<String> elements = example.concat("Java", "Scala", "Closure", "Kotlin", "Haskal");
        System.out.println(elements);

        final List<String> sortedElements = example.sort(elements);
        System.out.println(sortedElements);
    }
}
