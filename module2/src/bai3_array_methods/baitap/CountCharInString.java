package bai3_array_methods.baitap;

import java.util.Scanner;

public class CountCharInString {
    public static void main(String[] args) {
        char[] charArr;
        String str = "123o1k2n3k1n2o30910jd1lk2nlk1nl2sldkfoqiwpnanspfr";
        int count = 0;
        char charInput;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Nhập vào kí tự bất kì (1 kí tự)");
            String input = scanner.nextLine();
            charArr = input.toCharArray();
            charInput = charArr[0];
        } while (charArr.length != 1);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == charInput){
                count++;
            }
        }
        System.out.printf("số lần xuất hiện của %c : %d",charInput,count);
    }
}
