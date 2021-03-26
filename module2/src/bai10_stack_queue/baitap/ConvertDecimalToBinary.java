package bai10_stack_queue.baitap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ConvertDecimalToBinary {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        boolean isLoop = false;
        do {
            System.out.println("Nhập vào lựa chọn của bạn : ");
            System.out.println("1.Chuyển đổi từ hệ thập phân sang hệ nhị phân");
            System.out.println("2.Chuyển đổi từ hệ nhị phân sang hệ thập phân");
            System.out.println("3.Chuyển đổi từ hệ thập phân sang hệ 16");
            System.out.println("4.Chuyển đổi từ hệ 16 sang hệ thập phân");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    changeDecimalToBinary();
                    break;
                case 2:
                    changeBinaryToDecimal();
                    break;
                case 3:
                    changeDecimalToHexa();
                    break;
                case 4:
                    changeHexaToDecimal();
                    break;
                default:
                    System.err.println("Choose error!");
                    isLoop = true;
            }
        } while (isLoop);
    }

    private static void changeHexaToDecimal() {
        System.out.println("Nhập vào 1 số hệ thập lục phân bất kì : ");
        scanner.nextLine();
        String num = scanner.nextLine();
        int decimal = 0;
        for (int i = 0; i < num.length(); i++) {
            int temp = 0;
            double hex = Math.pow(16, i);
            temp = getTemp(num, i);
            decimal += temp * hex;
        }
        System.out.println(decimal);
    }

    private static int getTemp(String num, int i) {
        int temp;
        switch (num.charAt(num.length() - i - 1)) {
            case 'a':
                temp = 10;
                break;
            case 'b':
                temp = 11;
                break;
            case 'c':
                temp = 12;
                break;
            case 'd':
                temp = 13;
                break;
            case 'e':
                temp = 14;
                break;
            case 'f':
                temp = 15;
                break;
            default:
                temp = Integer.parseInt(num.charAt(num.length() - i - 1) + "");
        }
        return temp;
    }

    private static void changeDecimalToHexa() {
        System.out.println("Nhập vào 1 số hệ thập phân bất kì : ");
        int num = scanner.nextInt();
        String hex = "";
        Queue<String> myQueue = new LinkedList<>();
        while (num > 0) {
            int count = 0;
            double pow = Math.pow(16, getPow(num));
            if (num > 15){
                int i = (int) (num / pow);
                hex += getString(i);
                num -= pow * i;
            } else {
                hex += getString(num);
                num = 0;
            }
        }
        System.out.println(hex);
    }

    private static String getString(int so) {
        String temp = "";
        switch (so) {
            case 10:
                temp = "a";
                break;
            case 11:
                temp = "b";
                break;
            case 12:
                temp = "c";
                break;
            case 13:
                temp = "d";
                break;
            case 14:
                temp = "e";
                break;
            case 15:
                temp = "f";
                break;
            default:
                temp = so +"";
                break;
        }
        return temp;
    }

    private static int getPow(int num) {
        if (num >= Math.pow(16, 5)) {
            return 5;
        } else if (num >= Math.pow(16, 4)) {
            return 4;
        } else if (num >= Math.pow(16, 3)) {
            return 3;
        } else if (num >= Math.pow(16, 2)) {
            return 2;
        }
        return 1;
    }

    private static void changeBinaryToDecimal() {
        System.out.println("Nhập vào 1 số hệ thập phân bất kì : ");
        int num = scanner.nextInt();
        int decimal = 0;
        String str = num + "";
        for (int i = 0; i < str.length(); i++) {
            decimal += Integer.parseInt(str.charAt(str.length() - i - 1) + "") * Math.pow(2, i);
        }
        System.out.println(decimal);
    }

    private static void changeDecimalToBinary() {
        System.out.println("Nhập vào 1 số hệ thập phân bất kì : ");
        int num = scanner.nextInt();
        String str = "";
        Stack<Integer> myStack = new Stack<>();
        while (num > 0) {
            myStack.push(num % 2);
            num /= 2;
        }
        for (int i = 0; i < myStack.size(); ) {
            str += myStack.pop();
        }
        System.out.println(str);
    }
}
