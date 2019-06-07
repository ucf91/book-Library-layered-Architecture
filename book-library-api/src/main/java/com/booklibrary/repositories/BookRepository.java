package com.booklibrary.repositories;

import com.booklibrary.common.dtos.Book;
import com.booklibrary.common.exceptions.AppException;

import java.util.Map;

public interface BookRepository {
    public Map<Integer, Book> loadAllBooks() throws AppException;
    public void saveBooks(Map<Integer,Book> books) throws AppException;
}
