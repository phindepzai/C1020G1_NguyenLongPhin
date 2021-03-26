package models;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String birthDay;
    private String gender;
    private String identityNumber;
    private String phoneNumber;
    private String email;
    private String type;
    private String address;
    private Booking booking;
    private int payment;
    private List<ServiceExtend> serviceExtendList;

    public Customer(String name, String birthDay, String gender, String identityNumber, String phoneNumber,
                    String email, String type, String address , int payment) {
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.identityNumber = identityNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.type = type;
        this.address = address;
        this.payment = payment;
        serviceExtendList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBooking(Services services) {
        this.booking = new Booking(this.name, this.identityNumber, services.getName(), services.getId());
    }

    public Booking getBooking() {
        return booking;
    }

    public void showInformationCustomer() {
        System.out.println("\t" + name + "\t" + birthDay + "\t" + gender + "\t" + identityNumber + "\t" + phoneNumber + "\t" +
                email + "\t" + type + "\t" + address);
    }

    public void addServiceExtend(ServiceExtend serviceExtend){
        serviceExtendList.add(serviceExtend);
    }

    public List<ServiceExtend> getServiceExtendList() {
        return serviceExtendList;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getPayment() {
        int bonus = 0;
        if (!(serviceExtendList.size() == 0)){
            for (ServiceExtend serviceExtend : serviceExtendList) {
                bonus += serviceExtend.getCost();
            }
        }
        return payment + bonus;
    }

    @Override
    public String toString() {
        return "\nName = " + name +
                "\nBirthDay = " + birthDay +
                "\nGender = " + gender +
                "\nIdentityNumber = " + identityNumber +
                "\nPhoneNumber = " + phoneNumber +
                "\nEmail = " + email +
                "\nType = " + type +
                "\nAddress = " + address;
    }
}
