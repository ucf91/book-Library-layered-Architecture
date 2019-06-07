package com.booklibrary.services;

import com.booklibrary.common.exceptions.AppException;
import com.booklibrary.common.dtos.Book;

import java.util.Map;

public interface BookLibraryBootstrap extends Service{
    public Map<Integer,Book> loadAllBooks() throws AppException;
}
