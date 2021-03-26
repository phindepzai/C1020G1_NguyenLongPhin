package commons;

import manager.ManagerCustomers;
import manager.ManagerEmployee;
import manager.ManagerService;
import models.House;
import models.Room;
import models.Services;
import models.Villa;

import java.text.Normalizer;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegularExpression {

    public static String covertToString(String value) {
        try {
            String temp = Normalizer.normalize(value, Normalizer.Form.NFD);
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            return pattern.matcher(temp).replaceAll("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static boolean checkNameService(String name) {
        String regexNameService = "[A-Z][[a-z] _]+";
        return name.matches(regexNameService);
    }

    public static boolean checkId(String id,String type) {
        ManagerService managerService = new ManagerService();
        String alreadyExist = "ID Already Exist!";
        String regexId = "";
        if (type.equals(Constant.VILLA)){
            regexId = "(SVVL-)[0-9]{4}";
            List<Villa> villaList = managerService.getVillaList();
            for (Villa villa : villaList) {
                if (villa.getId().equals(id)) {
                    System.err.println(alreadyExist);
                    return false;
                }
            }
        } else if (type.equals(Constant.HOUSE)){
            regexId = "(SVHO-)[0-9]{4}";
            List<House> houseList = managerService.getHouseList();
            for (House house : houseList) {
                if (house.getId().equals(id)) {
                    System.err.println(alreadyExist);
                    return false;
                }
            }
        } else {
            regexId = "(SVRO-)[0-9]{4}";
            List<Room> roomList = managerService.getRoomList();
            for (Room room : roomList){
                if (room.getId().equals(id)){
                    System.err.println(alreadyExist);
                    return false;
                }
            }
        }
        return id.matches(regexId);
    }

    public static boolean checkName(String name) {
        String regexName = "([A-Z][a-z]+[ ]){2,}";
        return (covertToString(name) + " ").matches(regexName);
    }

    public static boolean checkArea(double area) {
        if (area < 30){
            System.out.println("Area >= 30");
            return false;
        }
        return true;
    }

    public static boolean checkQuantityMax(int quantityMax) {
        if (quantityMax > 0 && quantityMax < 20){
            return true;
        }
        System.out.println("Quantity Max > 0 and < 20");
        return false;
    }

    public static boolean checkFloor(int floor){
        return floor > 0;
    }

    public static boolean checkDate(String date){
        String regexDate = "([0-9]{2}[-/]){2}[0-9]{4}";
        if (!date.matches(regexDate)){
            return false;
        }
        if (date.length() != 10){
            return false;
        }
        int month = Integer.parseInt(date.substring(3,5));
        int day = Integer.parseInt(date.substring(0,2));
        int year = Integer.parseInt(date.substring(6,10));
        Date now = new Date();
        int yearNow = now.getYear() + 1900;
        if (yearNow - year == 18){
            if (month > now.getMonth() + 1){
                return false;
            } else if (month == now.getMonth() + 1){
                if (day > now.getDate()){
                    return false;
                }
            }
        } else if (yearNow - year < 18 || year < 1900){
            return false;
        }
        int dayMax;
        switch (month){
            case 2:
                dayMax = 28;
                if (isLeapYear(year)){
                    dayMax = 29;
                }
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dayMax = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                dayMax = 30;
                break;
            default:
                return false;
        }
        return day >= 1 && day <= dayMax;
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0){
            if (year % 100 == 0){
                return year % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean checkIdentity(String identity,String type){
        String regex = "(\\d{3}\\s){3}";
        if (type.equals("Cus")){
            if (checkDupCus(identity)) return false;
        } else {
            if (checkDupEm(identity)) return false;
        }
        if (!(identity+" ").matches(regex)){
            System.out.println("Identity Number Must Has 9 Number (XXX XXX XXX)!");
            return false;
        }
        return true;
    }

    private static boolean checkDupEm(String identity) {
        ManagerEmployee managerEmployee = new ManagerEmployee();
        for (int i = 0; i < managerEmployee.getEmployeeList().size(); i++) {
            if (managerEmployee.getEmployeeList().get(i).getIdentityNumber().equals(identity)){
                System.out.println("Duplicate Identity");
                return true;
            }
        }
        return false;
    }

    private static boolean checkDupCus(String identity) {
        ManagerCustomers managerCustomers = new ManagerCustomers();
        for (int i = 0; i < managerCustomers.getCustomerList().size(); i++) {
            if (managerCustomers.getCustomerList().get(i).getIdentityNumber().equals(identity)){
                System.out.println("Duplicate Identity");
                return true;
            }
        }
        return false;
    }

    public static boolean checkPhoneNumber(String phoneNumber){
        String regexPhone = "(\\+84|0)[0-9]{9}";
        return phoneNumber.matches(regexPhone);
    }

    public static boolean checkEmail(String email){
        String regexEmail = "^[a-zA-z]\\w{6,20}[@][a-zA-Z]{2,10}([.][a-zA-Z]{2,5}){1,2}";
        return email.matches(regexEmail);
    }

    public static boolean checkGender(String gender){
        if (gender.equals("Male") || gender.equals("Female") || gender.equals("Unknown")){
            return true;
        }
        System.out.println("Gender invalid!");
        return false;
    }

    public static int inputInt() {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            try {
                number = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("Please Enter a Number!");
            }
        } while (true);
        return number;
    }

    public static double inputDouble() {
        Scanner scanner = new Scanner(System.in);
        double number;
        do {
            try {
                number = Double.parseDouble(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("Please Enter a Number!");
            }
        } while (true);
        return number;
    }
}
