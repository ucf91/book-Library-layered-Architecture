package com.booklibrary.views;

import com.booklibrary.common.utils.Util;

public class ConsoleLibraryHomeView implements LibraryHomeView {
    private String headerTitle;
    private String menu;
    private String userPrompt;
    private String screen;

    public ConsoleLibraryHomeView(){
        this.headerTitle = "==== Book Manager ====";
        this.menu = "1) View All Books\n";
        this.menu+= "2) Add a book\n";
        this.menu+= "3) Edit a book\n";
        this.menu+= "4) Search for a book\n";
        this.menu+= "5) Save and exit";

        this.userPrompt = "Choose [1-5]: ";

    }

    @Override
    public void render(Object input) {
        screen = headerTitle+"\n"+menu+"\n\n"+userPrompt;
        System.out.print(screen);
    }


    @Override
    public Object renderAndGetUserInput(Object input) {
        render(input);
        int userInput = Util.readNumericInput();
        while(userInput<1 || userInput >5) {
            System.out.println("please Choose [1-5]: ");
            userInput = Util.readNumericInput();
        }

        return userInput;
    }
}
