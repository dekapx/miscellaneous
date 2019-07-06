package com.kapx.java8.quickstart;

import java.util.concurrent.TimeUnit;

public class RunnableExample {
    public static void main(String[] args) {
        runnableJava8();
    }

    private static void runnableJava7() {
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i =0; i < 5; i ++) {
                    try {
                        System.out.print(i + " ");
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };

        new Thread(runnable).start();
    }

    private static void runnableJava8() {
        final Runnable runnable = () -> {
            for (int i =0; i < 5; i ++) {
                try {
                    System.out.print(i + " ");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                }
            }
        };

        new Thread(runnable).start();
    }
}
