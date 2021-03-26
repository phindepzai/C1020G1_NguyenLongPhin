package com.furama.controller;

import com.furama.entity.services.House;
import com.furama.entity.services.Room;
import com.furama.entity.services.Villa;
import com.furama.service.services.HouseService;
import com.furama.service.services.RoomService;
import com.furama.service.services.VillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/services")
@CrossOrigin("*")
public class ServicesRestController {
    @Autowired
    private VillaService villaService;
    @Autowired
    private HouseService houseService;
    @Autowired
    private RoomService roomService;

    @GetMapping("/villas/search")
    public ResponseEntity<Page<Villa>> searchVilla(@PageableDefault(size = 5) Pageable pageable,@RequestParam(required = false) String key) {
        if (key == null){
            key = "";
        }
        pageable = pageable.previousOrFirst();
        if (key.equals("")) {
            return new ResponseEntity<Page<Villa>>(villaService.findAll(pageable), HttpStatus.OK);
        }
        return new ResponseEntity<Page<Villa>>(villaService.findAllByKey(key, pageable), HttpStatus.OK);
    }

    @GetMapping("/houses/search")
    public ResponseEntity<Page<House>> searchHouse(@PageableDefault(size = 5) Pageable pageable,@RequestParam(required = false) String key) {
        pageable = pageable.previousOrFirst();
        if (key == null){
            key = "";
        }
        if (key.equals("")) {
            return new ResponseEntity<Page<House>>(houseService.findAll(pageable), HttpStatus.OK);
        }
        return new ResponseEntity<Page<House>>(houseService.findAllByKey(key, pageable), HttpStatus.OK);
    }

    @GetMapping("/rooms/search")
    public ResponseEntity<Page<Room>> searchRoom(@PageableDefault(size = 5) Pageable pageable,@RequestParam(required = false) String key) {
        pageable = pageable.previousOrFirst();
        if (key == null){
            key = "";
        }
        if (key.equals("")) {
            return new ResponseEntity<Page<Room>>(roomService.findAll(pageable), HttpStatus.OK);
        }
        return new ResponseEntity<Page<Room>>(roomService.findAllByKey(key, pageable), HttpStatus.OK);
    }
}
