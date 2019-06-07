package com.booklibrary.services;

import com.booklibrary.views.LibraryBookDetailsView;
import com.booklibrary.common.dtos.Book;
import com.booklibrary.common.exceptions.AppException;
import com.booklibrary.common.utils.Injector;

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
