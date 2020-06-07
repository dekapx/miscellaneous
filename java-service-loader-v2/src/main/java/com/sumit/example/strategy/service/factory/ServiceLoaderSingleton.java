package com.sumit.example.strategy.service.factory;

import com.sumit.example.strategy.service.BookService;
import com.sumit.example.strategy.service.util.BookServiceMapper;
import com.sumit.example.strategy.service.util.BookServiceMapperImpl;
import com.sumit.example.strategy.service.util.BookServiceType;

import java.util.ServiceLoader;

public enum ServiceLoaderSingleton {
    INSTANCE;

    private BookServiceMapper bookServiceMapper;

    public <T> T getService(Class<T> clazz) {
        final ServiceLoader<T> serviceLoader = ServiceLoader.load(clazz);
        return serviceLoader.iterator().next();
    }

    public <T extends BookService> T getService(BookServiceType type) {
        bookServiceMapper = new BookServiceMapperImpl();
        final Class<? extends BookService> clazz = bookServiceMapper.getClassByType(type);
        final ServiceLoader<? extends BookService> serviceLoader = ServiceLoader.load(clazz);
        return (T) serviceLoader.iterator().next();
    }
}
