package com.kapx.java8.lambda;

import java.util.concurrent.TimeUnit;

public class RunnableDemo {
    private static final Runnable task = () -> {
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };


    public static void main(String[] args) {
        new Thread(task).start();
    }
}
