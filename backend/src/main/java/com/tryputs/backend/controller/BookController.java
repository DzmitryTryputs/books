package com.tryputs.backend.controller;

import com.tryputs.backend.dto.BookDto;
import com.tryputs.backend.search.BookSearchRequest;
import com.tryputs.backend.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/books")
@RestController
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDto>> getAll() {
        return ResponseEntity.ok(bookService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<BookDto> add(@RequestBody BookDto book) {
        return ResponseEntity.ok(bookService.add(book));
    }

    @PostMapping("/search")
    public ResponseEntity<List<BookDto>> search(@RequestBody BookSearchRequest search) {
        return ResponseEntity.ok(bookService.search(search));
    }
}
