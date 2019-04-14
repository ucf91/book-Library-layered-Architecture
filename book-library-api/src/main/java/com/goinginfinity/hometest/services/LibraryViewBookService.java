package com.goinginfinity.hometest.services;

import com.goinginfinity.hometest.common.dtos.Book;

public interface LibraryViewBookService extends Service {
    public int showBookDetails(Book book);
}
