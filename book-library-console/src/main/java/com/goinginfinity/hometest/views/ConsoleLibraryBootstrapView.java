package com.goinginfinity.hometest.views;

public class ConsoleLibraryBootstrapView implements LibraryBootstrapView {
    private String message;
    private int numOfBooks;
    public ConsoleLibraryBootstrapView(){
    }

    public String getMessage() {
        return message;
    }

    public int getNumOfBooks() {
        return numOfBooks;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setNumOfBooks(int numOfBooks) {
        this.numOfBooks = numOfBooks;
    }

    @Override
    public void render(Object input) {
        this.numOfBooks = (Integer)input;
        this.message = "Loaded "+numOfBooks+" books into library";

        System.out.println(this.message);
    }
}
