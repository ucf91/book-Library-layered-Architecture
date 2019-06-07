package com.booklibrary.services;

import com.booklibrary.common.exceptions.AppException;
import com.booklibrary.common.utils.Injector;
import com.booklibrary.views.LibraryHomeView;

public class ConsoleLibraryHomeService implements LibraryHomeService {
    private LibraryHomeView libraryHomeView;


    public ConsoleLibraryHomeService() throws AppException {
        this.libraryHomeView = (LibraryHomeView) Injector.getObject(LibraryHomeView.class);
    }
    @Override
    public int showMenu() {
        Object userInput = libraryHomeView.renderAndGetUserInput();
        return (int)userInput;
    }
}
