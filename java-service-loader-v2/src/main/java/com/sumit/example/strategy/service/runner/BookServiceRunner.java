package com.sumit.example.strategy.service.runner;

import com.sumit.example.strategy.service.BookService;
import com.sumit.example.strategy.service.MongoBookService;
import com.sumit.example.strategy.service.MySQLBookService;
import com.sumit.example.strategy.service.factory.ServiceLoaderSingleton;
import com.sumit.example.strategy.service.factory.ServiceProvider;
import com.sumit.example.strategy.service.factory.ServiceProviderImpl;
import com.sumit.example.strategy.service.util.BookServiceType;

public class BookServiceRunner {
    public static void main(String[] args) {
//        ServiceProvider serviceProvider = new ServiceProviderImpl();
//        BookService mysql = serviceProvider.getService(MySQLBookService.class);
//        System.out.println(mysql.getClass().getName());
//
//        BookService mongo = serviceProvider.getService(MongoBookService.class);
//        System.out.println(mongo.getClass().getName());

        BookService mysql = ServiceLoaderSingleton.INSTANCE.getService(BookServiceType.MYSQL);
        System.out.println(mysql.getClass().getName());
    }
}
