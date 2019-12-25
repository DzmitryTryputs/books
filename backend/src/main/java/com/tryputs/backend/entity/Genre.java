package com.tryputs.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "GENRES")
@EqualsAndHashCode(callSuper = true)
public class Genre extends IdentifiableEntity {

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "genres", fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();
}
