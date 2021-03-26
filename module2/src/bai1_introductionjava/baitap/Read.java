package bai1_introductionjava.baitap;

import java.util.Scanner;

public class Read {
    public static String getNumStr(int num, boolean isTen) {
        String str = "";
        switch (num) {
            case 1:
                str = " one";
                if (isTen) {
                    str = " ";
                }
                break;
            case 2:
                str = " two";
                if (isTen) {
                    str = " twenty";
                }
                break;
            case 3:
                str = " three";
                if (isTen) {
                    str = " thirty";
                }
                break;
            case 4:
                str = " four";
                if (isTen) {
                    str += "ty";
                }
                break;
            case 5:
                str = " five";
                if (isTen) {
                    str = " fifty";
                }
                break;
            case 6:
                str = " six";
                if (isTen) {
                    str += "ty";
                }
                break;
            case 7:
                str = " seven";
                if (isTen) {
                    str += "ty";
                }
                break;
            case 8:
                str = " eight";
                if (isTen) {
                    str += "y";
                }
                break;
            case 9:
                str = " nine";
                if (isTen) {
                    str += "ty";
                }
                break;
        }
        return str;
    }
    public static String getTens(int num){
        String result = "";
        switch (num) {
            case 10:
                result = "ten";
                return result;
            case 11:
                result = "eleven";
                return result;
            case 12:
                result = "twelve";
                return result;
            case 13:
                result = "thirteen";
                return result;
            case 15:
                result = "fifteen";
                return result;
            case 14:
                result = "fourteen";
                return result;
            case 16:
                result = "sixteen";
                return result;
            case 17:
                result = "seventeen";
                return result;
            case 18:
                result = "eighteen";
                return result;
            case 19:
                result = " nineteen";
                return result;
        }
        return "";
    }
    public static String getStr(int number){
        int ones;
        int tens;
        int hundred;
        String result = "";
        if (number == 0){
            result = "zero";
        } else if (number < 10) {
            result = getNumStr(number, false);
        } else if (number < 100) {
            tens = number / 10;
            ones = number % 10;
            result = getNumStr(tens, true);
            result += getNumStr(ones, false);
            if (number < 20){
                result = getTens(number);
            }
        } else {
            hundred = number / 100;
            result = getNumStr(hundred, false) + " hundred and ";
            if ((number % 100) < 20){
                result += getTens(number % 100);
                return result;
            }
            result += getNumStr(((number / 10) % 10), true);
            result += getNumStr(number % 10, false);
        }
        return result;
    }

    public static void main(String[] args) {
        String result = "";
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.println("Nhập vào số cần đọc : ");
            number = scanner.nextInt();
            if (number < 0 || number > 999){
                System.out.println("Số bạn vừa nhập nhỏ hơn 0 hoặc lớn hơn 999");
            }else {
                break;
            }
        } while (true);
        result = getStr(number).trim();
        System.out.println(result);
    }
}
