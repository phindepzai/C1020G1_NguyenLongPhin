package com.binzet.blog.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String subtitle;
    private String author;
    @Column(name = "date",columnDefinition = "DATE")
    private String date;
    private String content;

    @ManyToOne
    @JoinColumn( name = "category", referencedColumnName = "id")
    private Category category;


}