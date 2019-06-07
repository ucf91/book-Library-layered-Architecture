package com.booklibrary.views;

import com.booklibrary.common.dtos.Book;

public interface ViewWithUserInput extends View {
    default Object renderAndGetUserInput(){return renderAndGetUserInput("");}
    default String getformattedBookItem(Book book){
        return "["+book.getId()+"] "+book.getTitle()+"\n";
    }
    public Object renderAndGetUserInput(Object input);
}
