package com.tryputs.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "books")
@EqualsAndHashCode(callSuper = true)
public class Book extends IdentifiableEntity {

    @Column(name = "TITLE", nullable = false, unique = true)
    private String title;

    @Column(name = "PAGES")
    private Long pages;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "BOOKS_GENRES", joinColumns = {@JoinColumn(name = "BOOK_ID")},
        inverseJoinColumns = {@JoinColumn(name = "GENRE_ID")})
    private List<Genre> genres = new ArrayList<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "BOOKS_AUTHORS", joinColumns = {@JoinColumn(name = "BOOK_ID")},
        inverseJoinColumns = {@JoinColumn(name = "AUTHOR_ID")})
    private List<Author> authors = new ArrayList<>();
}
