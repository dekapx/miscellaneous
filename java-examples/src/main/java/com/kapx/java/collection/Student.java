package com.kapx.java.collection;

public class Student {
    private final long studentId;
    private final String name;
    private final int age;

    public Student(final long studentId, final String name, final int age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
    }

    public long getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
