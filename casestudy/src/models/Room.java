package models;

public class Room extends Services {


    public Room(String name, String id, double area, int cost, int quantityMax, String rentType) {
        super(name, id, area, cost, quantityMax, rentType);
    }

    @Override
    public void showInfo() {
        System.out.println(super.toString());
    }

    @Override
    public String toString() {
        return  "\nName : " + getName() +
                "\nID : " + getId() +
                "\nArea : " + getArea() +
                "\nCost : " + getCost() +
                "\nQuantity Max : " + getQuantityMax() +
                "\nRentType : " + getRentType();
    }
}
