package com.tryputs.backend.mapper;

import com.tryputs.backend.dto.BookDto;
import com.tryputs.backend.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMapper extends AbstractMapper<Book, BookDto> {

    @Autowired
    public BookMapper() {
        super(Book.class, BookDto.class);
    }
}
