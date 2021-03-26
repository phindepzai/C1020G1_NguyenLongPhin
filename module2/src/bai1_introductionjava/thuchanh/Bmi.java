package bai1_introductionjava.thuchanh;

import java.util.Scanner;

public class Bmi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input weight : ");
        int weight = scanner.nextInt();
        System.out.println("Input height : ");
        float height = scanner.nextFloat();
        float bmi = weight / (height * height);
        System.out.println(bmi);
    }
}
