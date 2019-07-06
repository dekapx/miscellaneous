package com.kapx.java.quickstart;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class SortingDemo {
    private static Predicate<Person> filterByAge(int age) {
        return p -> p.getAge() == age;
    };

    public static void main(String[] args) {
        List<Person> persons = sortByFirstName();
        persons.stream()
                .filter(filterByAge(30))
                .forEach(print);
    }

    private static Consumer<Person> print = (p) -> {
        System.out.println(p.getFirstName() + " " + p.getLastName() + " " + p.getAge());
    };

    private static List<Person> sortByFirstName() {
        List<Person> persons = createPersons();
        persons.sort(Comparator.comparing(Person::getFirstName));
        return persons;
    }

    private static List<Person> createPersons() {
        return Arrays.asList(
                Person.builder().firstName("Manpreet").lastName("Nanda").age(30).build(),
                Person.builder().firstName("Raman").lastName("Dumra").age(25).build(),
                Person.builder().firstName("Paramjit").lastName("Kaur").age(35).build(),
                Person.builder().firstName("Aditi").lastName("Singh").age(11).build(),
                Person.builder().firstName("Nicole").lastName("Singh").age(5).build()
        );
    }
}
