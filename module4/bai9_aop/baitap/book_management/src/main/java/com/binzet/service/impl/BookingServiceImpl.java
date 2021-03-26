package com.binzet.service.impl;

import com.binzet.entity.BookingCode;
import com.binzet.repository.BookingRepository;
import com.binzet.service.BookService;
import com.binzet.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;


    @Override
    public void save(BookingCode bookingCode) {
        bookingRepository.save(bookingCode);
    }

    @Override
    public BookingCode findByCode(String code) {
        return bookingRepository.findById(code).orElse(null);
    }
}
