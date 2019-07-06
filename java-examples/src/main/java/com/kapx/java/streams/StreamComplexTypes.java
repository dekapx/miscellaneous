package com.kapx.java.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamComplexTypes {
    public static void main(String[] args) {
        final List<Student> students = new ArrayList<>();
        students.add(new Student("Alex"));
        students.add(new Student("Martin"));
        students.add(new Student("Aaron"));
        students.add(new Student("James"));
        students.add(new Student("Steve"));
        students.add(new Student("Anya"));

        final Predicate<Student> studentPredicate = (Student s) -> s.getName().startsWith("A");

        final List<Student>  studentsStartsWithA = students.stream().filter(studentPredicate).collect(Collectors.toList());
        studentsStartsWithA.forEach(student -> System.out.println(student.getName()));
    }
}
