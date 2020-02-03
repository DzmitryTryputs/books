package com.tryputs.backend.mapper;

import com.tryputs.backend.AbstractSpringMvcTest;
import com.tryputs.backend.dto.BookDto;
import com.tryputs.backend.entity.Author;
import com.tryputs.backend.entity.Book;
import com.tryputs.backend.mock.AuthorMock;
import com.tryputs.backend.mock.BookMock;
import org.junit.jupiter.api.Test;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import static org.modelmapper.internal.util.Assert.isTrue;

public class BookMapperTest extends AbstractSpringMvcTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void mapDboToDto() {
        final Book book = BookMock.getBookMock();
        final BookDto bookDto = bookMapper.toDto(book);
        isTrue(book.getTitle().equals(bookDto.getTitle()));
    }

    @Test
    public void mapDboToDtoWithNestedEntity() {
        final Book book = BookMock.getBookMock();
        final Author author = AuthorMock.getAuthorMock();
        book.getAuthors().add(author);
        final BookDto bookDto = bookMapper.toDto(book);
        isTrue(author.getFirstName().equals(bookDto.getAuthors().get(0).getFirstName()));
    }
}
