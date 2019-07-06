package com.kapx.testdriven.service;

import com.kapx.testdriven.dao.EmployeeDao;
import com.kapx.testdriven.dto.EmployeeDto;
import com.kapx.testdriven.entity.EmployeeEntity;
import static com.kapx.testdriven.util.EmployeeUtil.*;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(final EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    @Override
    public void save(final EmployeeDto employeeDto) {
        employeeDao.save(toEmployeeEntity(employeeDto));
    }

    @Override
    public void delete(final Long id) {
        employeeDao.delete(id);
    }

    @Override
    public EmployeeDto findById(final Long id) {
        final EmployeeEntity entity = employeeDao.findById(id);
        return toEmployeeDto(entity);
    }

    @Override
    public List<EmployeeDto> findAll() {
        final List<EmployeeEntity> entities = employeeDao.findAll();
        return toEmployeeDtos(entities);
    }
}
