package com.booklibrary.services;

import com.booklibrary.common.exceptions.AppException;
import com.booklibrary.common.dtos.Book;
import com.booklibrary.common.utils.Injector;
import com.booklibrary.repositories.BookRepository;
import com.booklibrary.views.LibraryBootstrapView;
import com.booklibrary.views.LibraryHomeView;

import java.util.Map;


public class ConsoleBookLibraryBootstrap implements BookLibraryBootstrap {
    private BookRepository bookRepository;
    private LibraryBootstrapView libraryBootstrapView;
    private LibraryHomeView libraryHomeView;
    public ConsoleBookLibraryBootstrap() throws AppException {
        this.bookRepository = (BookRepository) Injector.getObject(BookRepository.class);
        this.libraryBootstrapView = (LibraryBootstrapView)Injector.getObject(LibraryBootstrapView.class);
        this.libraryHomeView = (LibraryHomeView)Injector.getObject((LibraryHomeView.class));
    }
    @Override
    public Map<Integer, Book> loadAllBooks() throws AppException {
        Map<Integer,Book> bookMap = this.bookRepository.loadAllBooks();
        this.libraryBootstrapView.render(bookMap.size());
        return bookMap;
    }
}
