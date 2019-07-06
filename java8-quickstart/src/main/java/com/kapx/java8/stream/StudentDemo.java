package com.kapx.java8.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentDemo {
    public static Predicate<Student> filtersJuniorsStudents() {
        return s -> s.getGrade().equals(Grade.JUNIOR_INFANTS);
    }

    public static Predicate<Student> filtersAthloneStudents() {
        return s -> s.getAddress().getCity().equals("Athlone");
    }

    public static Predicate<Student> filtersStudentsByGradeAndCity(final Grade grade, final String city) {
        return s -> grade.equals(s.getGrade()) && city.equals(s.getAddress().getCity());
    }

    public static List<Student> filterStudents(final List<Student> students, final Predicate<Student> predicate) {
        return students.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public static void display(final List<Student> students) {
        students.forEach(System.out::println);
    }

    public static void main(String[] args) {
        final List<Student> students = StudentHelper.getAll();
        System.out.println("//------------------------------------------------------------------//");
        final List<Student> juniorsFromAthlone = filterStudents(students, filtersStudentsByGradeAndCity(Grade.JUNIOR_INFANTS, "Athlone"));
        display(juniorsFromAthlone);
    }
}
