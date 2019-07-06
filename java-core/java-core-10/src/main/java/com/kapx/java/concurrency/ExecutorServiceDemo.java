package com.kapx.java.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;

class Task implements Callable<Integer> {
    private List<Integer> numbers;

    Task(final List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers.size());
        this.numbers.addAll(numbers);
    }

    @Override
    public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return numbers
                .stream()
                .mapToInt(i -> i)
                .sum();
    }
}

public class ExecutorServiceDemo {
    public static void main(String[] args) throws Exception {
        final List<Callable<Integer>> tasks = buildTasks();
        final List<Future<Integer>> futures = executeTasks(tasks);
        futures.stream().forEach(futureConsumer);
    }

    private static Consumer<Future<Integer>> futureConsumer = (future) -> {
        if (future.isDone()) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException  | ExecutionException e) {
                e.printStackTrace();
            }
        }
    };

    private static List<Future<Integer>> executeTasks(final List<Callable<Integer>> tasks) throws Exception {
        final ExecutorService executorService = Executors.newFixedThreadPool(3);
        final List<Future<Integer>> futures = executorService.invokeAll(tasks);
        executorService.shutdown();
        return futures;
    }

    private static List<Callable<Integer>> buildTasks() {
        final List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(new Task(List.of(1, 2, 3)));
        tasks.add(new Task(List.of(4, 5, 6)));
        tasks.add(new Task(List.of(7, 8, 9)));
        return tasks;
    }
}
