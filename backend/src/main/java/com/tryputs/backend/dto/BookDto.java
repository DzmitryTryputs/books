package com.tryputs.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto extends AbstractDto {

    private String title;
    private Long pages;
    private List<GenreDto> genres = new ArrayList<>();
    private List<AuthorDto> authors = new ArrayList<>();
}
