package com.kapx.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTransformationWithcomplexTypes {
    private class Person {
        private final String name;
        Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
    }

    private static void example1(final List<String> friends) {
        final List<String> uppercaseNames = new ArrayList<String>();
    }

}
