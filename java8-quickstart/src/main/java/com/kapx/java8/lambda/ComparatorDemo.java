package com.kapx.java8.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {
    private static Comparator<ProgrammingLanguage> sorter = (o1, o2) -> o1.getLanguage().compareTo(o2.getLanguage());

    public static void main(String[] args) {
        final List<ProgrammingLanguage> languages = getAll();
        languages.sort(sorter);
        display(languages);
    }

    private static void display(final List<ProgrammingLanguage> languages) {
        languages.forEach(l -> System.out.println(l.getLanguage()));
    }

    private static List<ProgrammingLanguage> getAll() {
        final List<ProgrammingLanguage> languages = new ArrayList<>();
        languages.add(ProgrammingLanguage.builder().language("Java").type("Object Oriented & Funcional").build());
        languages.add(ProgrammingLanguage.builder().language("Scala").type("Object Oriented & Funcional").build());
        languages.add(ProgrammingLanguage.builder().language("Haskall").type("Funcional").build());
        languages.add(ProgrammingLanguage.builder().language("Closure").type("Funcional").build());
        languages.add(ProgrammingLanguage.builder().language("Groovy").type("Scripting").build());
        languages.add(ProgrammingLanguage.builder().language("Python").type("Scripting").build());
        return languages;
    }
}
