package com.kapx.java8.basics;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BinaryOperator;

public class LambdaExamples {
    public static void main(String[] args) {
    }

    private static void lambdaUsingBinaryOperator() {
        BinaryOperator<Long> add = (x, y) -> x + y;
        System.out.println(add.apply(3L, 5L));
    }

    private static void callableUsingLambda() {
        final Callable<Void> callable = () -> {
            System.out.println("Running in a callable thread");
            return null;
        };

        final ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(callable);
        executorService.shutdown();
    }

    public static void runnableUsingLambda() {
        final Runnable runnable = () -> System.out.println("Running in a thread...");
        new Thread(runnable).start();
    }
}
