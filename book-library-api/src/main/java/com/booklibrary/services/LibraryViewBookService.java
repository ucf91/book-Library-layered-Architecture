package com.booklibrary.services;

import com.booklibrary.common.dtos.Book;

public interface LibraryViewBookService extends Service {
    public int showBookDetails(Book book);
}
