package com.kapx.java8.basics;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class RunnableDemo {

    public static void main(String[] args) {
        final Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(String.format("%d - Running in a thread...", i));
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
