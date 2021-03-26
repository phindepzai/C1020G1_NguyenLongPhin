package com.binzet.repository;

import com.binzet.entity.BookingCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingCode,String> {
}
