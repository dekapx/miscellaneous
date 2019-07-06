package com.kapx.java8.stream;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamDemo {
    public static void main(String[] args) {
//        IntStream.iterate(1, i -> i + 1).limit(5).forEach(System.out::println);
        Stream<Integer> is = IntStream.rangeClosed(1, 10).boxed();
        is.forEach(System.out::print);
    }

}
