package com.goinginfinity.hometest.services;

import com.goinginfinity.hometest.common.exceptions.AppException;
import com.goinginfinity.hometest.common.dtos.Book;

import java.util.Map;

public interface BookLibraryBootstrap extends Service{
    public Map<Integer,Book> loadAllBooks() throws AppException;
}
