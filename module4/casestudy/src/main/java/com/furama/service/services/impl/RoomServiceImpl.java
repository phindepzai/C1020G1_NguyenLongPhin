package com.furama.service.services.impl;

import com.furama.entity.services.Room;
import com.furama.entity.services.Villa;
import com.furama.repository.services.RoomRepository;
import com.furama.service.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Override
    public void save(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void delete(String id) {
        roomRepository.deleteById(id);
    }

    @Override
    public Page<Room> findAll(Pageable pageable) {
        return roomRepository.findAll(pageable);
    }

    @Override
    public Room findById(String id) {
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Room> findAllByKey(String key, Pageable pageable) {
        return roomRepository.findAllByNameIsContaining(key,pageable);
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }
}
