package com.booklibrary.services;

import com.booklibrary.common.dtos.Book;
import com.booklibrary.common.exceptions.AppException;
import com.booklibrary.common.utils.Injector;
import com.booklibrary.views.AllBooksView;

import java.util.Map;

public class ConsoleLibraryViewAllService implements LibraryViewAllService {
    private AllBooksView allBooksView;
    private LibraryViewBookService libraryViewBookService;

    public ConsoleLibraryViewAllService() throws AppException {
        this.allBooksView = (AllBooksView) Injector.getObject(AllBooksView.class);
        this.libraryViewBookService = (LibraryViewBookService)Injector.getObject(LibraryViewBookService.class);
    }

    @Override
    public void showAllBooks(Map<Integer, Book> books) {
        int userInput = (int)allBooksView.renderAndGetUserInput(books);
        if(userInput !=-15 && userInput>0) {
            Book selectedBook = books.get(userInput);
            int viewBookUserInput = libraryViewBookService.showBookDetails(selectedBook);
            while (viewBookUserInput != -15 && viewBookUserInput>0)
                viewBookUserInput = libraryViewBookService.showBookDetails(books.get(viewBookUserInput));
        }
    }
}
