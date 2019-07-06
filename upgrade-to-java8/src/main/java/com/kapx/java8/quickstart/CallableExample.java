package com.kapx.java8.quickstart;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
    public static void main(String[] args) throws Exception {
        executeJava7Callable();
        executeJava8Callable();
    }

    private static void executeJava7Callable() throws Exception {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7, 8, 9, 10);
        final CallableJava7 callable = new CallableJava7(numbers);
        final ExecutorService executorService = Executors.newFixedThreadPool(1);
        final Future<Integer> future = executorService.submit(callable);
        System.out.println(future.get());
    }

    private static void executeJava8Callable() throws Exception {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7, 8, 9, 10);
        final CallableJava8 callable = new CallableJava8(numbers);
        final ExecutorService executorService = Executors.newFixedThreadPool(1);
        final Future<Integer> future = executorService.submit(callable);
        System.out.println(future.get());
    }

}
