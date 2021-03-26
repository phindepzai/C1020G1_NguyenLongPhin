package com.binzet.service.impl;

import com.binzet.concern.Logger;
import com.binzet.entity.Book;
import com.binzet.entity.BookingCode;
import com.binzet.repository.BookRepository;
import com.binzet.service.BookService;
import com.binzet.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookingService bookingService;

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public String giveBookBack(String code,int id) {
        String message;
        BookingCode bookingCode = bookingService.findByCode(code);
        Book b = bookRepository.findById(id).orElse(null);
        if (isaBoolean(id, bookingCode)){
            message = "ok";
            bookingCode.setStatus("ok");
            bookingService.save(bookingCode);
            b.setAmount(b.getAmount()+1);
            save(b);
            Logger.bookName = b.getName();
        } else {
            message = "ng";
            Logger.bookName = b.getName() + " fail because code incorrect!";
        }
        return message;
    }

    public boolean isaBoolean(int id, BookingCode bookingCode) {
        return bookingCode != null && bookingCode.getBook().getId() == id;
    }

    @Override
    public String rentBook(int id) {
        String message;
        Book book = bookRepository.findById(id).orElse(null);
        BookingCode bookingCode = new BookingCode();
        if (book != null && book.getAmount() > 0){
            bookingCode.setCode(getRandom());
            bookingCode.setBook(book);
            bookingCode.setStatus("ng");
            bookingService.save(bookingCode);
            message = bookingCode.getCode();
            book.setAmount(book.getAmount()-1);
            save(book);
            Logger.bookName = book.getName();
        } else {
            message = "ng";
            Logger.bookName = book.getName() + " because amount book = 0";
        }
        return message;
    }

    public String getRandom() {
        Random random = new Random();
        int num = random.nextInt(90000) + 10000;
        return String.valueOf(num);
    }
}
