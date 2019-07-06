package com.kapx.java.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambdaExample {
    public static void main(String[] args) {
        final Comparator<Person> sortByFirstName = (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName());

        final List<Person> persons = new ArrayList<>(5);
        persons.add(new Person("Chris", "Brown"));
        persons.add(new Person("Adam", "Hall"));
        persons.add(new Person("George", "White"));
        persons.add(new Person("Steve", "Austin"));
        persons.add(new Person("Graham", "Smith"));

        display(persons);
        persons.sort(sortByFirstName);
        System.out.println("--------------------------------");
        display(persons);
    }

    private static void display(final List<Person> persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
