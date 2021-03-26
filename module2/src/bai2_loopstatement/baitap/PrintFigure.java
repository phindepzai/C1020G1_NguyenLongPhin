package bai2_loopstatement.baitap;

import java.util.Scanner;

public class PrintFigure {
    public static void drawTriangle(){
        for (int i = 6; i > 0; i--) {
            for (int j = 6 - i; j < 6; j++) {
                System.out.print("*  ");
            }
            System.out.println();
        }
    }
    public static void drawSquare(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print("*  ");
            }
            System.out.println();
        }
    }
    public static void drawRectangle(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print("*  ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int choose;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Menu");
            System.out.println("1. Draw the triangle");
            System.out.println("2. Draw the square");
            System.out.println("3. Draw the rectangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choose: ");
            choose = scanner.nextInt();
            switch (choose){
                case 1:
                    drawTriangle();
                    break;
                case 2:
                    drawSquare();
                    break;
                case 3:
                    drawRectangle();
                    break;
                case 0:
                    System.out.println("Your choose was invalid");
            }
        }while (choose != 0);
    }
}
