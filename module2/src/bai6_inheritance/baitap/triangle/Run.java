package bai6_inheritance.baitap.triangle;

public class Run {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3,4,5);
        triangle.setColor("blue");
        System.out.println(triangle.toString());
        System.out.println(triangle.getArea());
        System.out.println(triangle.getPerimeter());
    }
}
