package com.kapx.testdriven.jmockit.employee;

public abstract class AbstractService<T> {
    protected abstract void validateEntity(T entity);
}
