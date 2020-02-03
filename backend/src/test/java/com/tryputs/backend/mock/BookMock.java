package com.tryputs.backend.mock;

import com.tryputs.backend.entity.Book;

public class BookMock {

    public static Book getBookMock() {
        Book book = new Book();
        book.setTitle("Test Title");
        book.setYear(1984L);
        book.setPages(1000L);
        return book;
    }
}
