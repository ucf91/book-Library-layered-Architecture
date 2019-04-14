package com.goinginfinity.hometest.services;

import com.goinginfinity.hometest.common.exceptions.AppException;
import com.goinginfinity.hometest.common.utils.Injector;
import com.goinginfinity.hometest.views.LibraryHomeView;

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
