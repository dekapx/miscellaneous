package com.kapx.java8.stream;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.kapx.java8.stream.LanguageType.FUNCTIONAL;
import static com.kapx.java8.stream.LanguageType.OBJECT_ORIENTED;

public class StreamWithMaps {
    private static Predicate<Entry<String, LanguageType>> languageNamePredicate(final String name) {
        return entry -> entry.getKey().equals(name);
    }

    private static Predicate<Entry<String, LanguageType>> languageTypePredicate(final LanguageType type) {
        return entry -> entry.getValue().equals(type);
    }

    private static Consumer<Entry> consumer = (final Entry entry) -> {
        System.out.println(entry.getKey() + " -> " + entry.getValue());
    };

    private static Entry<String, LanguageType> findLanguageByName(final Map<String, LanguageType> languages, final String name) {
        return languages.entrySet()
                .stream()
                .filter(languageNamePredicate(name))
                .findFirst()
                .orElseThrow(() -> new ObjectNotFoundException(name));
    }


    private static Map<String, LanguageType> getFunctionalLanguageMap(final Map<String, LanguageType> languages) {
        return languages.entrySet()
                .stream()
                .filter(languageTypePredicate(FUNCTIONAL))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    private static void printMap(final Map<String, LanguageType> languageMap) {
        languageMap.forEach((key, value) ->  {
            System.out.println(key + " -> " + value);
        });
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
        printMap(getFunctionalLanguageMap(languageMap));
        System.out.println("//---------------------------------------//");
        consumer.accept(findLanguageByName(languageMap, "Java"));
        System.out.println("//---------------------------------------//");
        consumer.accept(findLanguageByName(languageMap, "Kotlin"));
    }
}
