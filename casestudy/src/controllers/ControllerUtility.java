package controllers;

import commons.Constant;
import models.*;

import java.io.*;
import java.util.*;

public class ControllerUtility {

    private ArrayList<Object> readServicesFromFile(String filePath) {
        ArrayList<Object> list = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader(getFile(filePath, true)));
            String[] data;
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                data = line.split(",");
                if (filePath.equals(Constant.VILLA_PATH)) {
                    list.add(getVillaFromData(data));
                } else if (filePath.equals(Constant.HOUSE_PATH)) {
                    list.add(getHouseFromData(data));
                } else {
                    list.add(getRoomFromData(data));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Villa> readVillasFromFile() {
        ArrayList<Object> list = readServicesFromFile(Constant.VILLA_PATH);
        ArrayList<Villa> villaArrayList = new ArrayList<>();
        for (Object o : list) {
            if (o instanceof Villa) {
                villaArrayList.add(((Villa) o));
            }
        }
        return villaArrayList;
    }

    public ArrayList<House> readHousesFromFile() {
        ArrayList<Object> list = readServicesFromFile(Constant.HOUSE_PATH);
        ArrayList<House> houseArrayList = new ArrayList<>();
        for (Object o : list) {
            if (o instanceof House) {
                houseArrayList.add(((House) o));
            }
        }
        return houseArrayList;
    }

    public ArrayList<Room> readRoomsFromFile() {
        ArrayList<Object> list = readServicesFromFile(Constant.ROOM_PATH);
        ArrayList<Room> roomArrayList = new ArrayList<>();
        for (Object o : list) {
            if (o instanceof Room) {
                roomArrayList.add(((Room) o));
            }
        }
        return roomArrayList;
    }

    public ArrayList<Customer> readCustomerFromFile() {
        ArrayList<Customer> list = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(getFile(Constant.CUSTOMER_PATH, true)));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                Customer customer = getCustomerFromData(line);
                list.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Customer getCustomerFromData(String line) {
        String data[] = line.split(",");
        return new Customer(data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8] , Integer.parseInt(data[9]));
    }

