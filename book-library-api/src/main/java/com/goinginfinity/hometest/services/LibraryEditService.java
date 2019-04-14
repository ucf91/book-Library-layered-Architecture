package com.goinginfinity.hometest.services;

import com.goinginfinity.hometest.common.dtos.Book;

import java.util.Map;

public interface LibraryEditService extends Service {
    public void editBook(Map<Integer, Book> books);
}
