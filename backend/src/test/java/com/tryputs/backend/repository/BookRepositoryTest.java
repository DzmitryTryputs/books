package com.tryputs.backend.repository;

import com.tryputs.backend.AbstractSpringMvcTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class BookRepositoryTest extends AbstractSpringMvcTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void findAny() {
        Assert.notEmpty(bookRepository.findAll(), "Repository is Empty");
    }
}