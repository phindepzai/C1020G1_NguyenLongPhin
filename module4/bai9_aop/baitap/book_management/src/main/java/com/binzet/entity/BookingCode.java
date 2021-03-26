package com.binzet.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class BookingCode {
    @Id
    private String code;
    private String status;
    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "book_id")
    private Book book;
}
