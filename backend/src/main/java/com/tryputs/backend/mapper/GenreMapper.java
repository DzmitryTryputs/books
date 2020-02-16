package com.tryputs.backend.mapper;

import com.tryputs.backend.dto.GenreDto;
import com.tryputs.backend.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper extends AbstractMapper<Genre, GenreDto> {

    @Autowired
    public GenreMapper() {
        super(Genre.class, GenreDto.class);
    }
}
