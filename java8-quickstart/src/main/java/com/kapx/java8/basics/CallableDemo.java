package com.kapx.java8.basics;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CallableDemo {
    private static Callable callable = () -> {
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
            TimeUnit.SECONDS.sleep(1);
        }
        return null;
    };

    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(callable);
        executorService.shutdown();
    }
}
