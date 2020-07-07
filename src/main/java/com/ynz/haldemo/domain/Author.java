package com.ynz.haldemo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Author {
    @Id
    @GeneratedValue
    private UUID id;

    private String firstName;
    private String lastName;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Author_Book",
            joinColumns = @JoinColumn(name = "Author_Id"),
            inverseJoinColumns = @JoinColumn(name = "Book_Id")
    )
    private Set<Book> books = new HashSet<>();



}
