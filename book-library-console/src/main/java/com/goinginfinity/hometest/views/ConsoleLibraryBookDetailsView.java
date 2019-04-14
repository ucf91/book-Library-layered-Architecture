package com.goinginfinity.hometest.views;

import com.goinginfinity.hometest.common.dtos.Book;
import com.goinginfinity.hometest.common.utils.Util;

public class ConsoleLibraryBookDetailsView implements LibraryBookDetailsView {
    private String bookDetails;
    private Book bookObject;
    private String userPrompt;
    private String screen;

    public ConsoleLibraryBookDetailsView() {
        this.userPrompt = "To view details enter the book ID, to return press <Enter>.\n Book ID: ";
    }
    @Override
    public void render(Object input) {
        this.bookObject = (Book)input;
        bookDetails="ID: "+this.bookObject.getId()+"\n";
        bookDetails+="Title: "+this.bookObject.getTitle()+"\n";
        bookDetails+="Author: "+this.bookObject.getAuthor()+"\n";
        bookDetails+="Description: "+this.bookObject.getDescription();

        this.screen = bookDetails+"\n\n"+userPrompt;
        System.out.print(this.screen);
    }
    @Override
    public Object renderAndGetUserInput(Object input) {
        render(input);
        int userInput = Util.readNumericInput();
        while(userInput<1 && userInput!=-15) {
            System.out.println("please Choose valid number :");
            userInput = Util.readNumericInput();
        }

        return userInput;
    }


}
