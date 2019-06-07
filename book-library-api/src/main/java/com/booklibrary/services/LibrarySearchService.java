package com.booklibrary.services;

import com.booklibrary.common.dtos.Book;

import java.util.Map;

public interface LibrarySearchService extends Service {
    public void searchBooks(Map<Integer, Book> books);
}
