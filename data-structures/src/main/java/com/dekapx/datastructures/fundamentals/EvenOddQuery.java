package com.dekapx.datastructures.fundamentals;

import java.util.Scanner;

public class EvenOddQuery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int size = scanner.nextInt();
        final int[] elements = new int[size+1];
        for (int i = 1; i < size+1; i++)
            elements[i] = scanner.nextInt();
        final int numberOfTests = scanner.nextInt();
        for (int j = 0; j < numberOfTests; j++) {
            int leftIndex = scanner.nextInt();
            int rightIndex = scanner.nextInt();
            if (elements[leftIndex] % 2 == 1)
                System.out.println("Odd");
            else {
                if (leftIndex == rightIndex)
                    System.out.println("Even");
                else if (elements[leftIndex+1] == 0)
                    System.out.println("Odd");
                else
                    System.out.println("Even");
            }
        }
    }
}
