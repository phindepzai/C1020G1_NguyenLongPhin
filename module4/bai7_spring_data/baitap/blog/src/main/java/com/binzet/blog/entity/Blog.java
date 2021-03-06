package com.binzet.blog.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String subtitle;
    @Column(name = "content",columnDefinition = "TEXT")
    private String content;
    private String author;
    @Column(columnDefinition = "DATE")
    private String date;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "category",referencedColumnName = "id")
    private Category category;
}
