package com.kapx.java8.quickstart;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Predicate;

class CallableJava8 implements Callable<Integer> {
    private List<Integer> numbers;

    private Predicate<Integer> isEven() {
        return i -> i % 2 == 0;
    };

    CallableJava8(final List<Integer> numbers) {
        this.numbers = new ArrayList<>();
        this.numbers.addAll(numbers);
    }

    @Override
    public Integer call() throws Exception {
        return numbers.stream().filter(isEven()).mapToInt(i -> i).sum();
    }
}
