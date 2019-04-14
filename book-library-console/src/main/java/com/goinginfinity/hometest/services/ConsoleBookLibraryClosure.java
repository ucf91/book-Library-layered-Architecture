package com.goinginfinity.hometest.services;

import com.goinginfinity.hometest.ConsoleApplication;
import com.goinginfinity.hometest.common.dtos.Book;
import com.goinginfinity.hometest.common.exceptions.AppException;
import com.goinginfinity.hometest.common.utils.Injector;
import com.goinginfinity.hometest.repositories.BookRepository;
import com.goinginfinity.hometest.views.LibraryClosureView;

import java.util.Map;

public class ConsoleBookLibraryClosure implements BookLibraryClosure {
    private BookRepository bookRepository;
    private LibraryClosureView libraryClosureView;

    public ConsoleBookLibraryClosure() throws AppException {
        this.bookRepository = (BookRepository)Injector.getObject(BookRepository.class);
        this.libraryClosureView = (LibraryClosureView)Injector.getObject(LibraryClosureView.class);
    }

    @Override
    public void saveAndExit(Map<Integer, Book> books) throws AppException {
        this.bookRepository.saveBooks(books);
        this.libraryClosureView.render("saved");
    }
}
