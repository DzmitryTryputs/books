package com.tryputs.backend.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class BookDto extends AbstractDto {

    private final String title;
    private final Long pages;
    private final List<GenreDto> genres = new ArrayList<>();
    private final List<AuthorDto> authors = new ArrayList<>();
}
