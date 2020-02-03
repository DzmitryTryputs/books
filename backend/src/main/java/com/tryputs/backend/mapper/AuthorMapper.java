package com.tryputs.backend.mapper;

import com.tryputs.backend.dto.AuthorDto;
import com.tryputs.backend.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper extends AbstractMapper<Author, AuthorDto> {

    @Autowired
    public AuthorMapper() {
        super(Author.class, AuthorDto.class);
    }
}
