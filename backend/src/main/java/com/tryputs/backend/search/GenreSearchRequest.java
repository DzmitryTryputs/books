package com.tryputs.backend.search;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class GenreSearchRequest extends PageableSearchRequest {

    private String name;
    private List<BookSearchRequest> books = new ArrayList<>();
}
