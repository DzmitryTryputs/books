package com.tryputs.backend.service;

import com.querydsl.core.types.Predicate;
import com.tryputs.backend.dto.BookDto;
import com.tryputs.backend.entity.Book;
import com.tryputs.backend.mapper.BookMapper;
import com.tryputs.backend.predicate.BookSearchPredicateFactory;
import com.tryputs.backend.repository.BookRepository;
import com.tryputs.backend.search.BookSearchRequest;
import com.tryputs.backend.search.OffsetLimitRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookService {

    private BookRepository bookRepository;
    private BookMapper bookMapper;
    private BookSearchPredicateFactory bookSearchFactory;

    @Transactional
    public List<BookDto> getAll() {
        return  bookRepository.findAll().stream().map(bookMapper::toDto).collect(Collectors.toList());
    }

    public BookDto add(BookDto book) {
        return bookMapper.toDto(bookRepository.save(bookMapper.toEntity(book)));
    }

    @Transactional
    public List<BookDto> search(final BookSearchRequest searchRequest) {
        final Page<Book> page = searchDbo(searchRequest);

        return page.getContent().stream().map(book -> bookMapper.toDto(book)).collect(Collectors.toList());
    }

    @Transactional
    public Page<Book> searchDbo(final BookSearchRequest searchRequest) {
        final OffsetLimitRequest offsetLimitRequest = new OffsetLimitRequest(searchRequest);
        final Optional<Predicate> optionalPredicate = bookSearchFactory.build(searchRequest);

        return optionalPredicate
            .map(predicate -> bookRepository.findAll(predicate, offsetLimitRequest))
            .orElseGet(() -> bookRepository.findAll(offsetLimitRequest));
    }

}
