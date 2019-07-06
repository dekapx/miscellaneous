package com.dekapx.datastructures.fundamentals;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.IntStream;

@FunctionalInterface
interface SymmetricPoint {
    int coordinates(int x, int y);
}

public class FindPoint {

    private static SymmetricPoint symmetricPoint = (x, y) -> {
        return (2 * x - y);
    };

    private static Consumer<Scanner> consumer = (scanner) -> {
        final int px = scanner.nextInt();
        final int py = scanner.nextInt();
        final int qx = scanner.nextInt();
        final int qy = scanner.nextInt();
        final int coordinateX = symmetricPoint.coordinates(qx, px);
        final int coordinateY = symmetricPoint.coordinates(qy, py);

        System.out.println(String.join(" ", String.valueOf(coordinateX), String.valueOf(coordinateY)));
    };

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numberOfTests = scanner.nextInt();
        IntStream.range(0, numberOfTests).forEach(i -> consumer.accept(scanner));
    }
}
