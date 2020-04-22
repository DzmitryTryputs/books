package com.tryputs.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto extends AbstractDto {

    private String firstName;
    private String lastName;
    private LocalDate dob;
    private List<BookDto> books = new ArrayList<>();
}
