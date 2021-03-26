package model.bean.services;

public class House extends Services {
    private String standardRoom;
    private String descriptionOtherConvenience;
    private int numOfFloor;


    public House(int id, String name, double area, int cost, int quantityMax, ServiceType serviceType, RentType rentType, String standardRoom, String descriptionOtherConvenience, int numOfFloor) {
        super(id, name, area, cost, quantityMax, serviceType, rentType);
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.numOfFloor = numOfFloor;
    }

    public House(String name, double area, int cost, int quantityMax, ServiceType serviceType, RentType rentType, String standardRoom, String descriptionOtherConvenience, int numOfFloor) {
        super(name, area, cost, quantityMax, serviceType, rentType);
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.numOfFloor = numOfFloor;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public int getNumOfFloor() {
        return numOfFloor;
    }

    public void setNumOfFloor(int numOfFloor) {
        this.numOfFloor = numOfFloor;
    }
}
