package com.tryputs.backend.service;

import com.tryputs.backend.dto.GenreDto;
import com.tryputs.backend.mapper.GenreMapper;
import com.tryputs.backend.repository.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    public List<GenreDto> getAll() {
        return  genreRepository.findAll().stream().map(genreMapper::toDto).collect(Collectors.toList());
    }
}