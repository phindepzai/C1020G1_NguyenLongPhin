package bai16_io_binaryfile.baitap;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private String manufacturer;
    private int price;
    private String description;

    public Product(String id, String name, String manufacturer, int price, String description) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
