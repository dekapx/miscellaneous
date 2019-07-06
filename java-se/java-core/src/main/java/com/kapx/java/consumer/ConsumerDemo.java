package com.kapx.java.consumer;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        sumNumbers.accept(List.of(1, 2, 3, 4, 5));
        print.accept(1);
    }

    private static Consumer<List<Integer>> sumNumbers = (numbers) -> {
        var total = numbers.stream().mapToInt(i -> i).sum();
        System.out.println("Total = " + total);
    };

    private static IntConsumer print = (i) -> {
        System.out.println("Total = " + i);
    };
}
