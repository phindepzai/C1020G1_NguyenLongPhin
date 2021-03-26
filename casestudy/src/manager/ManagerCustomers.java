package manager;

import controllers.ControllerUtility;
import sort.SortCustomerByName;
import commons.Constant;
import commons.RegularExpression;
import models.*;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ManagerCustomers {
    ControllerUtility controllerUtility = new ControllerUtility();
    Scanner scanner = new Scanner(System.in);

    public ManagerCustomers() {
    }

    public void addCustomer() {
        String name = getName();
        String birthday = getDateOfBirth();
        String gender = getGender();
        String identityNumber = getIdentity("Cus");
        String phoneNumber = getPhoneNumber();
        String email = getEmail();
        String type = getType();
        String address = getAddress();
        Customer newCustomer = new Customer(name, birthday, gender, identityNumber, phoneNumber, email, type, address,0);
        controllerUtility.writeDataFromCustomer(newCustomer, true);
        System.out.println("Add Customer Success!");
    }

    private String getAddress() {
        System.out.println("Enter Address : ");
        return scanner.nextLine();
    }

    private String getType() {
        String type = "";
        do {
            System.out.println("1." + Constant.DIAMOND);
            System.out.println("2." + Constant.PLATINUM);
            System.out.println("3." + Constant.GOLD);
            System.out.println("4." + Constant.SILVER);
            System.out.println("5." + Constant.MEMBER);
            System.out.println("Enter Type Customer : ");
            int choose = RegularExpression.inputInt();
            switch (choose) {
                case 1:
                    type = Constant.DIAMOND;
                    break;
                case 2:
                    type = Constant.PLATINUM;
                    break;
                case 3:
                    type = Constant.GOLD;
                    break;
                case 4:
                    type = Constant.SILVER;
                    break;
                case 5:
                    type = Constant.MEMBER;
                    break;
            }
        } while (type.equals(""));
        return type;
    }

    public String getEmail() {
        String email;
        do {
            System.out.println("Enter Email : ");
            email = scanner.nextLine();
        } while (!RegularExpression.checkEmail(email));
        return email;
    }

    public String getPhoneNumber() {
        String phoneNumber;
        do {
            System.out.println("Enter Phone Number ((+84|0)XXXXXXXXX) : ");
            phoneNumber = scanner.nextLine();
        } while (!RegularExpression.checkPhoneNumber(phoneNumber));
        return phoneNumber;
    }

    public String getIdentity(String type) {
        String identity;
        do {
            System.out.println("Enter Identity Number : ");
            identity = scanner.nextLine();
        } while (!RegularExpression.checkIdentity(identity,type));
        return identity;
    }

    public String getNewGender(String gender) {
        gender = gender.toLowerCase();
        String[] arr = gender.split("");
        arr[0] = arr[0].toUpperCase();
        StringBuilder genderBuilder = new StringBuilder("");
        for (String s : arr) {
            genderBuilder.append(s);
        }
        return genderBuilder.toString();
    }

    public String getGender() {
        String gender;
        do {
            System.out.println("Enter Gender : ");
            gender = scanner.nextLine();
            gender = getNewGender(gender);
        } while (!RegularExpression.checkGender(gender));
        return gender;
    }

    public String getDateOfBirth() {
        String dateOfBirth = "";
        do {
            System.out.println("Enter Birthday (dd/mm/yyyy) :");
            dateOfBirth = scanner.nextLine();
        } while (!RegularExpression.checkDate(dateOfBirth));
        return dateOfBirth;
    }

    public String getName() {
        String name;
        do {
            System.out.println("Enter Name Customer : ");
            name = scanner.nextLine();
        } while (!RegularExpression.checkName(name));
        return name;
    }

    public void callServiceExtend(int indexCustomer) {
        List<Customer> customerList = getCustomerList();
        boolean isBooking = true;
        int choose;
        do {
            System.out.println("1." + Constant.MASSAGE);
            System.out.println("2." + Constant.KARAOKE);
            System.out.println("3." + Constant.FOOD);
            System.out.println("4." + Constant.DRINKS);
            System.out.println("5." + Constant.CAR);
            System.out.println("6.Back To Menu");
            System.out.println("Enter Service You Want : ");
            choose = RegularExpression.inputInt();
            String name = "";
            int amount = 0;
            int price = 0;
            switch (choose) {
                case 1:
                    name = Constant.MASSAGE;
                    System.out.println("Enter Number of People (50$) : ");
                    amount = RegularExpression.inputInt();
                    price = 50;
                    break;
                case 2:
                    name = Constant.KARAOKE;
                    System.out.println("Enter Number of Room (500$) : ");
                    amount = RegularExpression.inputInt();
                    price = 500;
                    break;
                case 3:
                    name = Constant.FOOD;
                    System.out.println("Enter Number of Meals (25$) : ");
                    amount = RegularExpression.inputInt();
                    price = 25;
                    break;
                case 4:
                    int choice;
                    name = Constant.DRINKS;
                    do {
                        System.out.println("1.Alcohol (500$)");
                        System.out.println("2.Beer (120$)");
                        System.out.println("3.Juice (20$)");
                        System.out.println("4.Back to Menu");
                        System.out.println("Enter Type of Drinks : ");
                        choice = RegularExpression.inputInt();
                        switch (choice) {
                            case 1:
                                System.out.println("Enter Number of Bottle : ");
                                amount = RegularExpression.inputInt();
                                price = 500;
                                break;
                            case 2:
                                System.out.println("Enter Number of Barrel : ");
                                amount = RegularExpression.inputInt();
                                price = 120;
                                break;
                            case 3:
                                System.out.println("Enter Number of Bottle : ");
                                amount = RegularExpression.inputInt();
                                price = 20;
                                break;
                            case 4:
                                System.out.println();
                                break;
                            default:
                                System.err.println(Constant.CHOOSE_ERROR);
                        }
                    } while (choice != 4);
                case 5:
                    name = Constant.CAR;
                    System.out.println("Enter Number of Car (1000$/day) : ");
                    amount = RegularExpression.inputInt();
                    price = 1000;
                    break;
                case 6:
                    isBooking = false;
                    System.out.println("");
                    break;
                default:
                    System.err.println(Constant.CHOOSE_ERROR);
            }
            if (isBooking){
                ServiceExtend serviceExtend = new ServiceExtend(name, amount, price);
                customerList.get(indexCustomer).addServiceExtend(serviceExtend);
            }
        } while (choose != 6);
        update(customerList);
    }

    public void delete(int index){
        List<Customer> list = getCustomerList();
        list.remove(index);
        if (list.size() != 0){
            update(list);
        } else {
            controllerUtility.writeNull();
            System.out.println("0 customer left!");
        }
    }

    private boolean isLoopService(Services services) {
        List<Booking> bookingList = controllerUtility.getBookingList();
        for (Booking booking : bookingList) {
            if (booking.getIdService().equals(services.getId())
                    && isOutOfDate(booking.getDateEnd())) {
                return true;
            }
        }
        return false;
    }

    private boolean isOutOfDate(String dateEnd) {
        Date now = new Date();
        String dateTerm = now.getDate() + "/" + (now.getMonth() + 1) + "/" + (now.getYear() + 1900);
        String[] dateEndArr = dateEnd.split("/");
        String[] dateTermArr = dateTerm.split("/");
        Date dateEndD = new Date(Integer.parseInt(dateEndArr[2]), Integer.parseInt(dateEndArr[1]),
                Integer.parseInt(dateEndArr[0]));
        Date dateTermD = new Date(Integer.parseInt(dateTermArr[2]), Integer.parseInt(dateTermArr[1]),
                Integer.parseInt(dateTermArr[0]));
        return dateEndD.getTime() >= dateTermD.getTime();
    }

    public void bookingVilla(int indexCustomer, int indexVilla) {
        bookingService(indexCustomer, getVillaList().get(indexVilla));
    }

    public void bookingHouse(int indexCustomer, int indexRoom) {
        bookingService(indexCustomer, getHouseList().get(indexRoom));
    }

    public void bookingRoom(int indexCustomer, int indexRoom) {
        bookingService(indexCustomer, getRoomList().get(indexRoom));
    }

    private void bookingService(int index, Services services) {
        if (isLoopService(services)) {
            System.out.println("Services was rent by other person");
        } else {
            List<Customer> customerList = getCustomerList();
            Customer customer = customerList.get(index);
            System.out.println("Enter Day Rent : ");
            int date = RegularExpression.inputInt();
            String dateTerm = getDateTerm(date);
            customer.setBooking(services);
            customer.getBooking().setDateEnd(dateTerm);
            controllerUtility.writeDataFromBooking(customer.getBooking(), true);
            customer.setPayment((services.getCost() * date)+customer.getPayment());
            customerList.set(index,customer);
            update(customerList);
        }
    }

    private String getDateTerm(int date) {
        Date now = new Date();
        int day = now.getDate() + date;
        int month = now.getMonth() + 1;
        int year = now.getYear() + 1900;
        int dayMax = getDayMax(month, year);
        if (day > dayMax) {
            day -= dayMax;
            if (month == 12) {
                month = 1;
                year += 1;
            } else {
                month += 1;
            }
        }
        return day + "/" + month + "/" + year;
    }

    private int getDayMax(int month, int year) {
        int dayMax;
        switch (month) {
            case 2:
                dayMax = 28;
                if (RegularExpression.isLeapYear(year)) {
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
                dayMax = 0;
        }
        return dayMax;
    }

    public void showCustomersName(boolean isSort) {
        SortCustomerByName sortCustomerByName = new SortCustomerByName();
        List<Customer> customerList = getCustomerList();
        if (isSort) {
            customerList.sort(sortCustomerByName);
        }
        for (int i = 0; i < customerList.size(); i++) {
            System.out.print(i + 1 + ".");
            customerList.get(i).showInformationCustomer();
        }
    }

    public void showInformationCustomer(int index) {
        System.out.println(getCustomerList().get(index));
    }

    public void showAllPayment() {
        for (int i = 0; i < getCustomerList().size(); i++) {
            System.out.println(i + 1 + "." + getCustomerList().get(i).getName() + " - " + getCustomerList().get(i).getPayment() + "$");
        }
        System.out.println("================================");
    }

    public void showPayment(int index) {
        System.out.println(getCustomerList().get(index).getName() + " - " + getCustomerList().get(index).getPayment());
    }

    public void editCustomer(int index) {
        int choose;
        List<Customer> list = getCustomerList();
        Customer customer = list.get(index);
        do {
            System.out.println("1." + customer.getName());
            System.out.println("2." + customer.getBirthDay());
            System.out.println("3." + customer.getGender());
            System.out.println("4." + customer.getIdentityNumber());
            System.out.println("5." + customer.getPhoneNumber());
            System.out.println("6." + customer.getEmail());
            System.out.println("7." + customer.getType());
            System.out.println("8." + customer.getAddress());
            System.out.println("9.Back to Menu");
            System.out.println("0.Exit Program");
            choose = RegularExpression.inputInt();
            switch (choose) {
                case 1:
                    String name = getName();
                    customer.setName(name);
                    break;
                case 2:
                    String birthday = getDateOfBirth();
                    customer.setBirthDay(birthday);
                    break;
                case 3:
                    String gender = getGender();
                    customer.setGender(gender);
                    break;
                case 4:
                    String identityNumber = getIdentity("Cus");
                    customer.setIdentityNumber(identityNumber);
                    break;
                case 5:
                    String phoneNumber = getPhoneNumber();
                    customer.setPhoneNumber(phoneNumber);
                    break;
                case 6:
                    String email = getEmail();
                    customer.setEmail(email);
                    break;
                case 7:
                    String type = getType();
                    customer.setType(type);
                    break;
                case 8:
                    String address = getAddress();
                    customer.setAddress(address);
                    break;
                case 9:
                    System.out.println("");
                    break;
                case 0:
                    System.out.println(Constant.SEE_YOU_LATER);
                    System.exit(0);
            }
            update(list);
            if (choose != 9) {
                System.out.println("Edit Success.");
            }
        } while (choose != 9);
    }

    private void update(List<Customer> list) {
        boolean isAdd = false;
        for (Customer value : list) {
            controllerUtility.writeDataFromCustomer(value, isAdd);
            isAdd = true;
        }
    }

    public void showBooking() {
        for (int i = 0; i < controllerUtility.getStringBookingList().size(); i++) {
            System.out.println(controllerUtility.getStringBookingList().get(i));
        }
    }

    public List<Customer> getCustomerList() {
        return controllerUtility.getCustomerList();
    }

    private List<Villa> getVillaList() {
        return controllerUtility.getVillaList();
    }

    private List<House> getHouseList() {
        return controllerUtility.getHouseList();
    }

    private List<Room> getRoomList() {
        return controllerUtility.getRoomList();
    }

    public List<Booking> getBookingList() {
        return controllerUtility.getBookingList();
    }
}
