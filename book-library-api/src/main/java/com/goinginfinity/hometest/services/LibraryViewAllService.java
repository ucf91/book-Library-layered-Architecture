package com.goinginfinity.hometest.services;

import com.goinginfinity.hometest.common.dtos.Book;

import java.util.Map;

public interface LibraryViewAllService extends Service {
    public void showAllBooks(Map<Integer, Book> books);
}
