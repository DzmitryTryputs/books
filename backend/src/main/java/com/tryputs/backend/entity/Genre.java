package com.tryputs.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "GENRES")
@EqualsAndHashCode(callSuper = true)
public class Genre extends IdentifiableEntity {

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @ToString.Exclude
    @ManyToMany(mappedBy = "genres")
    private List<Book> books = new ArrayList<>();
}
