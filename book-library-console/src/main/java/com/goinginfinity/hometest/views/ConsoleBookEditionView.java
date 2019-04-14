package com.goinginfinity.hometest.views;

import com.goinginfinity.hometest.common.dtos.Book;
import com.goinginfinity.hometest.common.utils.Util;

import java.util.Map;

public class ConsoleBookEditionView implements BookEditionView {
    private String headerTitle;
    private String bookList;
    private String userPrompt;
    private String userPromptEdit;
    private String title;
    private String author;
    private String description;
    private String screen;
    private String confirmationMessage;
    private Map<Integer,Book> books;
    private String screenEditHome;

    public ConsoleBookEditionView() {
        this.headerTitle = "==== Edit a Book ====";
        this.userPrompt = "Enter the book ID of the book you want to edit; to return press <Enter>.\n"+"Book ID:";
        this.userPromptEdit = "Input the following information. To leave a field unchanged, hit <Enter>\n";
        this.title = "Title: ";
        this.author = "Author: ";
        this.description = "Description: ";
        this.confirmationMessage = "Book [%d] saved\n";
    }

    @Override
    public void render(Object input) {
        this.books = (Map)input;
        this.bookList = "";
        for(Book book:books.values()){
            bookList+=getformattedBookItem(book);
        }
        this.screenEditHome = this.headerTitle+"\n\n"+bookList+"\n\n"+this.userPrompt;
        System.out.println(this.screenEditHome);
    }

    @Override
    public Object renderAndGetUserInput(Object input) {
        render(input);
        int userInputBookChoosed = Util.readNumericInput();
        while((userInputBookChoosed<1 || userInputBookChoosed >books.size()) && userInputBookChoosed !=-15) {
            System.out.println("please Choose [1-"+books.size()+"]: ");
            userInputBookChoosed = Util.readNumericInput();
        }
        Book bookEdited = books.get(userInputBookChoosed);
        while(userInputBookChoosed !=-15) {
            System.out.println(this.userPromptEdit);
            System.out.print(this.title+"["+books.get(userInputBookChoosed).getTitle()+"]");
            String titleInput = Util.readAlphaInput();

            System.out.print(this.author+"["+books.get(userInputBookChoosed).getAuthor()+"]");
            String authorInput = Util.readAlphaInput();

            System.out.print(this.description+"["+books.get(userInputBookChoosed).getAuthor()+"]");
            String descriptionInput = Util.readAlphaInput();
            if(!titleInput.equals("")) bookEdited.setTitle(titleInput);
            if(!authorInput.equals("")) bookEdited.setAuthor(authorInput);
            if(!descriptionInput.equals("")) bookEdited.setDescription(descriptionInput);

            books.put(bookEdited.getId(), bookEdited);
            System.out.printf(this.confirmationMessage, bookEdited.getId());
            System.out.println(this.userPrompt);
            userInputBookChoosed = Util.readNumericInput();
        }
        return bookEdited;
    }
}
