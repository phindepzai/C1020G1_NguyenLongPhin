package bai3_array_methods.baitap;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfCol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số lượng hàng của ma trận : ");
        int row = scanner.nextInt();
        System.out.println("Nhập vào số lượng cột của ma trận : ");
        int col = scanner.nextInt();
        int matrix[][] = new int[row][col];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("matrix[%d][%d] : ", i, j);
                matrix[i][j] = scanner.nextInt();
            }
        }
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.printf("Nhập vào cột mà bạn muốn xóa (0 -> %d) : \n", matrix[0].length - 1);
        int colChoose = scanner.nextInt();
        int sumCol = 0;
        for (int i = 0; i < matrix.length; i++) {
            sumCol += matrix[i][colChoose];
        }
        System.out.println("Tổng các số ở cột số " + colChoose + " là : " + sumCol);
    }
}
