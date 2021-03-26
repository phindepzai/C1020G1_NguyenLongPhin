package bai6_inheritance.thuchanh.shape;

public class Run {
    public static void main(String[] args) {
        Square square = new Square();
        square.setHeight(10);
        System.out.println(square.getArea());
        System.out.println(square.getPerimeter());
        System.out.println(square);
    }
}
