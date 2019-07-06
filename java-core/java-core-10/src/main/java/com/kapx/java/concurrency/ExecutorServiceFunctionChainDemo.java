package com.kapx.java.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class ExecutorServiceFunctionChainDemo {
    public static void main(String[] args) throws Exception {
        build.andThen(execute).andThen(verify).apply(null);
    }

    private static Function<Void, List<Callable<Integer>>> build = (Void) -> {
        final List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(new Task(List.of(1, 2, 3)));
        tasks.add(new Task(List.of(4, 5, 6)));
        tasks.add(new Task(List.of(7, 8, 9)));
        return tasks;
    };

    private static Function<List<Callable<Integer>>, List<Future<Integer>>> execute = (tasks) -> {
        final ExecutorService executorService = Executors.newFixedThreadPool(3);
        final List<Future<Integer>> futures = new ArrayList<>();
        try {
            futures.addAll(executorService.invokeAll(tasks));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        return futures;
    };

    private static Consumer<Future<Integer>> futureConsumer = (future) -> {
        if (future.isDone()) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    };

    private static Function<List<Future<Integer>>, Void> verify = (futures) -> {
        futures.stream().forEach(futureConsumer);
        return null;
    };

}
