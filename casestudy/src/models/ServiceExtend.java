package models;

public class ServiceExtend {
    private String name;
    private int unit;
    private int price;

    public ServiceExtend(String name, int unit, int price) {
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    public int getCost() {
        return price * unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