    public void writeDataFromCustomer(Customer customer, boolean isAdd) {
        try {
            FileWriter fileWriter = new FileWriter(getFile(Constant.CUSTOMER_PATH, false), isAdd);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String data = getDataFromCustomer(customer, isAdd);
            bufferedWriter.write(data + "\n");
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getDataFromCustomer(Customer customer, boolean isAdd) {
        int index = getCount(Constant.CUSTOMER_PATH) + 1;
        if (!isAdd) {
            for (int j = 0; j < getCustomerList().size(); j++) {
                if (getCustomerList().get(j).getIdentityNumber().equals(customer.getIdentityNumber())) {
                    index = j + 1;
                }
            }
        }
        return index + "," + customer.getName() + "," + customer.getBirthDay()
                + "," + customer.getGender() + "," + customer.getIdentityNumber() + "," + customer.getPhoneNumber()
                + "," + customer.getEmail() + "," + customer.getType() + "," + customer.getAddress()
                + "," + customer.getPayment();
    }

    public void writeNull(){
        try {
            FileWriter fileWriter = new FileWriter(getFile(Constant.CUSTOMER_PATH, false), false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("");
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Employee> readEmployeeFromData() {
        ArrayList<Employee> list = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(getFile(Constant.EMPLOYEE_PATH, true)));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                Employee employee = getEmployeeFromData(line);
                list.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Employee getEmployeeFromData(String line) {
        String[] data = line.split(",");
        return new Employee(data[1], data[2], data[3], data[4], data[5], data[6], data[7], Integer.parseInt(data[8]));
    }

    public void writeDataFromEmployee(Employee employee, boolean isAdd) {
        try {
            FileWriter fileWriter = new FileWriter(getFile(Constant.EMPLOYEE_PATH, false), isAdd);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String data = getDataFromEmployee(employee, isAdd);
            bufferedWriter.write(data + "\n");
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String getDataFromEmployee(Employee employee, boolean isAdd) {
        int index = getCount(Constant.EMPLOYEE_PATH) + 1;
        if (!isAdd) {
            for (int j = 0; j < getEmployeeMap().size(); j++) {
                if (getEmployeeMap().get(j).getIdentityNumber().equals(employee.getIdentityNumber())) {
                    index = j + 1;
                }
            }
        }
        return index + "," + employee.getName() + "," + employee.getBirthDay() + ","
                + employee.getIdentityNumber() + "," + employee.getPhoneNumber() + "," + employee.getEmail() + ","
                + employee.getLevel() + "," + employee.getPosition() + "," + employee.getSalary();
    }

    public File getFile(String filePath, boolean isRead) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    if (isRead) {
                        System.out.println(Constant.NOTHING_TO_SHOW);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    private void writeDataFromService(String filePath, String data, boolean isAdd) {
        try {
            FileWriter fileWriter = new FileWriter(getFile(filePath, false), isAdd);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data + "\n");
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeDataFromVilla(Villa villa, boolean isAdd) {
        int index = getCount(Constant.VILLA_PATH) + 1;
        if (!isAdd) {
            for (int j = 0; j < getVillaList().size(); j++) {
                if (getVillaList().get(j).getId().equals(villa.getId())) {
                    index = j + 1;
                }
            }
        }
        String data = index + "," + villa.getName() + "," + villa.getId() + "," +
                villa.getArea() + "," + villa.getCost() + "," + villa.getQuantityMax() + "," + villa.getRentType() +
                "," + villa.getStandard() + "," + villa.getConvenientDescription() + "," + villa.getAreaPool() + ","
                + villa.getNumOfFloor();
        writeDataFromService(Constant.VILLA_PATH, data, isAdd);
    }

    public void writeDataFromHouse(House house, boolean isAdd) {
        int index = getCount(Constant.HOUSE_PATH) + 1;
        if (!isAdd) {
            for (int j = 0; j < getHouseList().size(); j++) {
                if (getHouseList().get(j).getId().equals(house.getId())) {
                    index = j + 1;
                }
            }
        }
        String data = index + "," + house.getName() + "," + house.getId() + "," +
                house.getArea() + "," + house.getCost() + "," + house.getQuantityMax() + "," + house.getRentType() +
                "," + house.getStandard() + "," + house.getConvenientDescription() + "," + house.getNumOfFloor();
        writeDataFromService(Constant.HOUSE_PATH, data, isAdd);
    }

    public void writeDataFromRoom(Room room, boolean isAdd) {
        int index = getCount(Constant.HOUSE_PATH) + 1;
        if (!isAdd) {
            for (int j = 0; j < getRoomList().size(); j++) {
                if (getRoomList().get(j).getId().equals(room.getId())) {
                    index = j + 1;
                }
            }
        }
        String data = index + "," + room.getName() + "," + room.getId() + "," +
                room.getArea() + "," + room.getCost() + "," + room.getQuantityMax() + "," + room.getRentType();
        writeDataFromService(Constant.ROOM_PATH, data, isAdd);
    }

    public ArrayList<String> readBookingStringFromData() {
        ArrayList<String> list = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(getFile(Constant.BOOKING_PATH, true)));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void writeDataFromBooking(Booking booking, boolean isAdd) {
        try {
            FileWriter fileWriter = new FileWriter(getFile(Constant.BOOKING_PATH, false), isAdd);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String data = getDataFromBooking(booking, isAdd);
            bufferedWriter.write(data + "\n");
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getDataFromBooking(Booking booking, boolean isAdd) {
        int index = getCount(Constant.BOOKING_PATH) + 1;
        if (!isAdd) {
            for (int i = 0; i < getStringBookingList().size(); i++) {
                if (booking.equals(getCustomerListFromBooking().get(i).getBooking())) {
                    index = i + 1;
                }
            }
        }
        return index + "," + booking.getNameCustomer() + "," + booking.getIdCustomer() + ","
                + booking.getNameService() + "," + booking.getIdService() + "," + booking.getDateEnd();
    }

    private ArrayList<Customer> getCustomerListFromBooking() {
        ArrayList<Customer> list = new ArrayList<>();
        for (int i = 0; i < getStringBookingList().size(); i++) {
            String[] arr = getStringBookingList().get(i).split(",");
            String identity = arr[0];
            for (Customer customer : getCustomerList()) {
                if (customer.getIdentityNumber().equals(identity)) {
                    list.add(customer);
                }
            }
        }
        return list;
    }

    private ArrayList<Booking> getBookingListFromData() {
        ArrayList<Booking> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(getFile(Constant.BOOKING_PATH, true));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Booking booking = getBookingFromData(line);
                list.add(booking);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Booking getBookingFromData(String line) {
        String[] data = line.split(",");
        Booking booking = new Booking(data[1], data[2], data[3], data[4]);
        booking.setDateEnd(data[5]);
        return booking;
    }

    private int getCount(String filePath) {
        int count = 0;
        int temp = 0;
        try {
            Scanner scanner = new Scanner(getFile(filePath, true));
            String line = null;
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    private Room getRoomFromData(String[] data) {
        return new Room(data[1], data[2], Double.parseDouble(data[3]), Integer.parseInt(data[4]),
                Integer.parseInt(data[5]), data[6]);
    }

    private House getHouseFromData(String[] data) {
        return new House(data[1], data[2], Double.parseDouble(data[3]), Integer.parseInt(data[4]),
                Integer.parseInt(data[5]), data[6],
                data[7], data[8], Integer.parseInt(data[9]));
    }

    private Villa getVillaFromData(String[] data) {
        return new Villa(data[1], data[2], Double.parseDouble(data[3]), Integer.parseInt(data[4]),
                Integer.parseInt(data[5]), data[6],
                data[7], data[8], Double.parseDouble(data[9]), Integer.parseInt(data[10]));
    }

    public List<Villa> getVillaList() {
        return readVillasFromFile();
    }

    public List<House> getHouseList() {
        return readHousesFromFile();
    }

    public List<Room> getRoomList() {
        return readRoomsFromFile();
    }

    public List<Customer> getCustomerList() {
        return readCustomerFromFile();
    }

    public Map<String,Employee> getEmployeeMap() {
        Map<String,Employee> employeeMap = new HashMap<>();
        ArrayList<Employee> list = readEmployeeFromData();
        for (Employee employee : list) {
            employeeMap.put(employee.getIdentityNumber(), employee);
        }
        return employeeMap;
    }

    public List<String> getStringBookingList() {
        return readBookingStringFromData();
    }

    public List<Booking> getBookingList(){
        return getBookingListFromData();
    }
}
