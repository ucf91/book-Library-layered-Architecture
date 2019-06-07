package com.booklibrary.services;

import com.booklibrary.common.dtos.Book;
import com.booklibrary.common.utils.Injector;
import com.booklibrary.views.BookAdditionView;
import com.booklibrary.common.exceptions.AppException;

import java.util.Map;

public class ConsoleLibraryAddService implements LibraryAddService {
    private BookAdditionView bookAdditionView;

    public ConsoleLibraryAddService() throws AppException {
        this.bookAdditionView = (BookAdditionView) Injector.getObject(BookAdditionView.class);
    }

    @Override
    public void addBook(Map<Integer, Book> books) {
        Book bookAdded = (Book)this.bookAdditionView.renderAndGetUserInput(books);
        books.put(bookAdded.getId(),bookAdded);
    }
}
