package model.service;

import model.bean.services.*;

import java.util.List;

public interface ServiceService {
    void saveVilla(Villa villa);
    void saveHouse(House house);
    void saveRoom(Room room);
    List<Villa> findAllVilla(int page);
    List<House> findAllHouse(int page);
    List<Room> findAllRoom(int page);
    int sizeVillaList();
    int sizeHouseList();
    int sizeRoomList();
    List<ServiceType> serviceTypeList();
    List<RentType> rentTypeList();
    RentType findRentType(int id);
    ServiceType findServiceType(int id);
}
