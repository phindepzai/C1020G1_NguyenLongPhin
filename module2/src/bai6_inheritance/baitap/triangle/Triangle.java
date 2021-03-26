package bai6_inheritance.baitap.triangle;

import bai6_inheritance.thuchanh.shape.Shape;

public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle() {
        this(1.0, 1.0, 1.0);
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getArea() {
        double p = getHeron();
        double temp = p * (p - side1) * (p - side2) * (p - side3);
        return Math.pow(temp,0.5);
    }

    public double getPerimeter(){
        return getHeron() * 2;
    }

    public double getHeron() {
        return (side1 + side2 + side3) / 2;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                ", color=" + getColor() +
                '}';
    }
}
