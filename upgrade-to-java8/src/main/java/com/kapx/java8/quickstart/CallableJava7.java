package com.kapx.java8.quickstart;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

class CallableJava7 implements Callable<Integer> {
    private List<Integer> numbers;

    CallableJava7(final List<Integer> numbers) {
        this.numbers = new ArrayList<>();
        this.numbers.addAll(numbers);
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;

        for (Integer number : numbers) {
            if (isEven(number)) {
                sum = sum + number;
            }
        }
        return sum;
    }

    private boolean isEven(final Integer number) {
        return number % 2 == 0;
    }
}
