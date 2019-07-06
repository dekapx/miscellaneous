package com.kapx.testdriven.entity;

public class EmployeeEntityBuilder {
    private Long id;
    private String firstName;
    private String lastName;
    private String dept;

    private EmployeeEntityBuilder() {
    }

    public static EmployeeEntityBuilder builder() {
        return  new EmployeeEntityBuilder();
    }

    public EmployeeEntityBuilder id(final Long id) {
        this.id = id;
        return this;
    }

    public EmployeeEntityBuilder firstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EmployeeEntityBuilder lastName(final String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EmployeeEntityBuilder dept(final String dept) {
        this.dept = dept;
        return this;
    }

    public EmployeeEntity build() {
        return new EmployeeEntity(id, firstName, lastName, dept);
    }

}
