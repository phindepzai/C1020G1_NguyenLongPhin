package bai3_array_methods.baitap;

import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int indexDelete = -1;
        System.out.println("Nhập vào số lượng phần tử trong mảng : ");
        int length = scanner.nextInt();
        int arr[] = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.println("Nhập vào phần tử thứ "+(i+1));
            arr[i] = scanner.nextInt();
        }
        do {
            System.out.println("Nhập vào phần tử cần xóa : ");
            int ele = scanner.nextInt();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == ele){
                    indexDelete = i;
                    break;
                }
            }
            if (indexDelete == -1){
                System.out.println("Phần tử "+ele+" không có trong mảng!\nVui lòng nhập lại.");
            }
        }while (indexDelete == -1);
        System.out.println("Mảng trước khi xóa : ");
        for (int element:arr) {
            System.out.print(element+"\t");
        }
        System.out.println();
        for (int i = indexDelete; i < length; i++) {
            if (i == length - 1){
                arr[i] = 0;
                break;
            }
            arr[i] = arr[i+1];
        }
        System.out.println("Mảng sau khi xóa : ");
        for (int element:arr) {
            System.out.print(element+"\t");
        }
    }
}
