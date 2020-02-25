package com.tryputs.backend.search;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class BookSearchRequest extends PageableSearchRequest {

    private String title;
    private Long pagesFrom;
    private Long pagesTo;
    private Year yearFrom;
    private Year yearTo;
    private List<GenreSearchRequest> genres = new ArrayList<>();
    private List<AuthorSearchRequest> authors = new ArrayList<>();
}


