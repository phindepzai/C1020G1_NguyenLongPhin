package bai3_array_methods.baitap;

import java.util.Arrays;
import java.util.Scanner;

public class FindMaxInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số hàng của ma trận ");
        int row = scanner.nextInt();
        System.out.println("Nhập vào số cột của ma trận ");
        int col = scanner.nextInt();
        int matrix[][] = new int[row][col];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("Nhập vào matrix[%d][%d] : ",i,j);
                matrix[i][j] = scanner.nextInt();
            }
        }
        int max = matrix[0][0];
        for (int arr[]:matrix) {
            for (int element:arr) {
                if (element > max){
                    max = element;
                }
            }
        }
        System.out.println("Phần tử lớn nhất trong ma trận là là : "+max);
    }
}
