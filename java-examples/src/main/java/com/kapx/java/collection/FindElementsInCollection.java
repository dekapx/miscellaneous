package com.kapx.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindElementsInCollection {
    public static void main(String[] args) {
        final List<String> names = Arrays.asList("Amy", "Bryan", "Anna", "Maria", "Aoife");

        // Java 7 approach...
//        final List<String> startsWitA = new ArrayList<String>();
//        for(String name : names) {
//            if(name.startsWith("A")) {
//                startsWitA.add(name);
//            }
//        }

        // Java 8 approach...
        final List<String> startsWitA = names.stream()
                .filter(name -> name.startsWith("A")).collect(Collectors.toList());

        startsWitA.forEach(
                (final String name) -> System.out.println(name)
        );
    }
}
