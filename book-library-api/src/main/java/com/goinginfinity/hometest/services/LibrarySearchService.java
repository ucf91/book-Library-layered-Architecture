package com.goinginfinity.hometest.services;

import com.goinginfinity.hometest.common.dtos.Book;

import java.util.Map;

public interface LibrarySearchService extends Service {
    public void searchBooks(Map<Integer, Book> books);
}
