package com.kapx.java.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamMathExample {
    public static void main(String[] args) {
        List<Student> studentsScored80Plus = getStudentsByMarks(80);
        displayStudents(studentsScored80Plus);

        System.out.println("Total of marks: " + getSumOfMarks());
        System.out.println("Lowest marks: " + getLowestMarks());
        System.out.println("Highst marks: " + getHighstMarks());

        List<Student> studentsBetween50And90 = findStudentsByRange(50, 90);
        displayStudents(studentsBetween50And90);
    }

    private static double getSumOfMarks() {
        final List<Student> students = createStudents();
        return students.stream().mapToDouble(student -> student.getMarks()).sum();
    }

    private static double getLowestMarks() {
        final List<Student> students = createStudents();
        return students.stream().mapToDouble(student -> student.getMarks()).min().getAsDouble();
    }

    private static double getHighstMarks() {
        final List<Student> students = createStudents();
        return students.stream().mapToDouble(student -> student.getMarks()).max().getAsDouble();
    }

    private static List<Student> getStudentsByMarks(final int marks) {
        final List<Student> students = createStudents();
        return students.stream().filter(s -> s.getMarks() > marks).collect(Collectors.toList());
    }

    private static List<Student> findStudentsByRange(final int from, final int to) {
        final Predicate<Student> predicate = student -> student.getMarks() > from && student.getMarks() < to;
        final List<Student> students = createStudents();
        return students.stream().filter(predicate).collect(Collectors.toList());
    }

    private static void displayStudents(final List<Student> students) {
        students.stream().forEach(System.out::println);
    }

    private static List<Student> createStudents() {
        final List<Student> students = new ArrayList<>();

        students.add(new Student.StudentBuilder()
                .withId(3)
                .withName("John")
                .withMarks(55.80)
                .build());
        students.add(new Student.StudentBuilder()
                .withId(1)
                .withName("Scott")
                .withMarks(33.45)
                .build());
        students.add(new Student.StudentBuilder()
                .withId(4)
                .withName("Aditi")
                .withMarks(88.80)
                .build());
        students.add(new Student.StudentBuilder()
                .withId(5)
                .withName("Nicole")
                .withMarks(99.80)
                .build());
        students.add(new Student.StudentBuilder()
                .withId(2)
                .withName("Mitchell")
                .withMarks(77.80)
                .build());
        return students;
    }
}
