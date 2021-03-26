package bai4_oop.thuchanh.rectangle;

public class Rectangle {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle() {
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return height * width;
    }

    public int getPerimeter() {
        return (height + width) * 2;
    }

    public String display() {
        return "Rectangle{" + " width = " + width + " , height = " + height + " }";
    }
}
