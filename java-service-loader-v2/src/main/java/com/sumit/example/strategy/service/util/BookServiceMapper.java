package com.sumit.example.strategy.service.util;

import com.sumit.example.strategy.service.BookService;

public interface BookServiceMapper {
    Class<? extends BookService> getClassByType(BookServiceType type);
}
