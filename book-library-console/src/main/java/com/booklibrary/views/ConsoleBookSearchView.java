package com.booklibrary.views;

import com.booklibrary.common.dtos.Book;
import com.booklibrary.common.utils.Util;

import java.util.List;
import java.util.Map;

public class ConsoleBookSearchView implements BooksSearchView {
    private String titleHeader;
    private String userPrompt;
    private String searchResultMessage;
    private String searchResultContent;
    private String screen;
    private Map<Integer, Book> books;
    private List<Book> resultList;

    public ConsoleBookSearchView() {
        this.titleHeader = "==== Search ====";
        this.userPrompt = "Type in one or more keywords to search for\n\t Search:";
        this.searchResultMessage = "The following books matched your query. Enter the book ID to see more details, or <Enter> to return.";
    }

    @Override
    public void render(Object input) {
        this.books = (Map)input;
        this.screen = this.titleHeader+"\n\n"+this.userPrompt;
        System.out.print(this.screen);
    }

    @Override
    public Object renderAndGetUserInput(Object input) {
        render(input);
        return Util.readAlphaInput();
    }

    @Override
    public Object renderSearchResult(Object input) {
        this.resultList = (List)input;
        System.out.println(this.searchResultMessage);
        if(this.resultList.size() < 1)
            this.searchResultContent = "No book matched your query !";
        else {
            this.searchResultContent = "";
            for(Book book:this.resultList){
                this.searchResultContent+=getformattedBookItem(book);
            }

        }
        System.out.println(this.searchResultContent);
        int userInput = Util.readNumericInput();
        while((userInput<1 || userInput>books.size()) && userInput !=-15){
            userInput = Util.readNumericInput();
        }

        return userInput;
    }
}
