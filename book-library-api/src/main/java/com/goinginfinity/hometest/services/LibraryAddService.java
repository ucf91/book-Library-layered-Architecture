package com.goinginfinity.hometest.services;

import com.goinginfinity.hometest.common.dtos.Book;

import java.util.Map;

public interface LibraryAddService extends Service {
    public void addBook(Map<Integer, Book> books);
}
