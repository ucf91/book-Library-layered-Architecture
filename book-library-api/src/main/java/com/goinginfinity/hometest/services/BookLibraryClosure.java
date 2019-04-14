package com.goinginfinity.hometest.services;

import com.goinginfinity.hometest.common.dtos.Book;
import com.goinginfinity.hometest.common.exceptions.AppException;

import java.util.Map;


public interface BookLibraryClosure extends Service {
    public void saveAndExit(Map<Integer, Book> books) throws AppException;
}
