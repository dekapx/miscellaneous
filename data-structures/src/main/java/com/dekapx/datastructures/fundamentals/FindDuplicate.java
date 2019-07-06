package com.dekapx.datastructures.fundamentals;

import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicate {
    public static void main(String[] args) {
        final int[] numbers = {1, 3, 1, 4, 5, 6, 3, 2};

        final int repeatCount = countRepeatedValues(numbers);
        System.out.println(repeatCount);
    }

    private static int countRepeatedValues(int[] numbers) {
        int repeatCount = 0;
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length; i ++) {
            if(i > 0 && numbers[i] == numbers[i - 1]) {
                repeatCount ++;
            }
        }
        return repeatCount;
    }

}
