package com.kapx.java.common.model;

import java.util.ArrayList;
import java.util.List;

import static com.kapx.java.common.model.LanguageType.*;
import static com.kapx.java.common.model.LanguageType.REFLECTIVE;

public class LanguageBuilder {
    public static List<Language> getLanguages() {
        final List<Language> languages = new ArrayList<>();

        languages.add(new Language("Java", OBJECT_ORIENTED));
        languages.add(new Language("C++", OBJECT_ORIENTED));
        languages.add(new Language("Scala", FUNCTIONAL));
        languages.add(new Language("Kotlin", FUNCTIONAL));
        languages.add(new Language("Haskal", FUNCTIONAL));
        languages.add(new Language("Closure", FUNCTIONAL));
        languages.add(new Language("Java Script", SCRIPTING));
        languages.add(new Language("Python", SCRIPTING));
        languages.add(new Language("Cobra", REFLECTIVE));
        languages.add(new Language("Delphi", REFLECTIVE));

        return languages;
    }
}
