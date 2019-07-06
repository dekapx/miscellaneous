package com.kapx.java.streams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StreamDemo {
    public static void main(String[] args) {
        final List<Integer> list = Arrays.asList(10, 20, 30, 40, 50, 60, 70);

        System.out.println(sumIterator(list));
        System.out.println(sumStream(list));
    }

    private static int sumStream(final List<Integer> list) {
        return list.stream()
                .filter(i -> i > 10)
                .mapToInt(i -> i)
                .sum();
    }

    private static int sumIterator (final List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        int sum = 0;
        while (it.hasNext()) {
            int num = it.next();
            if (num > 10) {
                sum += num;
            }
        }
        return sum;
    }
}
