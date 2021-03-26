package bai2_loopstatement.baitap;

import java.util.Arrays;
import java.util.Scanner;

public class PrintPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount prime number to print : ");
        int amount = scanner.nextInt();
        System.out.println(Arrays.toString(printPrime(amount)));
    }

    public static int[] printPrime(int amount) {
        int[] arr = new int[amount];
        int count = 0;
        int num = 2;
        while (count < amount){
            int c = 0;
            for (int i = 1; i <= num; i++) {
                if (num % i == 0){
                    c++;
                }
            }
            if (c == 2){
                arr[count] = num;
                count++;
            }
            num++;
        }
        return arr;
    }
}
