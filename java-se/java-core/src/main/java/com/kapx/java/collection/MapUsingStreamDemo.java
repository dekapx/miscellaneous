package com.kapx.java.collection;

import static com.kapx.java.common.model.LanguageType.*;
import com.kapx.java.common.model.LanguageType;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapUsingStreamDemo {
    public static void main(String[] args) {
        final Map<LanguageType, String> languageTypes = createLanguageTypes();
        displayKeys(languageTypes);
        displayValues(languageTypes);
    }

    private static void displayKeys(final Map<LanguageType, String> languageTypes) {
        languageTypes.keySet().stream().forEach(System.out::println);
    }

    private static void displayValues(final Map<LanguageType, String> languageTypes) {
        languageTypes.values().stream().forEach(System.out::println);
    }

    private static Map<LanguageType, String> createLanguageTypes() {
        return Collections.unmodifiableMap(Stream.of(
                new SimpleImmutableEntry<>(OBJECT_ORIENTED, "Java"),
                new SimpleImmutableEntry<>(FUNCTIONAL, "Scala"),
                new SimpleImmutableEntry<>(SCRIPTING, "Python"),
                new SimpleImmutableEntry<>(REFLECTIVE, "Delphi"))
                .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue())));
    }

}
