package com.tryputs.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
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

    @ToString.Exclude
    @ManyToMany(mappedBy = "authors")
    private List<Book> books = new ArrayList<>();
}

