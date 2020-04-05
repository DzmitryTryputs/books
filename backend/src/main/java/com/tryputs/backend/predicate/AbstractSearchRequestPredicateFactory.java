package com.tryputs.backend.predicate;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.DatePath;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.ListPath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.core.types.dsl.StringPath;
import com.tryputs.backend.search.PageableSearchRequest;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

public abstract class AbstractSearchRequestPredicateFactory<T extends PageableSearchRequest> {

    private BooleanBuilder booleanBuilder;

    public Optional<Predicate> build(T searchRequest) {
        booleanBuilder = new BooleanBuilder();
        buildPredicates(searchRequest);
        return Optional.ofNullable(booleanBuilder.getValue());
    }

    abstract void buildPredicates(final T searchRequest);

    void addExpression(final StringPath field, final String value) {
        if (StringUtils.isNotEmpty(value)) {
            booleanBuilder.and(field.containsIgnoreCase(value));
        }
    }

    <E extends Enum<E>> void addExpression(final EnumPath<E> field, final E value) {
        if (value != null) {
            booleanBuilder.and(field.eq(value));
        }
    }

    void addExpression(final NumberPath<Long> field, final Long value) {
        if (value != null) {
            booleanBuilder.and(field.eq(value));
        }
    }

    void addDateExpression(final DatePath<LocalDate> date, final LocalDate from, final LocalDate to) {
        if (from != null) {
            booleanBuilder.and(date.after(from.minusDays(1)));
        }
        if (to != null) {
            booleanBuilder.and(date.before(to.plusDays(1)));
        }
    }

    void addDateTimeExpression(final DateTimePath<LocalDateTime> date,
                               final LocalDateTime from,
                               final LocalDateTime to) {
        if (from != null) {
            booleanBuilder.and(date.after(from.minusSeconds(1)));
        }
        if (to != null) {
            booleanBuilder.and(date.before(to.plusSeconds(1)));
        }
    }

    void addRangeExpression(final NumberPath<Long> field, final Long from, final Long to) {
        if (from != null && to != null) {
            booleanBuilder.and(field.between(from, to));
        }
    }

    <E, Q extends SimpleExpression<? super E>> void addListExpression(final ListPath<E, Q> qBusinessTypes,
                                                                      final Collection<E> businessTypes) {
        if (!CollectionUtils.isEmpty(businessTypes)) {
            booleanBuilder.and(qBusinessTypes.any().in(businessTypes));
        }
    }
}
