package com.sumit.example.strategy.service.util;

import com.sumit.example.strategy.service.BookService;
import com.sumit.example.strategy.service.MongoBookService;
import com.sumit.example.strategy.service.MySQLBookService;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookServiceMapperImpl implements BookServiceMapper {
    private Map<BookServiceType, Class<? extends BookService>> map = Stream.of(
            new AbstractMap.SimpleImmutableEntry<>(BookServiceType.MYSQL, MySQLBookService.class),
            new AbstractMap.SimpleImmutableEntry<>(BookServiceType.MONGO, MongoBookService.class))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    @Override
    public Class<? extends BookService> getClassByType(BookServiceType type) {
        return map.get(type);
    }
}
