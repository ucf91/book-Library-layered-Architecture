package com.goinginfinity.hometest.services;

import com.goinginfinity.hometest.common.dtos.Book;
import com.goinginfinity.hometest.common.exceptions.AppException;
import com.goinginfinity.hometest.common.utils.Injector;
import com.goinginfinity.hometest.views.LibraryBookDetailsView;

public class ConsoleLibraryViewBookService implements LibraryViewBookService {
    private LibraryBookDetailsView libraryViewBookDetailsView;
    public ConsoleLibraryViewBookService() throws AppException {
        this.libraryViewBookDetailsView = (LibraryBookDetailsView)Injector.getObject(LibraryBookDetailsView.class);
    }
    @Override
    public int showBookDetails(Book book) {
        int userInput = (int)libraryViewBookDetailsView.renderAndGetUserInput(book);
        return userInput;
    }
}
