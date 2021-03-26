package models;

public abstract class Services {
    private String name;
    private double area;
    private int cost;
    private int quantityMax;
    private String rentType;
    private String id;

    public Services(String name, String id, double area, int cost, int quantityMax, String rentType) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.quantityMax = quantityMax;
        this.rentType = rentType;
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

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void callServiceExtend() {

    }

    public abstract void showInfo();

    @Override
    public String toString() {
        return "\n1.Name : " + name +
                "\n2.ID = " + id +
                "\n3.Area : " + area +
                "\n4.Cost : " + cost +
                "\n4.QuantityMax : " + quantityMax +
                "\n5.RentType : " + rentType;
    }
}
