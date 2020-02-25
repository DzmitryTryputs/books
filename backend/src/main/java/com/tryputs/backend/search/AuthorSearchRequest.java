package com.tryputs.backend.search;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class AuthorSearchRequest extends PageableSearchRequest {

    private String firstName;
    private String lastName;
    private LocalDate dobFrom;
    private LocalDate dobTo;

    private List<BookSearchRequest> books = new ArrayList<>();
}
