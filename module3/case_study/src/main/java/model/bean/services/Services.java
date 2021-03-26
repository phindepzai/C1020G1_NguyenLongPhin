package model.bean.services;

public abstract class Services {
    private int id;
    private String name;
    private double area;
    private int cost;
    private int quantityMax;
    private ServiceType serviceType;
    private RentType rentType;

    public Services(int id, String name, double area, int cost, int quantityMax, ServiceType serviceType, RentType rentType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.quantityMax = quantityMax;
        this.serviceType = serviceType;
        this.rentType = rentType;
    }

    public Services(String name, double area, int cost, int quantityMax, ServiceType serviceType, RentType rentType) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.quantityMax = quantityMax;
        this.serviceType = serviceType;
        this.rentType = rentType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getQuantityMax() {
        return quantityMax;
    }

    public void setQuantityMax(int quantityMax) {
        this.quantityMax = quantityMax;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }
}
