package com.kapx.java.streams;

public class Student
{
    private long id;
    private String name;
    private double marks;

    public Student(final StudentBuilder studentBuilder) {
        this.id = studentBuilder.id;
        this.name = studentBuilder.name;
        this.marks = studentBuilder.marks;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public static class StudentBuilder {
        private long id;
        private String name;
        private double marks;

        public StudentBuilder withId(final long id) {
            this.id = id;
            return this;
        }

        public StudentBuilder withName(final String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder withMarks(final double marks) {
            this.marks = marks;
            return this;
        }

        public Student build()
        {
            return new Student(this);
        }
    }

    @Override
    public String toString()
    {
        return id + " " + name + " " + marks;
    }
}
