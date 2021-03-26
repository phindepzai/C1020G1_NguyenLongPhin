package bai6_inheritance.thuchanh.shape;

public class Rectangle extends Shape {
    private double witdh;
    private double height;

    public Rectangle(String color, boolean filled, double witdh, double height) {
        super(color, filled);
        this.witdh = witdh;
        this.height = height;
    }

    public Rectangle(double witdh, double height) {
        this.witdh = witdh;
        this.height = height;
    }

    public Rectangle(){
        this(1.0,1.0);
    }

    public double getWitdh() {
        return witdh;
    }

    public void setWitdh(double witdh) {
        this.witdh = witdh;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getArea() {
        return this.witdh * this.height;
    }

    public double getPerimeter() {
        return 2 * (this.witdh + this.height);
    }

    @Override
    public String toString() {
        return "A Rectangle with width="
                + getWitdh()
                + " and length="
                + getHeight()
                + ", which is a subclass of "
                + super.toString();
    }
}
