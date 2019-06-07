package com.booklibrary.views;

import com.booklibrary.common.dtos.Book;
import com.booklibrary.common.utils.Util;

import java.util.Map;

public class ConsoleAllBooksView implements AllBooksView {
    private String headerTitle;
    private String bookList;
    private String userPrompt;
    private String screen;
    private Map<Integer,Book> books;

    public ConsoleAllBooksView() {
        this.headerTitle = "==== View Books ====";
        this.userPrompt = "To view details enter the book ID, to return press <Enter>.\n Book ID: ";

    }


    @Override
    public void render(Object input) {
        this.bookList = "";
        books = (Map)input;
        if(books.size()>0) {
            for (Book book : books.values()) {
                bookList += getformattedBookItem(book);
            }
            screen = headerTitle+"\n"+bookList+"\n\n"+userPrompt;
        }else {
            bookList = "No books to show";
            screen =  headerTitle+"\n"+bookList+"\n\n";
        }
        System.out.print(screen);
    }

    @Override
    public Object renderAndGetUserInput(Object input) {
        render(input);
        int userInput=0;
        if(books.size()>0) {
            userInput = Util.readNumericInput();
            while((userInput<1 || userInput >books.size()) && userInput !=-15) {

                System.out.println("please Choose [1-" + books.size() + "]: ");
                userInput = Util.readNumericInput();
            }
        }

        return userInput;
    }
}
