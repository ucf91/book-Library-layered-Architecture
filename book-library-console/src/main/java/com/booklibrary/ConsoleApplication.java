package com.booklibrary;

import com.booklibrary.common.exceptions.AppException;
import com.booklibrary.common.dtos.Book;
import com.booklibrary.common.utils.Injector;
import com.booklibrary.services.*;



import java.util.Map;

public class ConsoleApplication implements Application {
    private BookLibraryBootstrap bookLibraryBootstrap;
    private BookLibraryClosure bookLibraryClosure;
    private LibraryHomeService libraryHomeService;
    private LibraryAddService libraryAddService;
    private LibraryEditService libraryEditService;
    private LibrarySearchService librarySearchService;
    private LibraryViewAllService libraryViewAllService;
    private static Map<Integer, Book> books;


    public ConsoleApplication() throws AppException {
        this.bookLibraryBootstrap = (BookLibraryBootstrap) Injector.getObject(BookLibraryBootstrap.class);
        this.bookLibraryClosure = (BookLibraryClosure) Injector.getObject(BookLibraryClosure.class);
        this.libraryHomeService = (LibraryHomeService) Injector.getObject(LibraryHomeService.class);
        this.libraryAddService = (LibraryAddService) Injector.getObject(LibraryAddService.class);
        this.libraryEditService = (LibraryEditService) Injector.getObject(LibraryEditService.class);
        this.librarySearchService = (LibrarySearchService) Injector.getObject(LibrarySearchService.class);
        this.libraryViewAllService = (LibraryViewAllService) Injector.getObject(LibraryViewAllService.class);

    }

    public void run() throws AppException {

        books = this.bookLibraryBootstrap.loadAllBooks();
        boolean isRunning = true;
        while(isRunning){
            int userInput = libraryHomeService.showMenu();
            switch (userInput){
                case 1:
                    libraryViewAllService.showAllBooks(books);
                    break;

                case 2:
                    libraryAddService.addBook(books);
                    break;

                case 3:
                    libraryEditService.editBook(books);
                    break;

                case 4:
                    librarySearchService.searchBooks(books);
                    break;

                case 5:
                    bookLibraryClosure.saveAndExit(books);
                    isRunning = false;
                    break;


            }
        }

    }

}
