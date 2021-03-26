package com.furama.validator;

import com.furama.annotation.ServicesExist;
import com.furama.entity.services.House;
import com.furama.entity.services.Room;
import com.furama.entity.services.Villa;
import com.furama.service.services.HouseService;
import com.furama.service.services.RoomService;
import com.furama.service.services.VillaService;
import com.furama.ulti.Check;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ServicesExistValidator implements ConstraintValidator<ServicesExist, String> {
    @Autowired
    private VillaService villaService;
    @Autowired
    private HouseService houseService;
    @Autowired
    private RoomService roomService;

    public void initialize(ServicesExist constraint) {
    }

    public boolean isValid(String obj, ConstraintValidatorContext context) {
//        if (Check.isCreate){
//            for (Villa villa:villaService.findAll()){
//                if (villa.getId().equals(obj)){
//                    return false;
//                }
//            }
//            for (House house:houseService.findAll()){
//                if (house.getId().equals(obj)){
//                    return false;
//                }
//            }
//            for (Room room :roomService.findAll()){
//                if (room.getId().equals(obj)){
//                    return false;
//                }
//            }
//        }
        return true;
    }
}
