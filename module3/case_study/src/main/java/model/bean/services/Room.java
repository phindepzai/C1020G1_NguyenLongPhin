package model.bean.services;

public class Room extends Services {
    private int attachServiceFreeID;


    public Room(int id, String name, double area, int cost, int quantityMax, ServiceType serviceType, RentType rentType) {
        super(id, name, area, cost, quantityMax, serviceType, rentType);
        this.attachServiceFreeID = 1;
    }

    public Room(String name, double area, int cost, int quantityMax, ServiceType serviceType, RentType rentType) {
        super(name, area, cost, quantityMax, serviceType, rentType);
        this.attachServiceFreeID = 1;
    }

    public int getAttachServiceFreeID() {
        return attachServiceFreeID;
    }

    public void setAttachServiceFreeID(int attachServiceFreeID) {
        this.attachServiceFreeID = attachServiceFreeID;
    }
}
