package bai4_oop.baitap.quadratic_equation;

import java.util.Date;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào a : ");
        double a = scanner.nextDouble();
        System.out.println("Nhập vào b : ");
        double b = scanner.nextDouble();
        System.out.println("Nhập vào c : ");
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);
        if (quadraticEquation.getDiscriminant() < 0){
            System.out.println("Phương trình vô nghiệm!");
        }else {
            System.out.println("Nghiệm thứ 1 của phương trình là : "+quadraticEquation.getRoot1());
            System.out.println("Nghiệm thứ 2 của phương trình là : "+quadraticEquation.getRoot2());
        }
    }
}
