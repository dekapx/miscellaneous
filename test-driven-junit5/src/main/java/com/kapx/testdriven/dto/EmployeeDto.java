package com.kapx.testdriven.dto;

public class EmployeeDto {
    private String firstName;
    private String lastName;
    private String dept;

    public EmployeeDto(String firstName, String lastName, String dept) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dept = dept;
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
