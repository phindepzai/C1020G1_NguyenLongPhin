package bai14_exception_debug.baitap.iIllegal_triangle_exception;

import java.util.Scanner;

public class TestIllegalTriangleException {
    public static void main(String[] args) throws IllegalTriangleException {
        nhapTamGiac();
    }

    private static void nhapTamGiac() throws IllegalTriangleException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập cạnh a : ");
        int canhA = scanner.nextInt();
        System.out.println("Nhập cạnh b : ");
        int canhB = scanner.nextInt();
        System.out.println("Nhập cạnh c : ");
        int canhC = scanner.nextInt();
        if (canhA < 1 || canhB < 1 || canhC < 1){
            throw new IllegalTriangleException();
        }
        if (canhA + canhB <= canhC || canhA + canhC <= canhB || canhB + canhC <= canhA){
            throw new IllegalTriangleException("tổng 2 cạnh không lớn hơn cạnh còn lại");
        }
    }
}
