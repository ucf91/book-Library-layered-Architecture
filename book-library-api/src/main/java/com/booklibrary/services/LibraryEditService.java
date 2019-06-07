package com.booklibrary.services;

import com.booklibrary.common.dtos.Book;

import java.util.Map;

public interface LibraryEditService extends Service {
    public void editBook(Map<Integer, Book> books);
}
