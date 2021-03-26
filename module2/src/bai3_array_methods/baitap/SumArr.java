package bai3_array_methods.baitap;

import java.util.Scanner;

public class SumArr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập độ dài của mảng thứ nhất : ");
        int length = scanner.nextInt();
        int arr1[] = new int[length];
        for (int i = 0; i < arr1.length; i++) {
            System.out.println("Nhập vào phần tử thứ "+(i+1));
            arr1[i] = scanner.nextInt();
        }
        System.out.println("Nhập độ dài của mảng thứ 2 ");
        length = scanner.nextInt();
        int arr2[] = new int[length];
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("Nhập vào phần tử thứ "+(i+1));
            arr2[i] = scanner.nextInt();
        }
        int arr3[] = new int[arr1.length + arr2.length];
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
        }
        for (int i = arr1.length; i < arr3.length; i++) {
            arr3[i] = arr2[count];
            count++;
        }
        for (int element:arr3) {
            System.out.print(element+"\t");
        }
    }
}
