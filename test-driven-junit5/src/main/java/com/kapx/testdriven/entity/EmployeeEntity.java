package com.kapx.testdriven.entity;

public class EmployeeEntity {
    private Long id;
    private String firstName;
    private String lastName;
    private String dept;

    public EmployeeEntity(Long id, String firstName, String lastName, String dept) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dept = dept;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDept() {
        return dept;
    }
}
