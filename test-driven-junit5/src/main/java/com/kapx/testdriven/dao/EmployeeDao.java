package com.kapx.testdriven.dao;

import com.kapx.testdriven.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeDao {
    EmployeeEntity save(EmployeeEntity employeeEntity);

    void delete(Long id);

    EmployeeEntity findById(Long id);

    List<EmployeeEntity> findAll();
}
