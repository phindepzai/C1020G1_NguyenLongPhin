package bai7_abstract_interface.baitap.shape_colorable;

import bai6_inheritance.thuchanh.shape.Shape;

public class Square extends Shape implements Colorable {
    private double side;

    public Square(String color, boolean filled, double side) {
        super(color, filled);
        this.side = side;
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(){
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public void howtoColor() {
        System.out.println(getColor()+" all four side");
    }
}
