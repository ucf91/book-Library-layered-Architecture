package com.goinginfinity.hometest.services;

import com.goinginfinity.hometest.common.dtos.Book;
import com.goinginfinity.hometest.common.exceptions.AppException;
import com.goinginfinity.hometest.common.utils.Injector;
import com.goinginfinity.hometest.views.BookEditionView;

import java.util.Map;

public class ConsoleLibraryEditService implements LibraryEditService {
    private BookEditionView bookEditionView;

    public ConsoleLibraryEditService() throws AppException {
        this.bookEditionView = (BookEditionView)Injector.getObject(BookEditionView.class);
    }
    @Override
    public void editBook(Map<Integer, Book> books) {
        this.bookEditionView.renderAndGetUserInput(books);
//        books.put(bookEdited.getId(),bookEdited);

    }
}
