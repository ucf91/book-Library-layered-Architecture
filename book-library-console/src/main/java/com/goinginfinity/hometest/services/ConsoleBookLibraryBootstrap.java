package com.goinginfinity.hometest.services;

import com.goinginfinity.hometest.common.exceptions.AppException;
import com.goinginfinity.hometest.common.dtos.Book;
import com.goinginfinity.hometest.common.utils.Injector;
import com.goinginfinity.hometest.repositories.BookRepository;
import com.goinginfinity.hometest.views.LibraryBootstrapView;
import com.goinginfinity.hometest.views.LibraryHomeView;

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
