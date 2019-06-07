package com.booklibrary.services;

import com.booklibrary.common.dtos.Book;
import com.booklibrary.common.exceptions.AppException;
import com.booklibrary.common.utils.Injector;
import com.booklibrary.repositories.BookRepository;
import com.booklibrary.views.LibraryClosureView;

import java.util.Map;

public class ConsoleBookLibraryClosure implements BookLibraryClosure {
    private BookRepository bookRepository;
    private LibraryClosureView libraryClosureView;

    public ConsoleBookLibraryClosure() throws AppException {
        this.bookRepository = (BookRepository) Injector.getObject(BookRepository.class);
        this.libraryClosureView = (LibraryClosureView)Injector.getObject(LibraryClosureView.class);
    }

    @Override
    public void saveAndExit(Map<Integer, Book> books) throws AppException {
        this.bookRepository.saveBooks(books);
        this.libraryClosureView.render("saved");
    }
}
