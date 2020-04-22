package com.tryputs.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto extends AbstractDto {

    @NotNull(message = "Title cannot be null")
    private String title;
    private Long pages;
    private Long year;
    private List<GenreDto> genres = new ArrayList<>();
    private List<AuthorDto> authors = new ArrayList<>();
}
