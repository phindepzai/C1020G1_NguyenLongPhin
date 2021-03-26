package bai5_accessmodifier_static.thuchanh.static_property;

public class Car {
    private String name;
    private String color;
    private int price;
    private String manufacturingDate;
    public static int amount = 0;

    public Car(String name, String color, int price, String manufacturingDate) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.manufacturingDate = manufacturingDate;
        amount++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(String manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", manufacturingDate='" + manufacturingDate + '\'' +
                '}';
    }
}
