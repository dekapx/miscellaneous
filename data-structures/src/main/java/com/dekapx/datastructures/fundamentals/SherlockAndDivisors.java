package com.dekapx.datastructures.fundamentals;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.IntStream;



public class SherlockAndDivisors {
    private static Consumer<Scanner> consumer = (scanner) -> {
        int nextValue = scanner.nextInt();
        int count = 0; // count of even divisors
        if (nextValue % 2 == 0)
        {
            for (int i = 1; i < Math.sqrt(nextValue); i++)
            {
                if (nextValue % i == 0)
                { // i is a divisor
                    if (i % 2 == 0) // i is even
                    {
                        count++;
                    }
                    if ((nextValue / i) % 2 == 0) // quotient is even
                    {
                        count++;
                    }
                }
            }
            if (Math.sqrt(nextValue) % 2 == 0) // sqrt is even divisor
            {
                count++;
            }
        }
        System.out.println(count);
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        IntStream.range(0, numberOfTests).forEach(i-> consumer.accept(scanner));
        scanner.close();
    }
}
