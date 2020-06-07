package com.sumit.example.strategy.service;

import com.sumit.example.strategy.service.model.Book;

import java.util.List;

public interface BookService {
    public void addBook(Book book);
    public void updateBook(Book book);
    public List<Book> getBookById(String bookId);
}
