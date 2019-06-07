package com.booklibrary.services;

import com.booklibrary.common.dtos.Book;
import com.booklibrary.common.exceptions.AppException;
import com.booklibrary.common.utils.Injector;
import com.booklibrary.views.BookEditionView;

import java.util.Map;

public class ConsoleLibraryEditService implements LibraryEditService {
    private BookEditionView bookEditionView;

    public ConsoleLibraryEditService() throws AppException {
        this.bookEditionView = (BookEditionView) Injector.getObject(BookEditionView.class);
    }
    @Override
    public void editBook(Map<Integer, Book> books) {
        this.bookEditionView.renderAndGetUserInput(books);
//        books.put(bookEdited.getId(),bookEdited);

    }
}
