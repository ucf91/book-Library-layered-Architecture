package com.booklibrary.views;

public class ConsoleLibraryClosureView implements LibraryClosureView {
    private String confirmationMessage = "Library Saved.";
    @Override
    public void render(Object input) {
        System.out.println(this.confirmationMessage);
    }
}
