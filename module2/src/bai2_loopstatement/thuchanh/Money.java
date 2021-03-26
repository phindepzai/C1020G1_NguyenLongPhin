package bai2_loopstatement.thuchanh;

import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter investment amount: ");
        double money = scanner.nextDouble();
        System.out.println("Enter number of months: ");
        int month = scanner.nextInt();
        System.out.println("Enter annual interest rate in percentage: ");
        double interest = scanner.nextFloat();
        double total = 0;
        for(int i = 0; i < month; i++){
            total = money * (interest/100)/12 * month;
        }
        System.out.println("Total of interset: " + total);
    }
}
