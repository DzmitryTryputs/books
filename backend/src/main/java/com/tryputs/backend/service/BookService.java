package com.tryputs.backend.service;

import com.tryputs.backend.dto.BookDto;
import com.tryputs.backend.mapper.BookMapper;
import com.tryputs.backend.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookService {

    private BookRepository bookRepository;
    private BookMapper bookMapper;

    public List<BookDto> getAll() {
        return  bookRepository.findAll().stream().map(bookMapper::toDto).collect(Collectors.toList());
    }

    public BookDto add(BookDto book) {
        return bookMapper.toDto(bookRepository.save(bookMapper.toEntity(book)));
    }
}
