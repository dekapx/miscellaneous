package com.kapx.java8.functions.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    private static Consumer<String> consumer = (String arg) -> {
        System.out.println(arg);
    };

    private static Consumer<List<String>> consumer2 = (args) -> {
        args.forEach(System.out::println);
    };


    public static void main(String[] args) {
        consumer2.accept(Arrays.asList("Hugo", "Brian", "Aoife"));
    }
}
