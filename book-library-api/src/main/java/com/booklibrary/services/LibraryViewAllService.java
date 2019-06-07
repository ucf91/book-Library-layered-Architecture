package com.booklibrary.services;

import com.booklibrary.common.dtos.Book;

import java.util.Map;

public interface LibraryViewAllService extends Service {
    public void showAllBooks(Map<Integer, Book> books);
}
