package com.kapx.cleancode.refactoring.paycalc.solution;

public class EmployeeFactory {
    public static Employee createEmployee(final Class<? extends Employee> clazz) throws InvalidEmployeeTypeException {
        try {
            return (Employee) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            throw new InvalidEmployeeTypeException(e);
        } catch (IllegalAccessException e) {
            throw new InvalidEmployeeTypeException(e);
        } catch (ClassNotFoundException e) {
            throw new InvalidEmployeeTypeException(e);
        }
    }

}
