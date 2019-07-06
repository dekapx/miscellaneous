package com.kapx.testdriven.jmockit.employee;

import java.util.Date;

public class EmployeeEntity {
    private Long id;
    private String name;
    private String address;
    private Date dateOfBirth;
    private String email;
    private int phone;

    public EmployeeEntity(Long id, String name, String address, Date dateOfBirth, String email, int phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }
}
