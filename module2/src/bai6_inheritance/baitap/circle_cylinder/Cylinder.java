package bai6_inheritance.baitap.circle_cylinder;

public class Cylinder extends Circle{
    private double height;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(){
        this(1.0);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return 2 * Math.PI * getRadius() *(getRadius() + height);
    }

    public double getVolume(){
        return height * Math.PI * Math.pow(getRadius(),2);
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "radius=" + getRadius() +
                ",height=" + height +
                ",area=" + getArea() +
                ",volume=" + getVolume() +
                '}';
    }
}
