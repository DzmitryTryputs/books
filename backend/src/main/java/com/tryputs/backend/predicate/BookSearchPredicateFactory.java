package com.tryputs.backend.predicate;

import com.tryputs.backend.entity.QBook;
import com.tryputs.backend.mapper.GenreMapper;
import com.tryputs.backend.search.BookSearchRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookSearchPredicateFactory extends AbstractSearchRequestPredicateFactory<BookSearchRequest> {

    private GenreMapper genreMapper;

    @Override
    void buildPredicates(final BookSearchRequest searchRequest) {
        addRangeExpression(QBook.book.year, searchRequest.getYearFrom(), searchRequest.getYearTo());
        addRangeExpression(QBook.book.pages, searchRequest.getPagesFrom(), searchRequest.getPagesTo());
        addListExpression(QBook.book.genres, searchRequest.getGenres().stream().map(genre -> genreMapper.toEntity(genre)).collect(
            Collectors.toList()));
    }
}
