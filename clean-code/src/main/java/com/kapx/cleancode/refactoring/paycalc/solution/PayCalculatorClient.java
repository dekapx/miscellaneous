package com.kapx.cleancode.refactoring.paycalc.solution;

import java.util.ArrayList;
import java.util.List;

import static com.kapx.cleancode.refactoring.paycalc.solution.EmployeeFactory.*;

public class PayCalculatorClient {
    private PayCalculator payCalculator;

    public PayCalculatorClient() {
        this.payCalculator = new PayCalculator();
    }

    public static void main(String[] args) throws InvalidEmployeeTypeException {
        final PayCalculatorClient client = new PayCalculatorClient();
        final List<Employee> employees = client.createEmployees();
        client.calculatePay(employees);
    }

    public void calculatePay(final List<Employee> employees) throws InvalidEmployeeTypeException {
        for (Employee employee : employees) {
            final Money money = calculatePay(employee);
            System.out.println(employee.getType() + ":" + money.getPay());
        }
    }

    public Money calculatePay(final Employee employee) throws InvalidEmployeeTypeException {
        return payCalculator.calculatePay(employee);
    }

    public List<Employee> createEmployees() {
        final List<Employee> employees = new ArrayList<>(3);
        try {
            employees.add(createEmployee(SalariedEmployee.class));
            employees.add(createEmployee(CommissionedEmployee.class));
            employees.add(createEmployee(HourlyEmployee.class));
        } catch (InvalidEmployeeTypeException invalidEmployeeType) {
            invalidEmployeeType.printStackTrace();
        }
        return employees;
    }
}
