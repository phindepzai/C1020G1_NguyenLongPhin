package bai7_abstract_interface.baitap.resizeable;

public class Run {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(3.0);
        circle.resize(0.5);
        System.out.println(circle.getRadius());
    }
}
