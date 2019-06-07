package com.booklibrary.services;

import com.booklibrary.common.dtos.Book;
import com.booklibrary.common.exceptions.AppException;

import java.util.Map;


public interface BookLibraryClosure extends Service {
    public void saveAndExit(Map<Integer, Book> books) throws AppException;
}
