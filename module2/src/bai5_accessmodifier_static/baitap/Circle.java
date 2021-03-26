package bai5_accessmodifier_static.baitap;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    protected Circle(double radius) {
        this.radius = radius;
    }

    protected Circle() {
    }

    private double getRadius() {
        return radius;
    }
    public double getArea(){
        return Math.PI * Math.pow(radius,2);
    }
}
