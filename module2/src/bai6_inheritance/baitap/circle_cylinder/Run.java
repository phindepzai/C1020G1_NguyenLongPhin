package bai6_inheritance.baitap.circle_cylinder;

public class Run {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Cylinder cylinder = new Cylinder();
        circle.setRadius(3);
        cylinder.setRadius(3);
        cylinder.setHeight(3);
        System.out.println(circle);
        System.out.println(cylinder);
    }
}
