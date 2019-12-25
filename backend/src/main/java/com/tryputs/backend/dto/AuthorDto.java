package com.tryputs.backend.dto;

import com.tryputs.backend.entity.Book;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class AuthorDto extends AbstractDto {

    private final String firstName;
    private final String lastName;
    private final LocalDate dob;
    private final List<Book> books = new ArrayList<>();
}
