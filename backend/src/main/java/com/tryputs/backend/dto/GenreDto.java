package com.tryputs.backend.dto;

import com.tryputs.backend.entity.Book;
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
public class GenreDto extends AbstractDto {

    private String name;
    private List<Long> booksId = new ArrayList<>();
}
