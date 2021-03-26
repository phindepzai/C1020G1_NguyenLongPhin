package com.furama.service.services;

import com.furama.entity.services.Room;
import com.furama.entity.services.Villa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoomService {
    void save(Room room);
    void delete(String id);
    Page<Room> findAll(Pageable pageable);
    Room findById(String id);
    Page<Room> findAllByKey(String key, Pageable pageable);
    List<Room> findAll();
}
