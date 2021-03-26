package models;

public class House extends Services {
    private String standard;
    private String convenientDescription;
    private int numOfFloor;

    public House(String name, String id, double area, int cost, int quantityMax, String rentType) {
        super(name, id, area, cost, quantityMax, rentType);
    }

    public House(String name, String id, double area, int cost, int quantityMax, String rentType, String standard,
                 String convenientDescription, int numOfFloor) {
        super(name, id, area, cost, quantityMax, rentType);
        this.standard = standard;
        this.convenientDescription = convenientDescription;
        this.numOfFloor = numOfFloor;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getConvenientDescription() {
        return convenientDescription;
    }

    public void setConvenientDescription(String convenientDescription) {
        this.convenientDescription = convenientDescription;
    }

    public int getNumOfFloor() {
        return numOfFloor;
    }

    public void setNumOfFloor(int numOfFloor) {
        this.numOfFloor = numOfFloor;
    }

    public void set(String standard, String convenientDesciption, int numOfFloor) {
        this.standard = standard;
        this.convenientDescription = convenientDesciption;
        this.numOfFloor = numOfFloor;
    }

    @Override
    public void showInfo() {
        System.out.println(super.toString());
        System.out.println("7.Standard = " + standard);
        System.out.println("8.ConvenientDescription = " + convenientDescription);
        System.out.println("9.NumOfFloor = " + numOfFloor);
    }

    @Override
    public String toString() {
        return  "\nName : " + getName() +
                "\nID : " + getId() +
                "\nArea : " + getArea() +
                "\nCost : " + getCost() +
                "\nQuantity Max : " + getQuantityMax() +
                "\nRentType : " + getRentType() +
                "\nStandard : " + standard +
                "\nConvenient Description : " + convenientDescription +
                "\nNum of Floor : " + numOfFloor;
    }
}
