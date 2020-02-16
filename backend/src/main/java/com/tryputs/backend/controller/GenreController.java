package com.tryputs.backend.controller;

import com.tryputs.backend.dto.GenreDto;
import com.tryputs.backend.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/genres")
@RestController
@AllArgsConstructor
public class GenreController {

    private GenreService genreService;

    @GetMapping
    public ResponseEntity<List<GenreDto>> getAll() {
        return ResponseEntity.ok(genreService.getAll());
    }
}