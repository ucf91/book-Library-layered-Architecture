package com.goinginfinity.hometest.repositories;

import com.goinginfinity.hometest.common.exceptions.AppException;
import com.goinginfinity.hometest.common.dtos.Book;

import java.util.List;
import java.util.Map;

public interface BookRepository {
    public Map<Integer,Book> loadAllBooks() throws AppException;
    public void saveBooks(Map<Integer,Book> books) throws AppException;
}
