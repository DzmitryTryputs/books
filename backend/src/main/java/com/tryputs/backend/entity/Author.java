package com.tryputs.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "AUTHORS")
@EqualsAndHashCode(callSuper = true)
public class Author extends IdentifiableEntity {

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "DATE_OF_BIRTH")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();
}

