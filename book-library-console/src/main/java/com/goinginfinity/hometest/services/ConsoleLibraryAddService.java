package com.goinginfinity.hometest.services;

import com.goinginfinity.hometest.common.dtos.Book;
import com.goinginfinity.hometest.common.exceptions.AppException;
import com.goinginfinity.hometest.common.utils.Injector;
import com.goinginfinity.hometest.views.BookAdditionView;

import java.util.Map;

public class ConsoleLibraryAddService implements LibraryAddService {
    private BookAdditionView bookAdditionView;

    public ConsoleLibraryAddService() throws AppException {
        this.bookAdditionView = (BookAdditionView)Injector.getObject(BookAdditionView.class);
    }

    @Override
    public void addBook(Map<Integer, Book> books) {
        Book bookAdded = (Book)this.bookAdditionView.renderAndGetUserInput(books);
        books.put(bookAdded.getId(),bookAdded);
    }
}
