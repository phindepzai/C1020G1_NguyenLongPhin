package bai1_introductionjava.baitap;

import java.util.Scanner;

public class Hello {
    public static boolean checkPhoneNumber(String phone){
        String regex = "(0|84)9[01](\\d{7})";
        return phone.matches(regex);
    }

    public static void main(String[] args) {
        System.out.println(checkPhoneNumber("0909123456"));
    }


}
