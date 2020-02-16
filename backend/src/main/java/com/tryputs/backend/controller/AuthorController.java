package com.tryputs.backend.controller;

import com.tryputs.backend.dto.AuthorDto;
import com.tryputs.backend.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/authors")
@RestController
@AllArgsConstructor
public class AuthorController {

    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAll() {
        return ResponseEntity.ok(authorService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<AuthorDto> add(@RequestBody AuthorDto author) {
        return ResponseEntity.ok(authorService.add(author));
    }
}