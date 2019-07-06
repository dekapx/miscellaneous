package com.kapx.java8.stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.kapx.java8.stream.LanguageType.FUNCTIONAL;
import static com.kapx.java8.stream.LanguageType.OBJECT_ORIENTED;

public class StreamWithList {
    private static Predicate<Entry<String, LanguageType>> languageTypePredicate(final LanguageType type) {
        return entry -> entry.getValue().equals(type);
    }

    private static List<String> getFunctionalLanguage(final Map<String, LanguageType> languages) {
        return languages.entrySet()
                .stream()
                .filter(languageTypePredicate(FUNCTIONAL))
                .map(Entry::getKey)
                .sorted()
                .collect(Collectors.toList());
    }

    private static void printList(final List<String> languages) {
        languages.forEach(System.out::println);
    }

    private static Map<String, LanguageType> getLanguageMap() {
        final Map<String, LanguageType> languages = new HashMap<>();
        languages.put("C++", OBJECT_ORIENTED);
        languages.put("C#", OBJECT_ORIENTED);
        languages.put("Java", FUNCTIONAL);
        languages.put("Scala", FUNCTIONAL);
        languages.put("Closure", FUNCTIONAL);
        return languages;
    }

    public static void main(String[] args) {
        final Map<String, LanguageType> languageMap = getLanguageMap();
        printList(getFunctionalLanguage(languageMap));
    }
}
