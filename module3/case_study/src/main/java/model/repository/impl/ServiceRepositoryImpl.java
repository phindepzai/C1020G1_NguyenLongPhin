package model.repository.impl;

import model.bean.services.*;
import model.repository.ServiceRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements ServiceRepository {
    public static final String SQL_SAVE_SERVICE = "insert into service(service_name,service_area,service_cost," +
            "service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors) values(?,?,?,?,?,?,?,?,?,?)";
    public static final String SQL_FIND_ALL_SERVICE = "select * from service where service_type_id = ?";
    public static final String SQL_FIND_RENT_TYPE = "select * from rent_type where rent_type_id = ?";
    public static final String FIND_SERVICE_TYPE = "select * from service_type where service_type_id = ?";
    public static final String SQL_FIND_ALL_RENT_TYPE = "select * from rent_type";
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public void saveVilla(Villa villa) {
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SQL_SAVE_SERVICE);
            preparedStatement.setString(1, villa.getName());
            preparedStatement.setString(2, String.valueOf(villa.getArea()));
            preparedStatement.setString(3, String.valueOf(villa.getCost()));
            preparedStatement.setString(4, String.valueOf(villa.getQuantityMax()));
            preparedStatement.setString(5, String.valueOf(villa.getRentType().getId()));
            preparedStatement.setString(6, "1");
            preparedStatement.setString(7, villa.getStandardRoom());
            preparedStatement.setString(8, villa.getDescriptionOtherConvenience());
            preparedStatement.setString(9, String.valueOf(villa.getPoolArea()));
            preparedStatement.setString(10, String.valueOf(villa.getNumOfFloor()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveHouse(House house) {
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SQL_SAVE_SERVICE);
            preparedStatement.setString(1, house.getName());
            preparedStatement.setString(2, String.valueOf(house.getArea()));
            preparedStatement.setString(3, String.valueOf(house.getCost()));
            preparedStatement.setString(4, String.valueOf(house.getQuantityMax()));
            preparedStatement.setString(5, String.valueOf(house.getRentType().getId()));
            preparedStatement.setString(6, "2");
            preparedStatement.setString(7, house.getStandardRoom());
            preparedStatement.setString(8, house.getDescriptionOtherConvenience());
            preparedStatement.setString(9, null);
            preparedStatement.setString(10, String.valueOf(house.getNumOfFloor()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveRoom(Room room) {
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SQL_SAVE_SERVICE);
            preparedStatement.setString(1, room.getName());
            preparedStatement.setString(2, String.valueOf(room.getArea()));
            preparedStatement.setString(3, String.valueOf(room.getCost()));
            preparedStatement.setString(4, String.valueOf(room.getQuantityMax()));
            preparedStatement.setString(5, String.valueOf(room.getRentType().getId()));
            preparedStatement.setString(6, "3");
            preparedStatement.setString(7, "null");
            preparedStatement.setString(8, "null");
            preparedStatement.setString(9, "null");
            preparedStatement.setString(10, "null");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Villa> findAllVilla() {
        List<Villa> list = new ArrayList<>();
//        service_name,service_area,service_cost," +
//        "service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SQL_FIND_ALL_SERVICE);
            preparedStatement.setString(1, "1");
            ResultSet resultSet = preparedStatement.executeQuery();
            Villa villa = null;
            while (resultSet.next()) {
                Integer id = Integer.parseInt(resultSet.getString("service_id"));
                String name = resultSet.getString("service_name");
                double area = Double.parseDouble(resultSet.getString("service_area"));
                int cost = Integer.parseInt(resultSet.getString("service_cost"));
                int maxPeople = Integer.parseInt(resultSet.getString("service_max_people"));
                int rentTyoe = Integer.parseInt(resultSet.getString("rent_type_id"));
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                double poolArea = Double.parseDouble(resultSet.getString("pool_area"));
                int numOfFloor = Integer.parseInt(resultSet.getString("number_of_floors"));
                villa = new Villa(id, name, area, cost, maxPeople,findServiceType(1), findRentType(rentTyoe), standardRoom, descriptionOtherConvenience, poolArea, numOfFloor);
                list.add(villa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public RentType findRentType(int id) {
        RentType rentType = null;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SQL_FIND_RENT_TYPE);
            preparedStatement.setString(1, String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                rentType = new RentType(id, resultSet.getString("rent_type_name"), Double.parseDouble(resultSet.getString("rent_type_cost")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentType;
    }

    public ServiceType findServiceType(int id) {
        ServiceType serviceType = null;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(FIND_SERVICE_TYPE);
            preparedStatement.setString(1, String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                serviceType = new ServiceType(id, resultSet.getString("service_type_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceType;
    }

    @Override
    public List<House> findAllHouse() {
        List<House> list = new ArrayList<>();
//        service_name,service_area,service_cost," +
//        "service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SQL_FIND_ALL_SERVICE);
            preparedStatement.setString(1, "2");
            ResultSet resultSet = preparedStatement.executeQuery();
            House house = null;
            while (resultSet.next()) {
                Integer id = Integer.parseInt(resultSet.getString("service_id"));
                String name = resultSet.getString("service_name");
                double area = Double.parseDouble(resultSet.getString("service_area"));
                int cost = Integer.parseInt(resultSet.getString("service_cost"));
                int maxPeople = Integer.parseInt(resultSet.getString("service_max_people"));
                int rentTyoe = Integer.parseInt(resultSet.getString("rent_type_id"));
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                int numOfFloor = Integer.parseInt(resultSet.getString("number_of_floors"));
                house = new House(id, name, area, cost, maxPeople,findServiceType(2), findRentType(rentTyoe), standardRoom, descriptionOtherConvenience, numOfFloor);
                list.add(house);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Room> findAllRoom() {
        List<Room> list = new ArrayList<>();
//        service_name,service_area,service_cost," +
//        "service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SQL_FIND_ALL_SERVICE);
            preparedStatement.setString(1, "3");
            ResultSet resultSet = preparedStatement.executeQuery();
            Room room = null;
            while (resultSet.next()) {
                Integer id = Integer.parseInt(resultSet.getString("service_id"));
                String name = resultSet.getString("service_name");
                double area = Double.parseDouble(resultSet.getString("service_area"));
                int cost = Integer.parseInt(resultSet.getString("service_cost"));
                int maxPeople = Integer.parseInt(resultSet.getString("service_max_people"));
                int rentTyoe = Integer.parseInt(resultSet.getString("rent_type_id"));
                room = new Room(id, name, area, cost, maxPeople,findServiceType(3), findRentType(rentTyoe));
                list.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<RentType> rentTypeList() {
        List<RentType> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SQL_FIND_ALL_RENT_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            RentType rentType = null;
            while (resultSet.next()){
                Integer id = Integer.parseInt(resultSet.getString("rent_type_id"));
                String name = resultSet.getString("rent_type_name");
                double cost = Double.parseDouble(resultSet.getString("rent_type_cost"));
                rentType = new RentType(id,name,cost);
                list.add(rentType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ServiceType> serviceTypeList() {
        List<ServiceType> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement("select * from service_type");
            ResultSet resultSet = preparedStatement.executeQuery();
            ServiceType serviceType = null;
            while (resultSet.next()){
                Integer id = Integer.parseInt(resultSet.getString("service_type_id"));
                String name = resultSet.getString("service_type_name");
                serviceType = new ServiceType(id,name);
                list.add(serviceType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
