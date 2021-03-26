package bai3_array_methods.baitap;

import java.util.Scanner;

public class SumOfDiagonal {
    public static int getSumWest(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

    public static int getSumEast(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i + j == matrix.length - 1) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số lượng hàng và cột của ma trận vuông : ");
        int row = scanner.nextInt();
        int matrix[][] = new int[row][row];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("matrix[%d][%d] : ", i, j);
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Bạn muốn tính tổng đường chéo từ hướng nào?");
        System.out.println("1.Tây bắc -> đông nam");
        System.out.println("2.Đông bắc -> tây nam");
        int choose = scanner.nextInt();
        int sum = 0;
        String direction = "";
        switch (choose) {
            case 1:
                sum = getSumWest(matrix);
                direction = "Trái";
                break;
            case 2:
                sum = getSumEast(matrix);
                direction = "Phải";
                break;
        }
        System.out.printf("Tổng của các số thuộc đường chéo từ bên %s phía trên : %d", direction, sum);
    }
}
