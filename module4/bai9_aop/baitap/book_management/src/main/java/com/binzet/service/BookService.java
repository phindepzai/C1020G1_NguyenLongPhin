package com.binzet.service;

import com.binzet.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    void save(Book book);
    void delete(int id);
    Page<Book> findAll(Pageable pageable);
    Book findById(int id);
    String giveBookBack(String code,int id);
    String rentBook(int id);
}
