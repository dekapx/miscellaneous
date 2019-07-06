package com.kapx.testdriven.service;

import com.kapx.testdriven.dto.EmployeeDto;
import com.kapx.testdriven.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    void save(EmployeeDto employeeDto);

    void delete(Long id);

    EmployeeDto findById(Long id);

    List<EmployeeDto> findAll();
}
