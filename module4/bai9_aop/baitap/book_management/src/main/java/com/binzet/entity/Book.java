package com.binzet.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer id;
    private String name;
    private int amount;
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<BookingCode> booking;
}
