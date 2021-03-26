package bai2_loopstatement.thuchanh;

import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số thứ nhất : ");
        int num1 = scanner.nextInt();
        System.out.println("Nhập số thứ hai : ");
        int num2 = scanner.nextInt();
        int min = num2;
        int gcd = 1;
        if (num1 < num2){
            min = num1;
        }
        for (int i = 1; i <= min; i++) {
            if (num1 % i == 0 && num2 % i == 0){
                gcd = i;
            }
        }
        System.out.println("Ước chung lớn nhất của 2 số trên là : "+gcd);
    }
}
