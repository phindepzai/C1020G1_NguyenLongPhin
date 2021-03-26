package model.bean.services;

public class Villa extends Services {
    private String standardRoom;
    private String descriptionOtherConvenience;
    private double poolArea;
    private int numOfFloor;


    public Villa(int id, String name, double area, int cost, int quantityMax, ServiceType serviceType, RentType rentType, String standardRoom, String descriptionOtherConvenience, double poolArea, int numOfFloor) {
        super(id, name, area, cost, quantityMax, serviceType, rentType);
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numOfFloor = numOfFloor;
    }

    public Villa(String name, double area, int cost, int quantityMax, ServiceType serviceType, RentType rentType, String standardRoom, String descriptionOtherConvenience, double poolArea, int numOfFloor) {
        super(name, area, cost, quantityMax, serviceType, rentType);
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
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

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumOfFloor() {
        return numOfFloor;
    }

    public void setNumOfFloor(int numOfFloor) {
        this.numOfFloor = numOfFloor;
    }
}
