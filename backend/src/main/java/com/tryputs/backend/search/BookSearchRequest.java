package com.tryputs.backend.search;

import com.tryputs.backend.dto.AuthorDto;
import com.tryputs.backend.dto.GenreDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class BookSearchRequest extends PageableSearchRequest {

    private String title;
    private Long pagesFrom;
    private Long pagesTo;
    private Long yearFrom;
    private Long yearTo;
    private List<GenreDto> genres = new ArrayList<>();
    private List<AuthorDto> authors = new ArrayList<>();
}


