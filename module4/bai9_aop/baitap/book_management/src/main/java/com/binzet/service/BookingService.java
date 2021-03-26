package com.binzet.service;

import com.binzet.entity.BookingCode;

public interface BookingService {
    void save(BookingCode bookingCode);
    BookingCode findByCode(String code);
}
