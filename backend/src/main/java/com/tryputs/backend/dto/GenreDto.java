package com.tryputs.backend.dto;

import com.tryputs.backend.entity.Book;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class GenreDto extends AbstractDto {

    private final String name;
    private final List<Book> books = new ArrayList<>();
}
