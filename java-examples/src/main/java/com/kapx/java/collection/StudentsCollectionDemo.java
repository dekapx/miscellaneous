package com.kapx.java.collection;

import java.util.ArrayList;
import java.util.List;

public class StudentsCollectionDemo {
    public static void main(String[] args) {
        final List<Student> students = getStudents();
        students.forEach(
                (final Student student) -> System.out.println(student.getStudentId() + " " + student.getName())
        );
    }

    private static List<Student> getStudents() {
        final List<Student> students = new ArrayList<>();
        students.add(new Student(1L, "Steve", 22));
        students.add(new Student(2L, "Bryan", 21));
        students.add(new Student(3L, "James", 24));
        students.add(new Student(4L, "Tom", 23));
        students.add(new Student(5L, "Mike", 26));

        return students;
    }
}
