package model.service.impl;

import model.bean.employee.Employee;
import model.bean.services.*;
import model.repository.ServiceRepository;
import model.repository.impl.ServiceRepositoryImpl;
import model.service.ServiceService;

import java.util.ArrayList;
import java.util.List;

public class ServiceServiceImpl implements ServiceService {
    ServiceRepository serviceRepository = new ServiceRepositoryImpl();

    @Override
    public void saveVilla(Villa villa) {
        serviceRepository.saveVilla(villa);
    }

    @Override
    public void saveHouse(House house) {
        serviceRepository.saveHouse(house);
    }

    @Override
    public void saveRoom(Room room) {
        serviceRepository.saveRoom(room);
    }

    @Override
    public List<Villa> findAllVilla(int page) {
        List<Villa> list = new ArrayList<>();
        int start = (page - 1) * 7;
        int end;
        List<Villa> listAll = serviceRepository.findAllVilla();
        if (page * 7 > listAll.size()) {
            end = listAll.size();
        } else {
            end = page * 7;
        }
        for (int i = start; i < end; i++) {
            list.add(listAll.get(i));
        }
        return list;
    }

    @Override
    public List<House> findAllHouse(int page) {
        List<House> list = new ArrayList<>();
        int start = (page - 1) * 7;
        int end;
        List<House> listAll = serviceRepository.findAllHouse();
        if (page * 7 > listAll.size()) {
            end = listAll.size();
        } else {
            end = page * 7;
        }
        for (int i = start; i < end; i++) {
            list.add(listAll.get(i));
        }
        return list;
    }

    @Override
    public List<Room> findAllRoom(int page) {
        List<Room> list = new ArrayList<>();
        int start = (page - 1) * 7;
        int end;
        List<Room> listAll = serviceRepository.findAllRoom();
        if (page * 7 > listAll.size()) {
            end = listAll.size();
        } else {
            end = page * 7;
        }
        for (int i = start; i < end; i++) {
            list.add(listAll.get(i));
        }
        return list;
    }

    @Override
    public int sizeVillaList() {
        return serviceRepository.findAllVilla().size();
    }

    @Override
    public int sizeHouseList() {
        return serviceRepository.findAllHouse().size();
    }

    @Override
    public int sizeRoomList() {
        return serviceRepository.findAllRoom().size();
    }

    @Override
    public List<ServiceType> serviceTypeList() {
        return serviceRepository.serviceTypeList();
    }

    @Override
    public List<RentType> rentTypeList() {
        return serviceRepository.rentTypeList();
    }

    @Override
    public RentType findRentType(int id) {
        return serviceRepository.findRentType(id);
    }

    @Override
    public ServiceType findServiceType(int id) {
        return serviceRepository.findServiceType(id);
    }
}
