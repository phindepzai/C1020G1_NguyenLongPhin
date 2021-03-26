package model.repository;

import model.bean.services.*;

import java.util.List;

public interface ServiceRepository {
    void saveVilla(Villa villa);
    void saveHouse(House house);
    void saveRoom(Room room);
    List<Villa> findAllVilla();
    List<House> findAllHouse();
    List<Room> findAllRoom();
    List<RentType> rentTypeList();
    List<ServiceType> serviceTypeList();
    RentType findRentType(int id);
    ServiceType findServiceType(int id);
}
