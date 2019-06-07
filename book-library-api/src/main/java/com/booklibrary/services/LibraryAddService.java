package com.booklibrary.services;

import com.booklibrary.common.dtos.Book;

import java.util.Map;

public interface LibraryAddService extends Service {
    public void addBook(Map<Integer, Book> books);
}
