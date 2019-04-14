package com.goinginfinity.hometest.views;

import com.goinginfinity.hometest.common.dtos.Book;
import com.goinginfinity.hometest.common.utils.Util;

import java.util.Map;

public class ConsoleBookAdditionView implements BookAdditionView {
    private String headerTitle;
    private String userPrompt;
    private String title;
    private String author;
    private String description;
    private String screen;
    private String confirmationMessage;
    private Map<Integer,Book> books;

    public ConsoleBookAdditionView() {
        this.headerTitle = "==== Add a Book ====";
        this.userPrompt = "Please enter the following information: ";

        this.title = "Title: ";
        this.author = "Author: ";
        this.description = "Description: ";
        this.confirmationMessage = "Book [%d] saved\n";
    }

    @Override
    public void render(Object input) {
        this.books = (Map)input;
        this.screen = headerTitle+"\n\n"+userPrompt+"\n\n";
        System.out.println(this.screen);
    }

    @Override
    public Object renderAndGetUserInput(Object input) {
        render(input);
        Book bookAdded = new Book();

        System.out.print(this.title);
        String titleInput = Util.readAlphaInput();

        System.out.print(this.author);
        String authorInput = Util.readAlphaInput();

        System.out.print(this.description);
        String descriptionInput = Util.readAlphaInput();
        bookAdded.setId(this.books.size()+1);
        bookAdded.setTitle(titleInput);
        bookAdded.setAuthor(authorInput);
        bookAdded.setDescription(descriptionInput);

        System.out.printf(this.confirmationMessage,bookAdded.getId());
        return bookAdded;
    }
}
