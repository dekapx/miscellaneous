package com.kapx.java.collection;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ListTraversalDemo {
    public static void main(String[] args) {
        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    }

    private static void traversalExample1(final List<String> friends) {
        friends.forEach(new Consumer<String>() {
            public void accept(final String name) {
                System.out.println(name);
            }
        });
    }

    private static void traversalExample2(final List<String> friends) {
        friends.forEach((final String name) -> System.out.println(name));
    }

    private static void traversalExample3(final List<String> friends) {
        friends.forEach((name) -> System.out.println(name));
    }

    private static void traversalExample4(final List<String> friends) {
        friends.forEach(name -> System.out.println(name));
    }

    private static void traversalExample5(final List<String> friends) {
        friends.forEach(System.out::println);
    }
}
