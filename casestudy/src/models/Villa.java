package models;

public class Villa extends Services {
    private String standard;
    private String convenientDescription;
    private double areaPool;
    private int numOfFloor;

    public Villa(String name, String id, double area, int cost, int quantityMax, String rentType) {
        super(name, id, area, cost, quantityMax, rentType);
    }

    public Villa(String name, String id, double area, int cost, int quantityMax, String rentType, String standard,
                 String convenientDescription, double areaPool, int numOfFloor) {
        super(name, id, area, cost, quantityMax, rentType);
        this.standard = standard;
        this.convenientDescription = convenientDescription;
        this.areaPool = areaPool;
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

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumOfFloor() {
        return numOfFloor;
    }

    public void setNumOfFloor(int numOfFloor) {
        this.numOfFloor = numOfFloor;
    }

    public void set(String standard, String convenientDescription, double areaPool, int numOfFloor) {
        this.standard = standard;
        this.convenientDescription = convenientDescription;
        this.areaPool = areaPool;
        this.numOfFloor = numOfFloor;
    }

    @Override
    public void showInfo() {
        System.out.println(super.toString());
        System.out.println("7.Standard = " + standard);
        System.out.println("8.ConvenientDescription = " + convenientDescription);
        System.out.println("9.AreaPool = " + areaPool);
        System.out.println("10.NumOfFloor = " + numOfFloor);
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
                "\nAreaPool = " + areaPool +
                "\nNum of Floor : " + numOfFloor;
    }
}
