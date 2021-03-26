package bai6_inheritance.baitap.point;

import java.util.Arrays;

public class Run {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        Point3D point3D = new Point3D();
        System.out.println(point2D.toString());
        System.out.println(Arrays.toString(point2D.getXY()));
        System.out.println(point3D.toString());
        System.out.println(Arrays.toString(point3D.getXYZ()));
    }
}
