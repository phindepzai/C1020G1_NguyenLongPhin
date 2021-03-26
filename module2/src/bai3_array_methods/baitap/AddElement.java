package bai3_array_methods.baitap;

import java.util.Scanner;

public class AddElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index;
        System.out.println("Nhập vào số lượng phần tử trong mảng : ");
        int length = scanner.nextInt();
        int arr[] = new int[length + 1];
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println("Nhập phần tử thứ " + i);
            arr[i] = scanner.nextInt();
        }
        System.out.println("Mảng trước khi thêm : ");
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i]+"\t");
        }
        do {
            System.out.println("\nNhập vào vị trí phần tử muốn thêm vào (từ 1 -> length) : ");
            index = scanner.nextInt();
        } while (index < 0 || index > length);
        System.out.println("Nhập vào giá trị phần tử muốn thêm vào : ");
        int value = scanner.nextInt();
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
        System.out.println("Mảng sau khi thêm : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
    }
}
