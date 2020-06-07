package com.sumit.example.strategy.service.factory;

public interface ServiceProvider {
    <T> T getService(Class<T> clazz);
}
