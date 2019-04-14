package com.goinginfinity.hometest.services;

import com.goinginfinity.hometest.common.dtos.Book;
import com.goinginfinity.hometest.common.exceptions.AppException;
import com.goinginfinity.hometest.common.utils.Injector;
import com.goinginfinity.hometest.views.BooksSearchView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsoleLibrarySearchService implements LibrarySearchService {
    private BooksSearchView booksSearchView;
    private LibraryViewBookService libraryViewBookService;

    public ConsoleLibrarySearchService() throws AppException {
        this.booksSearchView = (BooksSearchView)Injector.getObject(BooksSearchView.class);
        this.libraryViewBookService = (LibraryViewBookService)Injector.getObject(LibraryViewBookService.class);
    }

    public List<Book> querySearchBooks(Map<Integer,Book> books,String query){
        return books.values().stream().filter(book->book.toString().contains(query))
                .collect(Collectors.toList());
    }
    @Override
    public void searchBooks(Map<Integer, Book> books) {
        String searchQuery = (String)this.booksSearchView.renderAndGetUserInput(books);
        List<Book> searchResult = querySearchBooks(books,searchQuery);
        int userInput = (int)this.booksSearchView.renderSearchResult(searchResult);
        if(userInput !=-15 && userInput>0) {
            Book selectedBook = books.get(userInput);
            int viewBookUserInput = libraryViewBookService.showBookDetails(selectedBook);
            while (viewBookUserInput != -15 && viewBookUserInput>0)
                viewBookUserInput = libraryViewBookService.showBookDetails(books.get(viewBookUserInput));
        }
    }
}
