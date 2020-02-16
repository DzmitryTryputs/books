package com.tryputs.backend.service;

import com.tryputs.backend.dto.AuthorDto;
import com.tryputs.backend.mapper.AuthorMapper;
import com.tryputs.backend.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthorService {

    private AuthorRepository authorRepository;
    private AuthorMapper authorMapper;

    public List<AuthorDto> getAll() {
        return authorRepository.findAll().stream().map(authorMapper::toDto).collect(Collectors.toList());
    }

    public AuthorDto add(AuthorDto author) {
        return authorMapper.toDto(authorRepository.save(authorMapper.toEntity(author)));
    }
}


