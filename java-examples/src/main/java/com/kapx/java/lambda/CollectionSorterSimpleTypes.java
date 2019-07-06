package com.kapx.java.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionSorterSimpleTypes {

    public static void main(String[] args) {

        sortCollectionJava7();
        sortCollectionJava8();
    }

    private static final void sortCollectionJava8() {
        final List<String> languages = Arrays.asList("Scala", "Java", "Clojure", "Haskal", "Python");
        Collections.sort(languages, (String a, String b) -> b.compareTo(a));
        System.out.println(languages);
    }

    private static final void sortCollectionJava7() {
        final List<String> languages = Arrays.asList("Scala", "Java", "Clojure", "Haskal", "Python");
        Collections.sort(languages, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });

        System.out.println(languages);
    }
}
