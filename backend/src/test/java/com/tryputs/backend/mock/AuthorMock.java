package com.tryputs.backend.mock;

import com.tryputs.backend.entity.Author;

public class AuthorMock {

    public static Author getAuthorMock() {
        Author author = new Author();
        author.setFirstName("First Name");
        author.setLastName("Last Name");
        return author;
    }
}
