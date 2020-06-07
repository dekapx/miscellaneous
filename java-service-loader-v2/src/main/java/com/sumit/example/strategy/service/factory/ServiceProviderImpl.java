package com.sumit.example.strategy.service.factory;

import java.util.ServiceLoader;

public class ServiceProviderImpl implements ServiceProvider {
    @Override
    public <T> T getService(Class<T> clazz) {
        final ServiceLoader<T> serviceLoader = ServiceLoader.load(clazz);
        return serviceLoader.iterator().next();
    }
}
