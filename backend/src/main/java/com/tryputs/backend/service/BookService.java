package com.tryputs.backend.service;

import com.tryputs.backend.dto.BookDto;
import com.tryputs.backend.mapper.BookMapper;
import com.tryputs.backend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookService(final BookRepository bookRepository, final BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public List<BookDto> getAll() {
        return  bookRepository.findAll().stream().map(bookMapper::toDto).collect(Collectors.toList());
    }
}
